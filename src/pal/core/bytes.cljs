(ns pal.core.bytes
  (:refer-clojure :exclude [concat]))

(defn equals?
  "Test whether two sequences of characters or bytes are equal in a way that
  protects against timing attacks. Note that this does not prevent an attacker
  from discovering the *length* of the data being compared."
  [a b]
  (let [a (map int a), b (map int b)]
    (if (and a b (= (count a) (count b)))
      (zero? (reduce bit-or 0 (map bit-xor a b)))
      false)))

(defn concat
  "Given N number of byte arrays, concat them in
  one unique byte array and return it."
  [& parts]
  (into-array (for [ar parts
                    i ar] i)))
