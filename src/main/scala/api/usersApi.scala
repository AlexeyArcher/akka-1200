package api

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import mappings.JsonMappings
import models.User
import akka.http.scaladsl.server.Directives._
import spray.json._

trait usersApi{
  val userApi =
    (path("users") & get ) {
      complete ("beauty names")
    }~
      (path("users"/IntNumber) & get) { id =>
        complete (s"beauty names, ${id}")
      }~
      (path("users") & post) { entity(as[String]) { str =>
        complete (s"should print ${str}")
      }
      }~
      (path("users"/IntNumber) & put) { entity(as[String]) { str =>
        complete (s"should update ${str}")
      }
      }
}