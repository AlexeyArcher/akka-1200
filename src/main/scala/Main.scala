

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import core.auth.{ AuthService, JdbcAuthDataStorage }
import core.profiles.{ JdbcUserProfileStorage, UserProfileService }
import http.HttpRoute
import utils.Config
import utils.db.{ DatabaseConnector, DatabaseMigrationManager }

import scala.concurrent.ExecutionContext

object Main extends App {

  def startApplication() = {
    implicit val actorSystem                     = ActorSystem()
    implicit val executor: ExecutionContext      = actorSystem.dispatcher

    val config = Config.load()

    new DatabaseMigrationManager(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    ).migrateDatabaseSchema()

    val databaseConnector = new DatabaseConnector(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    )

    val userProfileStorage = new JdbcUserProfileStorage(databaseConnector)
    val authDataStorage    = new JdbcAuthDataStorage(databaseConnector)

    val usersService = new UserProfileService(userProfileStorage)
    val authService  = new AuthService(authDataStorage, config.secretKey)
    val httpRoute    = new HttpRoute(usersService, authService, config.secretKey)

    Http().newServerAt(config.http.host, config.http.port).bind(httpRoute.route)
  }

  startApplication()

}
