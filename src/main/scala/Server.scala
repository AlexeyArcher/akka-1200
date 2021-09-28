import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import api.usersApi
object Server {
  val content =
    """
      |<html>
      | <head></head>
      | <body>
      |   You've reached the mountain!
      | </body>
      |</html>
    """
  val route =
    pathPrefix("v1") {
      usersApi ~

    } ~ get {
    complete(
      HttpEntity(
        ContentTypes.`text/html(UTF-8)`,
        content
      )
    )
  }
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("Server")

    val host = "0.0.0.0"
    val port: Int = sys.env.getOrElse("PORT", "8080").toInt

    Http().bindAndHandle(route, host, port)
  }
}
