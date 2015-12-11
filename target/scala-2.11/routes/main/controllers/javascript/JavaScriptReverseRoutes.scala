
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ramyaky/activator-1.3.7-minimal/CMPE297Project/conf/routes
// @DATE:Thu Dec 10 18:03:26 PST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:30
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def searchfunc: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.searchfunc",
      """
        function(category,id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user_products/search/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:9
    def adminRetailerCatalog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.adminRetailerCatalog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminRetailerCatalog"})
        }
      """
    )
  
    // @LINE:16
    def listofProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.listofProducts",
      """
        function(category) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user_products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category))})
        }
      """
    )
  
    // @LINE:24
    def showRetailerCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showRetailerCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "retailerCategories"})
        }
      """
    )
  
    // @LINE:17
    def productdetailsfunc: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.productdetailsfunc",
      """
        function(category,id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product_screen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:10
    def adminInbox: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.adminInbox",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminInbox"})
        }
      """
    )
  
    // @LINE:25
    def showRetailerProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showRetailerProducts",
      """
        function(categoryName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "retailerProducts/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("categoryName", encodeURIComponent(categoryName))})
        }
      """
    )
  
    // @LINE:26
    def showProductFormData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showProductFormData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "retailerAddProduct"})
        }
      """
    )
  
    // @LINE:11
    def imageCatalog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.imageCatalog",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminCatalog/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:12
    def updateUserStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.updateUserStatus",
      """
        function(status,userName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUserStatus/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("status", encodeURIComponent(status)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userName", encodeURIComponent(userName))})
        }
      """
    )
  
    // @LINE:27
    def postProductFormData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.postProductFormData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "retailerAddProduct"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "homepage"})
        }
      """
    )
  
    // @LINE:21
    def viewLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.viewLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "viewLogin"})
        }
      """
    )
  
    // @LINE:15
    def listofCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.listofCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users_main"})
        }
      """
    )
  
    // @LINE:22
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }


}