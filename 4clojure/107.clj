; basic closures
(fn [x]
  (fn [y] (apply * (repeat x y))))
