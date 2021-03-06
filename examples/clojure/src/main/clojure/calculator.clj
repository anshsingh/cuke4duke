(ns calculator)

(def numbers (ref (vector)))

(defn push-number [num]
  (dosync (alter numbers conj num)))

(defn calculate [operator]
  (dosync
    (ref-set numbers [(apply operator @numbers)])))

(defn current-value []
  (last @numbers))

