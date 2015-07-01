(ns beaches.core
  (:require [beaches.handler :refer [app init destroy]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :as reload]
            [taoensso.timbre :as timbre]
            [environ.core :refer [env]])
  (:gen-class))

(defonce server (atom nil))

(defn parse-port [[port]]
  (Integer/parseInt (or port (env :port) "3000")))

(defn start-server [port]
  (init)
  (reset! server
          (run-jetty
            (if (env :dev) (reload/wrap-reload #'app) app)
            {:port port
             :join? false})))

(defn stop-server []
  (when @server
    (destroy)
    (.stop @server)
    (reset! server nil)))

(defn start-app [args]
  (let [port (parse-port args)]
    (.addShutdownHook (Runtime/getRuntime) (Thread. stop-server))
    (timbre/info "server is starting on port " port)
    (start-server port)))

(defn -main [& args]
  (start-app args))
