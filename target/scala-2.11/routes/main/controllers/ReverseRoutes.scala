
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ramyaky/activator-1.3.7-minimal/CMPE297Project/conf/routes
// @DATE:Thu Dec 10 18:03:26 PST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:30
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def searchfunc(category:String, id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user_products/search/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:9
    def adminRetailerCatalog(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminRetailerCatalog")
    }
  
    // @LINE:16
    def listofProducts(category:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user_products/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
    }
  
    // @LINE:24
    def showRetailerCategories(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "retailerCategories")
    }
  
    // @LINE:17
    def productdetailsfunc(category:String, id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "product_screen/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:10
    def adminInbox(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminInbox")
    }
  
    // @LINE:25
    def showRetailerProducts(categoryName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "retailerProducts/" + implicitly[PathBindable[String]].unbind("categoryName", dynamicString(categoryName)))
    }
  
    // @LINE:26
    def showProductFormData(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "retailerAddProduct")
    }
  
    // @LINE:11
    def imageCatalog(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminCatalog/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:12
    def updateUserStatus(status:String, userName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "updateUserStatus/" + implicitly[PathBindable[String]].unbind("status", dynamicString(status)) + "/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)))
    }
  
    // @LINE:27
    def postProductFormData(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "retailerAddProduct")
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "homepage")
    }
  
    // @LINE:21
    def viewLogin(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "viewLogin")
    }
  
    // @LINE:15
    def listofCategories(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "users_main")
    }
  
    // @LINE:22
    def login(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }


}