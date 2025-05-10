(ns api.env)

(defn server-port [] (Integer/parseInt (or (System/getenv "SERVER_PORT") "3000")))