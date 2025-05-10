(ns api.util
  (:require
   [clojure.string :as string])
  (:import
   [java.time LocalDate]))

;; date and time

(defn ->timestamp []
  (LocalDate/now))

;; string

(defn not-empty-str? [s]
  (and (string? s) (not (string/blank? s))))

(defn lower-str [s]
  (string/lower-case s))