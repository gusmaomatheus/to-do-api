(ns api.util
  (:import
   [java.time LocalDate]))

;; Date and Time

(defn ->timestamp []
  (LocalDate/now))