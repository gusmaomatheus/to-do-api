(ns api.handler.task
  (:require
   [api.handler :as handlers]
   [api.model.task :as task]
   [api.repository.db.queries :as qry]))

(defn insert-task [request]
  (let [body (:body-params request)]
    (if (task/valid-fields? body)
      (let [{:keys [title description priority]} body]
        (try
          (qry/insert-task title description priority)
          (handlers/http-200 body)
          (catch Exception exception
            (handlers/http-500 exception (.getMessage exception)))))
      (handlers/http-400 "Invalid fields."))))

(defn get-tasks [_request]
  (try
    (let [tasks (qry/get-tasks)]
      (handlers/http-200 tasks))
    (catch Exception exception
      (handlers/http-500 exception (.getMessage exception)))))