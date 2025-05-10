(ns api.handler
  (:require
   [api.util :as util]))

(defn http-200 [response]
  {:status-code 200 :status-text "OK" :timestamp (util/->timestamp) :body {:errors [] :response response}})

(defn http-500 [exception message]
  {:status-code 500 :status-text "Internal Server Error" :exception exception :timestamp (util/->timestamp) :body {:errors [message] :response {}}})