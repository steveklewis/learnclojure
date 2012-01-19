(fn [x y]
  (if (= y 1)
    x
    (apply interleave (repeat y x))))
