import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http

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
  val route = get {
    complete(
      HttpEntity(
        ContentTypes.`text/html(UTF-8)`,
        content
      )
    )
  }
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("Server")

    // set hostname/port combination
    val host = "0.0.0.0"
    val port: Int = sys.env.getOrElse("PORT", "8080").toInt

    // this actually starts the server
    Http().bindAndHandle(route, host, port)
  }
}
