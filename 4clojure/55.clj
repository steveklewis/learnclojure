(fn [coll]
  (reduce (fn [counts x]
            (assoc counts x (inc (get counts x 0))))
          {} coll))