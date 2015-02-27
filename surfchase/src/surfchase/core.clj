(ns surfchase.core
  (:require [clojure.data.json :as json]
            [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]])
  (:gen-class))

(defn choose-beach
  "Given a list of beaches, choose the best beach"
  [beaches]
  (apply max-key :score beaches))

(defn load-beaches
  "Load data from given file"
  [beaches-resource]
  (json/read-str 
       (slurp (.getFile (clojure.java.io/resource beaches-resource)))
       :key-fn keyword))


(defn -main
  "Start our simulation ..."
  [& args]
  (def beach-list (load-beaches "beaches.json"))
  (def beach-events (load-beaches "events.json"))
  (println beach-list)
  (println (choose-beach (get beach-list :beaches)))
  (def event-chan (chan))
  (go (while true (println "Incoming surf notice:" (<! event-chan))))
  (doseq [event (beach-events :events)] 
    (>!! event-chan event)))
