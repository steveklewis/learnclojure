
(fn [x]
  (loop [sequence x a []]
    (if (empty? sequence) 
      a
      (if (= (first sequence) (second sequence))
        (recur (rest sequence) a)
        (recur (rest sequence) (conj a (first sequence)))))))
