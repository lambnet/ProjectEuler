(ns euler.euler006)

;; Find the difference between the sum of the squares of the
;; first one hundred natural numbers and the square of the sum.

(defn square [^long n]
  (* n n))

; Defining sum of the square
(defn sum-of-sq
  [s]
  (reduce + (map square s)))

(defn sum-of-sq1
  [n]
  (/ (* (+ (* 2 n) 1)
        (+ n 1)
        n)
     6))

; Defining square of the sum
(defn sq-of-sum
  [s]
  (square (reduce + s)))

(defn sq-of-sum1
  [n]
  (square (/ (* n (+ n 1)) 2)))


(defn solution
  [s]
  (- (sq-of-sum1 s) (sum-of-sq1 s)))

(comment
  (time (solution 10000))
  )