(ns api.middleware
  (:require
   [api.handler :as handler]))

(def wrap-exception
  {:name ::exception
   :description "Internal error."
   :wrap (fn [handler]
           (fn [request]
             (try
               (handler request)
               (catch Exception exception
                 (handler/http-500 exception "The request could not be executed.")))))})

(def wrap-response
  {:name ::response
   :description "Response pattern."
   :wrap (fn [handler]
           (fn [request]
             (handler request)))})