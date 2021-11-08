import akka.http.scaladsl.server.Directives._
import api.{usersApi, userApiRu}
trait routes extends usersApi with userApiRu {
 val routes =
     pathPrefix("en") {
       userApi
     }~ pathPrefix("ru") {
       usersApiRu
     }~
       path("health")(getFromResource("public/index.html"))

}
