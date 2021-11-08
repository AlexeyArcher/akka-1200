package api

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import mappings.JsonMappings
import akka.http.scaladsl.server.Directives._
import spray.json._

trait userApiRu{
  val usersApiRu = {
    (path("users") & get ) {
      complete ("Красивые имена")
    }~
      (path("users"/IntNumber) & get) { id =>
        complete (s"Красивые имена, ${id}")
      }~
      (path("users") & post) { entity(as[String]) { str =>
        complete (s"Должно напечатать ${str}")
      }


      }
  }
}