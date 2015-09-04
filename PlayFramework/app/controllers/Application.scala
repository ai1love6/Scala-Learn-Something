package controllers

import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

case class Member(code: String, name: String, phone: List[String], email: List[String])

object Application extends Controller {

  var memberForm = Form(
    tuple(
      "txtMemberId" -> text,
      "txtMemberName" -> text,
      "phone" -> list(text),
      "email" -> list(text)
    )
  )

  def index = Action {
    implicit request =>
      Ok(views.html.Index("Your new application is ready."))
  }

  def save = Action.async {
    implicit request =>
      memberForm.bindFromRequest.fold(
        formWithErrors => {
          Future(Redirect(routes.Application.index()).flashing("messageError" -> s"Error mapping form control :- $formWithErrors"))
        }, memberForm => {
          val (txtMemberId, txtMemberName, phone, email) = memberForm
          val member = Member(txtMemberId, txtMemberName, phone, email)
          val msg = s"code : ${member.code}, name: ${member.name}, phone: ${member.phone}, email: ${member.email}"
          Future(Ok(msg))
        }
      )
  }
}
