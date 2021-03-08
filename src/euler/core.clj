(ns euler.core)

;; Prime number
(defn isPrime
  [n]
  (if (< n 2)
    false
    (let [d (range 2 (inc (int (Math/sqrt n))))
          rem (map #(mod n %) d)]
      (if (not-any? #(= % 0) rem)
        true
        false))))

;; Problem 1md
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
(defn eul3
  [n]
  (loop [n n
         d 2
         factors []]
    (if (< n 2)
      factors
      (if (= 0 (rem n d))
        ; if n can still divisible by 2
        (recur (/ n d) d (conj factors d))
        (recur n (inc d) factors)))))

;; Problem 4
(defn reverse-num
  [n]
  (Integer. (apply str (reverse (str n)))))

(defn isPalindrome
  []
  (for [a (range 100 1001)
        b (range a 1001)]
    (if (= (* a b) (reverse-num (* a b))) (* a b))))

(defn eul4a
  []
  (->> (isPalindrome)
       (sort)
       (last)))

;; Problem 5
(defn eul5
  [n]
  (let [a []
        b (range 1 (inc n))]))


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

;; Problem 7
(defn eul7
  [n]
  (last (take n (filter isPrime (range)))))
;; Problem 8
;; Problem 9
(defn eul9
  []
  (for [a (range 1 1000)
        b (range a 1000)
        c (range b 1000)
        :when (and
                (= (+ (square a) (square b)) (square c))
                (= (+ a b c) 1000))]
    (* a b c)))

;; Problem 10
(defn eul10
  [n]
  (reduce + (take-while #(< % n) (filter isPrime (range)))))
