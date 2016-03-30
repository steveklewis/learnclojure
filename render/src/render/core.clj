(ns render.core
  (:gen-class))

(import '[javax.script ScriptEngineManager])

(defn -main
  "http://augustl.com/blog/2014/jdk8_react_rendering_on_server/"
  [& args]
  (def nashorn (.getEngineByName (ScriptEngineManager.) "nashorn"))
  (.eval nashorn "var global = this")
  (.eval nashorn (clojure.java.io/reader (.getFile (clojure.java.io/resource "react-0.9.0.js"))))
  (.eval nashorn "var MyComponent = React.createClass({
    render: function() {
      return React.DOM.h1(null, 'Hi, ' + this.props.msg)
    }
  })")
  (println (.eval nashorn "React.renderComponentToString(MyComponent({msg: 'World!' }))")))
  
