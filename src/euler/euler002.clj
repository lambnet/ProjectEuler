(ns euler.euler002)

;; Euler Problem #002
;; Find the sum of even-valued in Fibonacci seq whose value do not exceed 4.000.000

; Fibonacci seq with naive approach
(def fib
  (memoize
    (fn [n] (if (<= n 1) 1
                         (+ (fib (dec n)) (fib (- n 2)))))))

; Solution using naive fibonacci function
(defn solution [n]
  (->> (range)
       (map fib)
       (filter even?)
       (take-while #(< % n))
       (reduce +)))

; Fibonacci seq with lazy-seq approach
(defn fibo
  ([]
   (fibo 1 1))
  ([a b]
   (lazy-seq (cons a (fibo b (+ a b))))))

(defn solution1 [n]
  (->> (fibo)
       (filter even?)
       (take-while #(< % n))
       (reduce +)))


(comment
  (time (solution 4000000))
  (time (solution1 4000000))

  )