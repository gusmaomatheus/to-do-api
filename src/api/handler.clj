(ns api.handler
  (:require
   [api.util :as util]))

(defn http-200 [response]
  {:status-code 200 :status-text "OK" :timestamp (str (util/->timestamp)) :body {:errors [] :response response}})

(defn http-400 [message]
  {:status-code 400 :status-text "BAD REQUEST" :timestamp (str (util/->timestamp)) :body {:errors [message] :response {}}})

(defn http-500 [exception message]
  {:status-code 500 :status-text "INTERNAL SERVER ERROR" :exception exception :timestamp (str (util/->timestamp)) :body {:errors [message] :response {}}})