(ns logging.core
  (:require [clojure.tools.logging :as log]
            [environ.core :as environ]))

(defn -main [& args]
  (let [env (environ/env :clj-env)]
    (log/info (format "Starting the app with %s environment" (name env))
    (println "Hello, World!"))))
