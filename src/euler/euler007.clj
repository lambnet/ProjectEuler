(ns euler.euler007)
;; Find the 10001st prime number

(defn isPrime?
  [^long n]
  (if (< n 2) false
              (let [d (range 2 (inc (int (Math/sqrt n))))
                    r (map #(mod n %) d)]
                (if (not-any?  #(= % 0) r)
                  true
                  false))))

(defn solution
  [n]
  (last (take n (filter isPrime? (range)))))

(comment
  (time (solution 10001))
  (time (take  (filter isPrime? (range))))
  )