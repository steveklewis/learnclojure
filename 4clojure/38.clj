;; loop through the sequence, compare first to second,
;; and return the rest and the bigger of the first and second
;; continue looping with the rest, doing the same.
;; Use arity to return the biggest if the sequence is empty
(fn [x]
  (loop [x sequence
         0 biggest]
    (if (> (first sequence) (second sequence))
      (recur (rest sequence) (first sequence))
      (recur (rest sequence) (second sequence)))))
