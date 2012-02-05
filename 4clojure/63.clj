(fn [f coll]
  (reduce
    (fn [ret x]
      (let [k (f x)]
        (assoc ret k (conj (get ret k []) x))))
    {} coll))