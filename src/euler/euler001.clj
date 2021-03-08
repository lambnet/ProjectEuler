(ns euler.euler001)

;; Euler Problem #001
;; Find the sum of all multiple number of 3 or 5 below 1000

(defn solution [n]
  (let [div-by-3 (range 0 n 3)
        div-by-5 (range 0 n 5)
        res (reduce + (distinct (concat div-by-3 div-by-5)))]
    res))

(comment
  (time (solution 1000))

  )