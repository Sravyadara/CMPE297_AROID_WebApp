
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
        <li><a href="/adminInbox">LOGIN</a></li>
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
                  DATE: Thu Dec 10 17:28:48 PST 2015
                  SOURCE: /Users/ramyaky/activator-1.3.7-minimal/CMPE297Project/app/views/index.scala.html
                  HASH: 642c5e5d4ee3b7fe7edc0a9e45b63fa431ab79e3
                  MATRIX: 745->1|857->18|885->21|924->52|963->54|993->58|2448->1486|2463->1492|2526->1534|2816->1797|2831->1803|2894->1845|3140->2064|3155->2070|3218->2112|4307->3174|4322->3180|4382->3219|4821->3630|4837->3636|4900->3677|5380->4129|5396->4135|5458->4175|6093->4782|6109->4788|6181->4838|6321->4950|6337->4956|6409->5006|6559->5128|6575->5134|6647->5184|6846->5355|6862->5361|6921->5398|7071->5520|7087->5526|7146->5563|7296->5685|7312->5691|7371->5728|7566->5895|7582->5901|7654->5951|7804->6073|7820->6079|7892->6129|8042->6251|8058->6257|8130->6307|8325->6474|8341->6480|8405->6522|8555->6644|8571->6650|8643->6700|8793->6822|8809->6828|8871->6868|10537->8503
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|74->43|74->43|74->43|81->50|81->50|81->50|88->57|88->57|88->57|120->89|120->89|120->89|131->100|131->100|131->100|142->111|142->111|142->111|166->135|166->135|166->135|172->141|172->141|172->141|180->149|180->149|180->149|189->158|189->158|189->158|197->166|197->166|197->166|205->174|205->174|205->174|213->182|213->182|213->182|221->190|221->190|221->190|229->198|229->198|229->198|237->206|237->206|237->206|245->214|245->214|245->214|253->222|253->222|253->222|305->274
                  -- GENERATED --
              */
          