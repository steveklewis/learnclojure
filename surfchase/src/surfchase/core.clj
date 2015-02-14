(ns surfchase.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn choose-beach
  "Given a list of beaches, choose the best beach"
  [beaches]
  (apply max-key :score beaches))

(defn -main
  "Start our simulation ..."
  [& args]
  (def beach-list (json/read-str 
       (slurp (.getFile (clojure.java.io/resource "beaches.json")))
       :key-fn keyword
       ))
  (println beach-list)
  (println (choose-beach (get beach-list :beaches))))

