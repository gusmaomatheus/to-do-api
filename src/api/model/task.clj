(ns api.model.task
  (:require
   [api.util :as util]))

;; def's

(def ^:private required-fields #{:title :description :priority})
(def ^:private priorities #{"low" "medium" "high"})

;; fields

(defn- has-all-required-fields? [task]
  (let [fields (keys task)
        difference (filter #(not (contains? required-fields %)) fields)]
    (empty? difference)))

(defn- title-is-valid? [title]
  (and (util/not-empty-str? title) (<= (count title) 50)))

(defn- description-is-valid? [description]
  (and (util/not-empty-str? description) (<= (count description) 255)))

(defn- priority-is-valid? [priority]
  (and (util/not-empty-str? priority) (contains? priorities (util/lower-str priority))))

(defn valid-fields? [task]
  (and
   (has-all-required-fields? task)
   (title-is-valid? (:title task))
   (description-is-valid? (:description task))
   (priority-is-valid? (:priority task))))

;; model

