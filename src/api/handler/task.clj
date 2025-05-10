(ns api.handler.task
  (:require
   [api.handler :as handlers]
   [api.model.task :as task]))

(defn insert-task [request]
  (let [body (:body-params request)]
    (if (task/valid-fields? body)
      (handlers/http-200 body)
      (handlers/http-400 "Invalid fields."))))