(ns api.repository.core
  (:require
   [next.jdbc :as jdbc]))

(defn- ->database [type configs]
  {:dbtype type
   :dbname (:dbname configs)
   :host (or (:host configs) "localhost")
   :port (:port configs)
   :user (:user configs)
   :password (:password configs)})

(defn ->datasource [type configs]
  (jdbc/get-datasource (->database type configs)))