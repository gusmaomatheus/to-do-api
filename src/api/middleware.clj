(ns api.middleware
  (:require
   [api.handler :as handler]))

;; TODO: how to make a middleware to format my answers?

(def wrap-exception
  {:name ::exception
   :description "Internal error."
   :wrap (fn [handler]
           (fn [request]
             (try
               (handler request)
               (catch Exception exception
                 (handler/http-500 exception "The request could not be executed.")))))})