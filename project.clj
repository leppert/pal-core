(defproject pal/pal-core "0.1.0-SNAPSHOT2"
  :description "A ClojureScript port of buddy-core"
  :url "https://github.com/leppert/pal-core"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]
                 [com.cemerick/piggieback "0.2.1"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-npm       "0.6.2"]
            [lein-doo       "0.1.7"]]
  :npm {:dependencies [[source-map-support "0.4.6"]]}

  :doo {:build "test"
        :alias {:default [:node]}}

  :cljsbuild
  {:builds {:production {:source-paths ["src"]
                         :compiler {:output-to     "target/pal-core/pal_core.js"
                                    :output-dir    "target/pal-core"
                                    :source-map    "target/pal-core/pal_core.js.map"
                                    :target        :nodejs
                                    :language-in   :ecmascript5
                                    :optimizations :advanced
                                    }}
            :test {:source-paths ["src" "test"]
                   :compiler {:output-to     "target/pal-core-test/pal_core.js"
                              :output-dir    "target/pal-core-test"
                              :target        :nodejs
                              :language-in   :ecmascript5
                              :optimizations :none
                              :main          pal.core.test-runner}}}}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
