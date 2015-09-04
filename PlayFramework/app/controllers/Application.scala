package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.Index("Your new application is ready."))
  }

  def save = Action{
    implicit request =>
      Ok(request.body)
  }
}
