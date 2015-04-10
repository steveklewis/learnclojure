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
  (def choose-beach-chan (chan))


  ;; Redo choose-beach with beach-map instead of beach-list
  ;;(go (while true
  ;;      (let [in-beach-map (<! choose-beach-chan)]
  ;;        ()
  ;;        )
  ;;      
  ;;      )
  ;;    
  ;;    )

  (go (while true 
        (let [event (<! event-chan)]
          ((swap! beach-map assoc (event :name) event)
           ;(>! beach-map-chan beach-map)
           (println "Received event:" event)))))
  (doseq [event (beach-events :events)] 
    (>!! event-chan event)))
