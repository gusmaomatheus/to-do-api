(ns to-do-api.common.util-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [to-do-api.common.util :as util]))

;; symbols

(def ^:private simple-map
  {:first-name "Matheus"
   :last-name "Gusmão"
   :age 20
   :job "Software Developer at CSDBR"
   :likes ["Code" "Music" "Soccer"]})

(def ^:private nested-map
  {:person
   {:basic-infos {:first-name "Matheus"
                  :last-name "Gusmão"
                  :age 20}
    :job-infos {:company "CSDBR"
                :job "Software Developer"
                :level "Junior"}
    :other-infos {:likes ["Code" "Music" "Soccer"]
                  :mother "Amanda"
                  :father "Rogério"}}})

(def ^:private simple-json
  "{\"firstName\":\"Matheus\",\"lastName\":\"Gusmão\",\"age\":20,\"job\":\"Software Developer at CSDBR\",\"likes\":[\"Code\",\"Music\",\"Soccer\"]}")

(def ^:private nested-json
  "{\"person\":{\"basicInfos\":{\"firstName\":\"Matheus\",\"lastName\":\"Gusmão\",\"age\":20},\"jobInfos\":{\"company\":\"CSDBR\",\"job\":\"Software Developer\",\"level\":\"Junior\"},\"otherInfos\":{\"likes\":[\"Code\",\"Music\",\"Soccer\"],\"mother\":\"Amanda\",\"father\":\"Rogério\"}}}")

;; test cases

;; TODO: think about error cases
(deftest clj->json-test
  ;; valid inputs
  (testing "[OK] - A simple clojure map."
    (is (= simple-json (util/clj->json simple-map))))
  (testing "[OK] - Nested clojure map."
    (is (= nested-json (util/clj->json nested-map)))))

(deftest json->clj-test
  ;;valid inputs
  (testing "[OK] - A simple JSON."
    (is (= simple-map (util/json->clj simple-json))))
  (testing "[OK] - Nested JSON."
    (is (= nested-map (util/json->clj nested-json)))))