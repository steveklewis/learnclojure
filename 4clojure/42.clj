(fn [x]
  (loop [n x total 1]
    (if (= n 1)
      total
      (recur (- n 1) (* total n)))))
