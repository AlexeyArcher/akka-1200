import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import api.usersApi
object Server extends App with routes{



  implicit val system = ActorSystem("Server")

  val host = "0.0.0.0"
  val port: Int = sys.env.getOrElse("PORT", "8080").toInt

  Http().bindAndHandle(routes, host, port)

}
