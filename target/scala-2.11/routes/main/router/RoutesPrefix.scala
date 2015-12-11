
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ramyaky/activator-1.3.7-minimal/CMPE297Project/conf/routes
// @DATE:Thu Dec 10 18:03:26 PST 2015


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
