(ns logging.core
  (:require [clojure.tools.logging :as log]))

(defn -main [& args]
  (log/info "Starting the app")
  (println "Hello, World!"))
