(ns api.env)

;; API
(defn server-port [] (Integer/parseInt (or (System/getenv "SERVER_PORT") "3000")))

;; DB

(defn db-host [] (String/valueOf (or (System/getenv "DB_HOST") "localhost")))
(defn db-port [] (Integer/parseInt (or (System/getenv "DB_PORT") "8081")))
(defn db-name [] (String/valueOf (or (System/getenv "DB_NAME") "localhost")))
(defn db-username [] (String/valueOf (or (System/getenv "DB_USERNAME") "admin")))
(defn db-password [] (String/valueOf (or (System/getenv "DB_PASSWORD") "admin")))