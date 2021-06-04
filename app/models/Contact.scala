package models

import play.api.data.Form
import play.api.data.Forms.{boolean, email, mapping, nonEmptyText, optional, text}

case class Contact(
                    firstname: String,
                    lastname: String,
                    email: String,
                    company: Option[String],
                    newsletter: Boolean
                  )

object Contact {
  var form = Form(
    mapping(
      "firstname"  -> nonEmptyText,
      "lastname"  -> nonEmptyText,
      "email" -> email,
      "company" -> optional(text),
      "newsletter" -> boolean
    )(Contact.apply)(Contact.unapply)
  )
}