(ns euler.euler005)

;; Smallest positive number that is evenly divisble by all of the numbers from 1 to 20 (LCM)

; Defining gcd function using Euclidean Algorithm
(defn gcd [^long a ^long b]
  (if (= b 0)
    a
    (gcd b (mod a b))))

; Defining lcm function using gcd
(defn lcm [^long a ^long b]
  (/ (* a b) (gcd a b)))

(defn solution
  []
  (reduce lcm (range 1 20)))


(comment
  (gcd 48 18)
  (lcm 4 6)
  (time (solution))



  )


