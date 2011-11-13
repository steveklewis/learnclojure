(fn [x y]
  (loop [from x
         to y
         ranseq ()]
    (if (= from to)
      (reverse ranseq)
        (recur (inc from) to (cons from ranseq)))))
