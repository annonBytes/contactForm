package controllers

import models.User
import models.Contact
import play.api.i18n.I18nSupport

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {


  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def userForm = Action { implicit request =>
    Ok(views.html.userForm(User.form))
  }

  def postUser = Action { implicit request =>
    User.form.bindFromRequest.fold(
      errors => BadRequest(views.html.userForm(errors)),
      user => Ok(views.html.showUser(user)))
  }

//  def contactForm = TODO

//  def postContact = TODO

  def contactForm =  Action { implicit request =>
    Ok(views.html.contactForm(Contact.form))
  }

  def postContact = Action { implicit request =>
    Contact.form.bindFromRequest.fold(
      errors => BadRequest(views.html.contactForm(errors)),
      contact => Ok(views.html.showContact(contact)))
  }

}
