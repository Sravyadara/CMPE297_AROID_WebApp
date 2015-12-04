
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sravyadara/Documents/Softwares/activator-dist-1.3.7/CMPE297_AROID_WebApp/conf/routes
// @DATE:Thu Dec 03 23:00:10 PST 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
