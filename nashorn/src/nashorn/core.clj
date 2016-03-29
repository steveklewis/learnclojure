(ns nashorn.core
  (:gen-class))

(import '[javax.script ScriptEngineManager])

(defn -main
  "http://augustl.com/blog/2014/jdk8_react_rendering_on_server/"
  [& args]
  (def nashorn (.getEngineByName (ScriptEngineManager.) "nashorn"))
  (println (.eval nashorn "5 + 5")) ;; 10
  (println (= true (.eval nashorn "' \\r\\n' == 0"))) ;; true
  (println (.eval nashorn "5 + x", (doto (.createBindings nashorn) (.put "x" (* 2 Math/PI))))))
  
