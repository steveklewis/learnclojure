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

(defn update-beach
  [update-beach-map event]
  (assoc update-beach-map (event :name) event))

(defn -main
  "Start our simulation ..."
  [& args]
  (def beach-list (load-beaches "beaches.json"))
  (def beach-names (map :name (get beach-list :beaches)))
  (def beach-events (load-beaches "events.json"))
  (def beach-map (atom (zipmap beach-names (get beach-list :beaches))))
  (def first-beach (choose-beach (get beach-list :beaches)))
  (println "First beach is" first-beach)

  (def event-chan (chan))
  (go (while true 
        (let [event (<! event-chan)]
          (swap! beach-map assoc (event :name) event))))
  (doseq [event (beach-events :events)] 
        (>!! event-chan event)))
