(ns elastic.core
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [conn (esr/connect "http://127.0.0.1:9200")]
    (esi/create conn "steve.test")
    (println (esd/create conn "steve.test" "user" {:username "steve"}))))
