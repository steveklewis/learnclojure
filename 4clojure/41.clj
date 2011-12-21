(fn [a b] 
  (flatten 
    (map 
      (fn [x] (if (= (count x) b) (drop-last x) x)) 
      (partition-all b a))))
