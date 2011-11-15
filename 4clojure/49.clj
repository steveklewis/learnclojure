(fn [n sequence]
  [
    (take n sequence) 
    (take-last (- (count sequence) n)
	       sequence)])
