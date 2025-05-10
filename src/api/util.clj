(ns api.util
  (:require
   [camel-snake-kebab.core :as csk]
   [muuntaja.core :as m]
   [taoensso.timbre :as log])
  (:import
   [java.time LocalDate]))

;; symbols

;; muuntaja default configs

(def muuntaja-instance
  (m/create
   (-> m/default-options
       (assoc-in [:formats "application/json" :encoder-opts] {:encode-key-fn csk/->camelCaseString})
       (assoc-in [:formats "application/json" :decoder-opts] {:decode-key-fn csk/->kebab-case-keyword}))))

;; encoding & decoding

(defn clj->json
  "Convert clojure map to JSON string."
  [data]
  (try
    (slurp (m/encode muuntaja-instance "application/json" data))
    (catch Exception e
      (log/error (.getMessage e))
      "")))

(defn json->clj
  "Convert JSON string to clojure map."
  [json]
  (try
    (m/decode muuntaja-instance "application/json" (.getBytes json))
    (catch Exception e
      (log/error (.getMessage e))
      {})))

;; Date and Time

(defn ->timestamp []
  (LocalDate/now))