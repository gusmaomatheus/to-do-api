(ns api.env)

;; API
(defn server-port [] (Integer/parseInt (or (System/getenv "SERVER_PORT") "3000")))