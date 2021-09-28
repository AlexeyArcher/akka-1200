package mappings

import modules.Question
import spray.json.DefaultJsonProtocol

trait JsonMappings extends DefaultJsonProtocol {
//  implicit val userFormat = jsonFormat5(User)
  implicit val postFormat = jsonFormat3(Question)
//  implicit val commentFormat = jsonFormat4(Comment)
}