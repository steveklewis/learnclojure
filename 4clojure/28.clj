;; I don't entirely understand this, as I just copied
;; the source for flatten from core.clj. Not all solutions
;; are this straightforward, as a lot of times the core method
;; will call out to Java for performance, etc.
;;  complement - Takes a fn f and returns a fn that takes the same 
;;               arguments as f, has the same effects, if any, and 
;;               returns the opposite truth value.
;;  sequential? - Returns true if coll implements Sequential. This 
;;                tells whether it's a leaf or a nonleaf.
;;  tree-seq - Returns a lazy sequence of the nodes in a tree, via 
;;             a depth-first walk.  branch? must be a fn of one 
;;             arg that returns true if passed a node that can have 
;;             children (but may not).  children must be a fn of one
;;             arg that returns a sequence of the children. Will 
;;             only be called on nodes for which branch? returns true. 
;;             Root is the root node of the tree.

(fn [x]
  (filter (complement sequential?)
      (rest (tree-seq sequential? seq x))))
