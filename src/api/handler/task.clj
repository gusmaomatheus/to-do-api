(ns api.handler.task
  (:require
   [api.handler :as handlers]))

(defn insert-task [request]
  (handlers/http-200 {:teste "testeeeeee"}))