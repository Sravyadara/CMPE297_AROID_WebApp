
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ramyaky/activator-1.3.7-minimal/CMPE297Project/conf/routes
// @DATE:Thu Dec 10 18:03:26 PST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:30
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:30
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homepage""", """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminRetailerCatalog""", """controllers.Application.adminRetailerCatalog()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminInbox""", """controllers.Application.adminInbox()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminCatalog/$id<[^/]+>""", """controllers.Application.imageCatalog(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateUserStatus/$status<[^/]+>/$userName<[^/]+>""", """controllers.Application.updateUserStatus(status:String, userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users_main""", """controllers.Application.listofCategories()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user_products/$category<[^/]+>""", """controllers.Application.listofProducts(category:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product_screen/$category<[^/]+>/$id<[^/]+>""", """controllers.Application.productdetailsfunc(category:String, id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user_products/search/$category<[^/]+>/$id<[^/]+>""", """controllers.Application.searchfunc(category:String, id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """viewLogin""", """controllers.Application.viewLogin()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """retailerCategories""", """controllers.Application.showRetailerCategories()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """retailerProducts/$categoryName<[^/]+>""", """controllers.Application.showRetailerProducts(categoryName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """retailerAddProduct""", """controllers.Application.showProductFormData()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """retailerAddProduct""", """controllers.Application.postProductFormData()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homepage")))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """homepage"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_adminRetailerCatalog1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminRetailerCatalog")))
  )
  private[this] lazy val controllers_Application_adminRetailerCatalog1_invoker = createInvoker(
    Application_1.adminRetailerCatalog(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "adminRetailerCatalog",
      Nil,
      "GET",
      """ Sravya Dara's changes""",
      this.prefix + """adminRetailerCatalog"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_adminInbox2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminInbox")))
  )
  private[this] lazy val controllers_Application_adminInbox2_invoker = createInvoker(
    Application_1.adminInbox(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "adminInbox",
      Nil,
      "GET",
      """""",
      this.prefix + """adminInbox"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_imageCatalog3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminCatalog/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_imageCatalog3_invoker = createInvoker(
    Application_1.imageCatalog(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "imageCatalog",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """adminCatalog/$id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_updateUserStatus4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateUserStatus/"), DynamicPart("status", """[^/]+""",true), StaticPart("/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_updateUserStatus4_invoker = createInvoker(
    Application_1.updateUserStatus(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "updateUserStatus",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """updateUserStatus/$status<[^/]+>/$userName<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_listofCategories5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users_main")))
  )
  private[this] lazy val controllers_Application_listofCategories5_invoker = createInvoker(
    Application_1.listofCategories(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "listofCategories",
      Nil,
      "GET",
      """Sravya Reddys changes""",
      this.prefix + """users_main"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_listofProducts6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user_products/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_listofProducts6_invoker = createInvoker(
    Application_1.listofProducts(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "listofProducts",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """user_products/$category<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_productdetailsfunc7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product_screen/"), DynamicPart("category", """[^/]+""",true), StaticPart("/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_productdetailsfunc7_invoker = createInvoker(
    Application_1.productdetailsfunc(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "productdetailsfunc",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """product_screen/$category<[^/]+>/$id<[^/]+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_searchfunc8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user_products/search/"), DynamicPart("category", """[^/]+""",true), StaticPart("/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_searchfunc8_invoker = createInvoker(
    Application_1.searchfunc(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "searchfunc",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """user_products/search/$category<[^/]+>/$id<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Application_viewLogin9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("viewLogin")))
  )
  private[this] lazy val controllers_Application_viewLogin9_invoker = createInvoker(
    Application_1.viewLogin(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "viewLogin",
      Nil,
      "GET",
      """ Susmitha's changes""",
      this.prefix + """viewLogin"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_login10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login10_invoker = createInvoker(
    Application_1.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_showRetailerCategories11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("retailerCategories")))
  )
  private[this] lazy val controllers_Application_showRetailerCategories11_invoker = createInvoker(
    Application_1.showRetailerCategories(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showRetailerCategories",
      Nil,
      "GET",
      """""",
      this.prefix + """retailerCategories"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Application_showRetailerProducts12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("retailerProducts/"), DynamicPart("categoryName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_showRetailerProducts12_invoker = createInvoker(
    Application_1.showRetailerProducts(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showRetailerProducts",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """retailerProducts/$categoryName<[^/]+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Application_showProductFormData13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("retailerAddProduct")))
  )
  private[this] lazy val controllers_Application_showProductFormData13_invoker = createInvoker(
    Application_1.showProductFormData(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showProductFormData",
      Nil,
      "GET",
      """""",
      this.prefix + """retailerAddProduct"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Application_postProductFormData14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("retailerAddProduct")))
  )
  private[this] lazy val controllers_Application_postProductFormData14_invoker = createInvoker(
    Application_1.postProductFormData(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "postProductFormData",
      Nil,
      "POST",
      """""",
      this.prefix + """retailerAddProduct"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned15_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index())
      }
  
    // @LINE:9
    case controllers_Application_adminRetailerCatalog1_route(params) =>
      call { 
        controllers_Application_adminRetailerCatalog1_invoker.call(Application_1.adminRetailerCatalog())
      }
  
    // @LINE:10
    case controllers_Application_adminInbox2_route(params) =>
      call { 
        controllers_Application_adminInbox2_invoker.call(Application_1.adminInbox())
      }
  
    // @LINE:11
    case controllers_Application_imageCatalog3_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Application_imageCatalog3_invoker.call(Application_1.imageCatalog(id))
      }
  
    // @LINE:12
    case controllers_Application_updateUserStatus4_route(params) =>
      call(params.fromPath[String]("status", None), params.fromPath[String]("userName", None)) { (status, userName) =>
        controllers_Application_updateUserStatus4_invoker.call(Application_1.updateUserStatus(status, userName))
      }
  
    // @LINE:15
    case controllers_Application_listofCategories5_route(params) =>
      call { 
        controllers_Application_listofCategories5_invoker.call(Application_1.listofCategories())
      }
  
    // @LINE:16
    case controllers_Application_listofProducts6_route(params) =>
      call(params.fromPath[String]("category", None)) { (category) =>
        controllers_Application_listofProducts6_invoker.call(Application_1.listofProducts(category))
      }
  
    // @LINE:17
    case controllers_Application_productdetailsfunc7_route(params) =>
      call(params.fromPath[String]("category", None), params.fromPath[String]("id", None)) { (category, id) =>
        controllers_Application_productdetailsfunc7_invoker.call(Application_1.productdetailsfunc(category, id))
      }
  
    // @LINE:18
    case controllers_Application_searchfunc8_route(params) =>
      call(params.fromPath[String]("category", None), params.fromPath[String]("id", None)) { (category, id) =>
        controllers_Application_searchfunc8_invoker.call(Application_1.searchfunc(category, id))
      }
  
    // @LINE:21
    case controllers_Application_viewLogin9_route(params) =>
      call { 
        controllers_Application_viewLogin9_invoker.call(Application_1.viewLogin())
      }
  
    // @LINE:22
    case controllers_Application_login10_route(params) =>
      call { 
        controllers_Application_login10_invoker.call(Application_1.login())
      }
  
    // @LINE:24
    case controllers_Application_showRetailerCategories11_route(params) =>
      call { 
        controllers_Application_showRetailerCategories11_invoker.call(Application_1.showRetailerCategories())
      }
  
    // @LINE:25
    case controllers_Application_showRetailerProducts12_route(params) =>
      call(params.fromPath[String]("categoryName", None)) { (categoryName) =>
        controllers_Application_showRetailerProducts12_invoker.call(Application_1.showRetailerProducts(categoryName))
      }
  
    // @LINE:26
    case controllers_Application_showProductFormData13_route(params) =>
      call { 
        controllers_Application_showProductFormData13_invoker.call(Application_1.showProductFormData())
      }
  
    // @LINE:27
    case controllers_Application_postProductFormData14_route(params) =>
      call { 
        controllers_Application_postProductFormData14_invoker.call(Application_1.postProductFormData())
      }
  
    // @LINE:30
    case controllers_Assets_versioned15_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned15_invoker.call(Assets_0.versioned(path, file))
      }
  }
}