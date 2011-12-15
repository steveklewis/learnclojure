(fn [x & more] (reduce (fn [a b] (if (> a b) a b)) (cons x more)))
