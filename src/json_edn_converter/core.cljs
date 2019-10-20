(ns json-edn-converter.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn json-to-edn [json-text]
  (try
    (let [json-object (js/JSON.parse json-text)]
      (prn json-object)
      (prn (js->clj json-object)))
    (catch js/Object e
      (prn e))))

(defn home-page []
  [:div [:h2 "JSON <-> EDN Converter"]]
  [:div {:style {:display "flex"}}
   [:textarea {:style {:flex 1}
               :rows 10
               :on-input (fn [event]
                           (prn (.-value (.-target event)))
                           (json-to-edn (.-value (.-target event))))}]
   [:textarea {:style {:flex 1}
               :rows 10}]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
