(fn [y z] 
  (map 
    (fn [x] (- (int x) 48)) 
    (seq (str (* y z)))))
