(ns euler.euler003)
;; Find the largest prime-factor of 600851475143

(defn prime-factor
  [n]
  (loop [n n
         p 2
         factors []]
    (if (< n 2)
      factors
      (if (= 0 (rem n p))
        (recur (/ n p) p (conj factors p))
        (recur n (inc p) factors)))))

(defn solution [n]
  (->> (prime-factor n)
       last))


(comment
  (prime-factor 600851475143)
  (time (solution 600851475142))
  )