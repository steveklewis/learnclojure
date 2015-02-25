(ns logging.core
  (:require [clojure.tools.logging :as log]))

(defn -main [& args]
  (let [env (get (System/getenv) "CLJ_ENV" "development")]
    (log/info (format "Starting the app with %s environment" env)
    (println "Hello, World!"))))
