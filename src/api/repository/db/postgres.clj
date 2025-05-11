(ns api.repository.db.postgres
  (:require
   [api.env :as env]
   [api.repository.core :as repository]))

(def ^:private pg-config
  {:dbname (env/db-name)
   :host (env/db-host)
   :port (env/db-port)
   :user (env/db-username)
   :password (env/db-password)})

(def pg-datasource
  (repository/->datasource "postgresql" pg-config))