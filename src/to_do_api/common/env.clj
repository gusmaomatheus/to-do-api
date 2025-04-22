(ns to-do-api.common.env)

(defn api-port []
  (Integer/parseInt (or (System/getenv "API_PORT") "3000")))