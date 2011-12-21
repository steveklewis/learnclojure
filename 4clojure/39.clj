(fn [x y]
  (loop [a x b y l []]
    (if (not (and (seq a) (seq b)))
      l
      (recur 
        (rest a) 
        (rest b) 
        (conj l (first a) (first b))))))
