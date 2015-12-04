
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("AROID:Explore,Visualize")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

  """),format.raw/*5.3*/("""<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">AROID</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#myPage">HOME</a></li>
        <li><a href="#services">SERVICES</a></li>
        <li><a href="#gallery">PRODUCT GALLERY</a></li>
        <li><a href="#contact">CONTACT US</a></li>
        <li><a href="#login">LOGIN</a></li>
          </ul>
        </li>
      </ul>
	    </div>
	  </div>
	</nav>
	<!------navigation bar ends -------->
	
	<!------Background Image scrolling-------->
	 <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	     
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	      <div class="item active">
	        <img src=""""),_display_(/*43.21*/routes/*43.27*/.Assets.versioned("images/img/image1.jpg")),format.raw/*43.69*/("""" alt="New York" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Make the life simple with stylish and functional home solutions - Wayfair.</h3>
	        </div>      
	      </div>
	
	      <div class="item">
	        <img src=""""),_display_(/*50.21*/routes/*50.27*/.Assets.versioned("images/img/image2.jpg")),format.raw/*50.69*/("""" alt="Chicago" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Plan Before You Shop - IKEA</h3>
	        </div>      
	      </div>
	    
	      <div class="item">
	        <img src=""""),_display_(/*57.21*/routes/*57.27*/.Assets.versioned("images/img/patio1.jpg")),format.raw/*57.69*/("""" alt="Los Angeles" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Discover how we comfort your living - la-Z-boy</h3>
	        </div>      
	      </div>
	    </div>
	    
	  
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	 </div>
	
	
	
	
	<!---------Services----->
	<div class= "container text-center">
	  <h3>Services Offered...</h3>
	  <p><em>We love music!</em></p>
	 <br>
	 <div id="services" class="row slideanim">
	    <div class="col-sm-4">
	      <p class= "text-center"><strong>CAR FINDER</strong></p><br>
	      <a href="#demo1" data-toggle="collapse">
	      <img src=""""),_display_(/*89.19*/routes/*89.25*/.Assets.versioned("images/img/car.jpg")),format.raw/*89.64*/("""" class="img-circle person" alt="Random Name">
	      </a>
	      <div id="demo1" class="collapse">
	      <p>Save the location of your car</p>
	      <p>Go for a walk</p>
	      <p>Get the directions for your car</p>
	    </div>
	    </div>
	    <div class="col-sm-4">
	      <p class= "text-center"><strong>LOCATE RESTAURANTS</strong></p><br>
	      <a href="#demo2" data-toggle="collapse">
	      <img src=""""),_display_(/*100.19*/routes/*100.25*/.Assets.versioned("images/img/food1.jpg")),format.raw/*100.66*/(""""class="img-circle person" alt="Random Name">
	      </a>
	       <div id="demo2" class="collapse">
	      <p>Get nearby restaurants on your mobile screen</p>
	      <p>Check their reviews and rating</p>
	      <p>Check in to the restaurant of your choice</p>
	    </div>
	    </div>
	    <div class="col-sm-4">
	      <p class = "text-center"><strong>PRODUCT CATALOG</strong></p><br>
	       <a href="#demo3" data-toggle="collapse">
	      <img src=""""),_display_(/*111.19*/routes/*111.25*/.Assets.versioned("images/img/room.jpg")),format.raw/*111.65*/("""" class="img-circle person" alt="Random Name">
	      </a>
	       <div id="demo3" class="collapse">
	      <p>Product Catalog with products from various retailers</p>
	      <p>View the products</p>
	      <p>Scan the QRCode with your mobile to visualize</p>
	    </div>
	    </div>
	  </div>
	</div>
	
	<!------Services-------->
	
	<!------Product gallery-------->
	
	
	<div id="gallery" class ="bg-1">
	<div class = "container">
	<h3 class = "text-center"> PRODUCT GALLERY</h3>
	<br>
	<br>
	<div class="row text-center slideanim">
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*135.19*/routes/*135.25*/.Assets.versioned("images/img/portfolio_pic6.jpg")),format.raw/*135.75*/("""" alt="Paris">
	    </div>
	  </div>
 
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*141.19*/routes/*141.25*/.Assets.versioned("images/img/portfolio_pic5.jpg")),format.raw/*141.75*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*149.19*/routes/*149.25*/.Assets.versioned("images/img/portfolio_pic7.jpg")),format.raw/*149.75*/("""" alt="Paris">
	    </div>
	  </div>
	  </div>
	  
	  
	  <div class="row text-center slideanim">
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*158.19*/routes/*158.25*/.Assets.versioned("images/img/1.jpg")),format.raw/*158.62*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*166.19*/routes/*166.25*/.Assets.versioned("images/img/2.jpg")),format.raw/*166.62*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("images/img/3.jpg")),format.raw/*174.62*/("""" alt="Paris">
	    </div>
	  </div>
	  </div>
	  
	  <div class="row text-center slideanim">
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*182.19*/routes/*182.25*/.Assets.versioned("images/img/portfolio_pic2.jpg")),format.raw/*182.75*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*190.19*/routes/*190.25*/.Assets.versioned("images/img/portfolio_pic3.jpg")),format.raw/*190.75*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*198.19*/routes/*198.25*/.Assets.versioned("images/img/portfolio_pic4.jpg")),format.raw/*198.75*/("""" alt="Paris">
	    </div>
	  </div>
	  </div>
	  
	  <div class="row text-center slideanim">
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*206.19*/routes/*206.25*/.Assets.versioned("images/img/image1.jpg")),format.raw/*206.67*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*214.19*/routes/*214.25*/.Assets.versioned("images/img/portfolio_pic8.jpg")),format.raw/*214.75*/("""" alt="Paris">
	    </div>
	  </div>
	  
	  
	  
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <img src=""""),_display_(/*222.19*/routes/*222.25*/.Assets.versioned("images/img/room.jpg")),format.raw/*222.65*/("""" alt="Paris">
	    </div>
	  </div>
	  </div>
	  
	</div>
	</div>

	<!------Product gallery-------->
	
	<!------contact us-------->
	
	<div id="contact" class="container">
	  <h3 class="text-center">Contact US</h3>
	  <p class="text-center"><em>We value your feedback!</em></p>
	  <div class="row test">
	    <div class="col-md-4">
	      <p>Fan? Drop a note.</p>
	      <p><span class="glyphicon glyphicon-map-marker"></span>Sunnyvale, US</p>
	      <p><span class="glyphicon glyphicon-phone"></span>Phone: +00 1515151515</p>
	      <p><span class="glyphicon glyphicon-envelope"></span>Email: sravya at gmail.com</p> 
	    </div>
	    <div class="col-md-8">
	      <div class="row">
	        <div class="col-sm-6 form-group">
	          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
	        </div>
	        <div class="col-sm-6 form-group">
	          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
	        </div>
	      </div>
	      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
	      <br>
	      <br>
	      <div class="row">
	        <div class="col-md-12 form-group">
	          <button class="btn" type="submit">Send</button>
	        </div>
	      </div> 
	    </div>
	  </div>
	</div>
	<!------contact us-------->
	<!---footer----->

	<footer class="text-center">
	  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
	    <span class="glyphicon glyphicon-chevron-up"></span>
	  </a><br><br>
	  <p>Copyright © 2015,AROID Inc. </a></p> 
	</footer>

""")))}),format.raw/*274.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Thu Dec 03 23:00:11 PST 2015
                  SOURCE: /Users/sravyadara/Documents/Softwares/activator-dist-1.3.7/CMPE297_AROID_WebApp/app/views/index.scala.html
                  HASH: 83e59ea1af6fcd00c317f9f9c3ad1b9e2ddafe36
                  MATRIX: 745->1|857->18|885->21|924->52|963->54|993->58|2443->1481|2458->1487|2521->1529|2811->1792|2826->1798|2889->1840|3135->2059|3150->2065|3213->2107|4302->3169|4317->3175|4377->3214|4816->3625|4832->3631|4895->3672|5375->4124|5391->4130|5453->4170|6088->4777|6104->4783|6176->4833|6316->4945|6332->4951|6404->5001|6554->5123|6570->5129|6642->5179|6841->5350|6857->5356|6916->5393|7066->5515|7082->5521|7141->5558|7291->5680|7307->5686|7366->5723|7561->5890|7577->5896|7649->5946|7799->6068|7815->6074|7887->6124|8037->6246|8053->6252|8125->6302|8320->6469|8336->6475|8400->6517|8550->6639|8566->6645|8638->6695|8788->6817|8804->6823|8866->6863|10532->8498
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|74->43|74->43|74->43|81->50|81->50|81->50|88->57|88->57|88->57|120->89|120->89|120->89|131->100|131->100|131->100|142->111|142->111|142->111|166->135|166->135|166->135|172->141|172->141|172->141|180->149|180->149|180->149|189->158|189->158|189->158|197->166|197->166|197->166|205->174|205->174|205->174|213->182|213->182|213->182|221->190|221->190|221->190|229->198|229->198|229->198|237->206|237->206|237->206|245->214|245->214|245->214|253->222|253->222|253->222|305->274
                  -- GENERATED --
              */
          