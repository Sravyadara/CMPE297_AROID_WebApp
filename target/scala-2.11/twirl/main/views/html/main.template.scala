
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html lang="en">
    <head>
      <title>"""),_display_(/*7.15*/title),format.raw/*7.20*/("""</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.54*/routes/*10.60*/.Assets.versioned("images/favicon.png")),format.raw/*10.99*/("""">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <link rel="stylesheet" media="screen" href=""""),_display_(/*12.52*/routes/*12.58*/.Assets.versioned("stylesheets/main.css")),format.raw/*12.99*/("""">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	  <script src=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("javascripts/index.js")),format.raw/*15.65*/("""" type="text/javascript"></script>
	</head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
        """),_display_(/*18.10*/content),format.raw/*18.17*/("""
    """),format.raw/*19.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Thu Dec 03 23:00:11 PST 2015
                  SOURCE: /Users/sravyadara/Documents/Softwares/activator-dist-1.3.7/CMPE297_AROID_WebApp/app/views/main.scala.html
                  HASH: 57aac8d85ba59117e5da3ece64d09c35746a41b5
                  MATRIX: 748->1|873->31|901->33|986->92|1011->97|1198->257|1213->263|1273->302|1457->459|1472->465|1534->506|1768->713|1783->719|1845->760|2005->893|2033->900|2065->905
                  LINES: 27->1|32->1|34->3|38->7|38->7|41->10|41->10|41->10|43->12|43->12|43->12|46->15|46->15|46->15|49->18|49->18|50->19
                  -- GENERATED --
              */
          