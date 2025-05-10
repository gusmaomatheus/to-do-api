(ns api.server
  (:require
   [api.env :as env]
   [api.handler.task :as task]
   [api.middleware :as middleware]
   [camel-snake-kebab.core :as csk]
   [muuntaja.core :as m]
   [reitit.ring :as ring]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [ring.adapter.jetty :as jetty]
   [taoensso.timbre :as log]))

;; muuntaja default configs

(def ^:private muuntaja-instance
  (m/create
   (-> m/default-options
       (assoc-in [:formats "application/json" :encoder-opts] {:encode-key-fn csk/->camelCaseString})
       (assoc-in [:formats "application/json" :decoder-opts] {:decode-key-fn csk/->kebab-case-keyword}))))

(def ^:private app
  (ring/ring-handler
   (ring/router
    [["/api/task" {:post task/insert-task}]]
    {:data {:muuntaja muuntaja-instance
            :middleware [middleware/wrap-exception
                         middleware/wrap-response
                         muuntaja/format-middleware]}})))

(defn- start [port]
  (let [server (jetty/run-jetty #'app {:port port :join? false :async? false :send-server-version? false})]
    (log/infof "🟢 Server running at port %d" port)
    server))

(defn -main []
  (start (env/server-port)))