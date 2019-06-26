(ns boggle.utils
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :refer [sqrt]]))

(defn str->board
  "Converts a string, `s`, into a board formatted to be accepted by
  `boggle.core/load-board`. nil is returned if `s` cannot be a square board."
  [s]
  (let [board-size (sqrt (count s))]
    (when (integer? board-size)
      (->> s
           str/upper-case
           (map #(if (= \Q %) "QU" %))
           (partition board-size)
           (map #(str/join \  %))
           (str/join "\n")))))
