(ns euler.core)

;; Problem 1
(defn eul1
  [n]
  (-  (+ (apply + (range 0 n 3))
         (apply + (range 0 n 5)))
      (apply + (range 0 n 15))))

;; Problem 2
(def fib
  (memoize
    (fn [n] (if (<= n 1) 1
                         (+ (fib (dec n)) (fib (- n 2)))))))
(defn eul2
  [n]
  (->> (range)
       (map fib)
       (take-while (partial > n))
       (filter even?)
       (apply +)))

;; Problem 3
