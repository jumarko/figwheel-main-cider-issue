(defproject figwheel-main-cider-issue "0.1.0-SNAPSHOT"

  :description "To test figwheel-main with Cider"

  ;; https://github.com/bhauman/figwheel-main#setting-up-a-build-with-leiningen
  :dependencies [[clj-time "0.15.2"]
                 [luminus-nrepl "0.1.7"]
                 [nrepl "0.9.0"]
                 [org.clojure/clojure "1.10.3"]
                 [org.webjars.bower/tether "1.4.3"]
                 [org.webjars/bootstrap "4.0.0-beta-1"]
                 [org.webjars.npm/popper.js "1.13.0"]
                 [org.webjars/font-awesome "4.7.0"]
                 [ring-webjars "0.2.0"]
                 [secretary "1.2.3"]
                 ]

  :min-lein-version "2.0.0"

  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :resource-paths ["resources"]
  :target-path "target/%s/"
  :main ^:skip-aot figwheel-main-cider-issue.core

  :aliases {"fig:build" ["trampoline" "run" "-m" "figwheel.main" "--build" "dev" "--repl"]}

  :profiles
  {:uberjar {:omit-source true
             :prep-tasks ["compile"]
             :aot :all
             :uberjar-name "my-app.jar"}

   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]

   :project/dev  {:dependencies [
                                 ;; the version of clojurescript compatible with figwheel-main
                                 [org.clojure/clojurescript "1.10.773"]
                                 [com.bhauman/figwheel-main "0.2.16"]
                                 [com.bhauman/rebel-readline-cljs "0.1.4"]
                                 [binaryage/devtools "1.0.4"]
                                 [day8.re-frame/tracing "0.6.2"]
                                 [day8.re-frame/re-frame-10x "1.2.2"]

                                 [re-frame "1.2.0"]
                                 [reagent "1.1.0"]

                                 ]
                  :source-paths ["src/cljs"]

                  :repl-options {:init-ns user
                                 :timeout 120000}
                  }

   :project/test {}
   :profiles/dev {}
   :profiles/test {}})
