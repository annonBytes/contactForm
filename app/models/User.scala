package models

import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number}

case class User(name:String, age:Int)

object User  {
  var form = Form(
    mapping(
      "name" -> nonEmptyText,
      "age" -> number(min = 0, max=110 )
    )(User.apply)(User.unapply)
  )
}
