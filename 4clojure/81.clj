(fn [s1 s2]
  (loop [set1 s1 set2 s2 out #{}]
    (cond 
      (or (empty? set1) (empty? set2))
        out
      (contains? set2 (first set1))
        (recur (rest set1) set2 (set (cons (first set1) out)))
      :else (recur (rest set1) set2 out))))
