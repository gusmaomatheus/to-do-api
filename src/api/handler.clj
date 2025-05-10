(ns api.handler
  (:require
   [api.util :as util]))

(defn http-200 [response]
  {:status-code 200 :status-text "OK" :timestamp (util/->timestamp) :body {:errors [] :response [response]}})