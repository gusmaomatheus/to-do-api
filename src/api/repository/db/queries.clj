(ns api.repository.db.queries
  (:require
   [api.repository.db.postgres :as db]
   [next.jdbc :as jdbc]))

(defn insert-task [title description priority]
  (jdbc/execute! db/pg-datasource ["INSERT INTO tasks(title, description, priority) VALUES(?,?,?)" title description priority]))

(defn get-tasks []
  (jdbc/execute! db/pg-datasource ["SELECT * FROM tasks"]))