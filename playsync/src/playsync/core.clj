(ns playsync.core
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout go-loop]]))



(defn -main
  "1. Create a channel.
   2. Create a go block which uses a parking take to 
   print what comes over the channel. Modified to add
   the infinite loop to print anything that comes over
   the channel.
   3. Use a blocking put to push ketchup onto the channel."
  [& args]
  (def echo-chan (chan))
  (go (while true (println (<! echo-chan))))
  (go (>! echo-chan "ketchup"))
  (println "Trying to print mayo")
  (go (>! echo-chan "mayonnaise"))
  (Thread/sleep 10000))
  
