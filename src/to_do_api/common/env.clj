(ns to-do-api.common.env)

(defn server-port [] (Integer/parseInt (or (System/getenv "SERVER_PORT") "3000")))