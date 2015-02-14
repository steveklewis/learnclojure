(ns surfchase.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn choose-beach
  "Given a list of beaches, choose the best beach"
  [beaches]
  (apply max-key :score beaches))

(defn load-beaches
  "Load data from beaches.json file"
  []
  (json/read-str 
       (slurp (.getFile (clojure.java.io/resource "beaches.json")))
       :key-fn keyword
       ))

(defn -main
  "Start our simulation ..."
  [& args]
  (def beach-list (load-beaches))
  (println beach-list)
  (println (choose-beach (get beach-list :beaches))))

