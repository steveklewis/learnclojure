(ns surfchase.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (println (slurp (.getFile (clojure.java.io/resource "beaches.json"))))
