(ns surfchase.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print (json/read-str (slurp (.getFile (clojure.java.io/resource "beaches.json"))))))
