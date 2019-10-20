(ns json-edn-converter.prod
  (:require
    [json-edn-converter.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
