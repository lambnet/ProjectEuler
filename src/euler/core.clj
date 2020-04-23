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
;; Problem 4
(defn reverse-num
  [n]
  (Integer. (apply str (reverse (str n)))))

(defn eul4
  []
  (for [a (range 100 1001)
        b (range a 1001)]
    (if (= (* a b) (reverse-num (* a b))) (* a b))))

(defn eul4a
  []
  (->> (eul4)
       (sort)
       (drop-while nil?)
       (last)))

;; Problem 5
;; Problem 6
(defn square
  [n]
  (* n n))

(defn sum-of-squares
  [n]
  (/ (* (+ (* 2 n) 1)
        (+ n 1)
        n)
     6))

(defn square-of-sum
  [n]
  (square (/ (* (+ n 1) n)
             2)))

(defn eul6
  [n]
  (- (square-of-sum n) (sum-of-squares n)))