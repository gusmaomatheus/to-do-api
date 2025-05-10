(ns api.env)

;; API
(defn server-port [] (Integer/parseInt (or (System/getenv "SERVER_PORT") "3000")))

;; POSTGRES

(defn postgres-port [] (Integer/parseInt (or (System/getenv "POSTGRES_PORT") "5432")))
(defn postgres-db [] (String/valueOf (or (System/getenv "POSTGRES_DB") "localhost")))
(defn postgres-user [] (String/valueOf (or (System/getenv "POSTGRES_USER") "user")))
(defn postgres-password [] (String/valueOf (or (System/getenv "POSTGRES_PASSWORD") "1234")))