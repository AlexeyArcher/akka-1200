import akka.http.scaladsl.server.Directives._
import api.usersApi
trait routes extends usersApi {
 val routes = pathPrefix("v1"){
   userApi
 } ~ path("health")(getFromResource("public/index.html"))
}
