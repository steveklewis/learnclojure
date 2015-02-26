(ns playsync.core
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))



(defn -main
  "1. Create a channel.
   2. Create a go block which uses a parking take to 
   print what comes over the channel.
   3. Use a blocking put to push ketchup onto the channel."
  [& args]
  (def echo-chan (chan))
  (go (println (<! echo-chan)))
  (>!! echo-chan "ketchup"))
