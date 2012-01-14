(fn [x y] 
  (loop [a x
         b y
	 c []]
    (if (empty? a)
      (apply + c)
      (recur (rest a) (rest b) (conj c (* (first a) (first b)))))))
