(ns playsync.core
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))

(defn -main
  "I don't do a whole lot."
  [& args]
  (def echo-chan (chan))
  (go (println (<! echo-chan)))
  (>!! echo-chan "ketchup"))
