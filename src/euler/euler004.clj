(ns euler.euler004)

;; Euler Problem #004
;; Find the largest palindrome made from the product of two 3-digit numbers.


(defn isPal? [n]
  (= n (Integer. (apply str (reverse (str n))))))

(defn solution
  []
  (->> (for [a (range 900 1000)
             b (range a 1000)
             :when (isPal? (* a b))]
         (* a b))
       (reduce max)))

(comment
  (time (solution))

  )