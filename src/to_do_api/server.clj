(ns to-do-api.server
  (:require
   [reitit.ring :as ring]
   [ring.adapter.jetty :refer [run-jetty]]
   [to-do-api.common.env :as env]))

(def app
  (ring/ring-handler
   (ring/router
    [["/ping" {:get (fn [_] {:status 200 :body "pong"})}]])))

(defn -main []
  (let [port (env/server-port)]
    (println (str "🔧 Iniciando servidor na porta " port))
    (run-jetty app {:port port})))
