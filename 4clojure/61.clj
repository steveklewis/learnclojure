(fn [keys vals]
 (loop [map {}
        ks (seq keys)
        vs (seq vals)]
   (if (and ks vs)
      (recur (assoc map (first ks) (first vs)) 
        (next ks) (next vs))
      map)))
