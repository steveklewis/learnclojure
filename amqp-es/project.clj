(defproject amqp-es "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clojurewerkz/elastisch "2.1.0"]
                 [com.novemberain/langohr "3.3.0"]
                 [cheshire "5.5.0"]]
  :main ^:skip-aot amqp-es.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
