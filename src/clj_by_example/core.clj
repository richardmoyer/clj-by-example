(ns clj-by-example.core)

(fn [] (println "words go here"))

(def words (fn []))

(let [first "Mookie"]
      last "Betts"
      (str "My name is " first last))

(format "One of my favorite players is %s %s" "Pedro" "Martinez")

; %s string %d integer %.Nf floting point where N soecifies how floating points print
; %b is boolean

(mod 3 2)

;; no built in power function
(defn power
  [x n]
  (reduce * (repeat n x)))

(power 2 4)

(nth '(1 2 3 4) 0)
(count '(1 2 3 4 5))
(count "Five.")

;; conj in a list adds to the top
(conj '(1 2 3) 4)

;; conj in vectors adds to end(bottom?) of list
(conj [1 2 3] 4)

;; the dot before indexOf indicates Java interop to acces methods in Java
(.indexOf [1 2 3] 2)

;; sets are collections of unique values
#{1 2 3} ;; => #{1 3 2} order of values is not maintained

(disj #{1 2 3} 1) ;; => #{3 2}

(sort (conj #{1 2 3} 4))

(clojure.set/subset? #{1 2} #{1 2 3 4}) ;; => true
(clojure.set/subset? #{1 5} #{1 2 3 4}) ;; => false

(map inc [1 2 3])
(map inc `(1 2 3)) ; must quote lists

(map key {:a 1 :b 2 :c 3})
;
;lists vectors sets and maps are all "seqable"
(type (seq `(1 2 3)))

(concat '(1 2) '(3 4) '(5 6))

(map (fn [x] (inc (val x))) {:a 1 :b 2 :c 3})

(reduce + [1 2 3 4])

(reduce + '(1 2 3 4)) ; must quote list

(reduce (fn [res val] (+ res val)) [1 2 3 4])

(into [1 2 3] `(4 5 6))
(into [] `(1 2 3))
(into (list) [1 2 3])
(into #{} [1 2 3])

(range 1 21)

(mod 27 7)

(repeatedly 5 (fn [] (println "Lets go Red Sox!!!!")))

(doseq [animal ["donkey" "cow" "cowdonnkey"]] (println animal))

(doseq [n1 [1 2]
        n2 [4 5]]
  (println (+ n1 n2)))

(take 11 (range 0 100))

(drop 1 (take 11 (range 0 100)))

(drop-while neg? [-3 -2 -1 0 1 2 3])

(filter (fn [x] (> x 0)) (take 11 (range 0 21)))

(take-while neg? [-1 -2 -3 -4 0 1 2 3 4 5])

(drop 5 (range 0 10))

(drop-while neg? [-3 -2 -1 0 1 2 3])

(partition-by #(< 4 %) [1 2 3 4 5 6 1 2 3])

(group-by #(< 3 %) [1 2 3 4 5 6 1 2 3])

(println (take 5 (iterate inc 0)))

(for [x '(1 2 3)]
  (+ 10 x))

(for [x '(-1 1 2) :when (< 0 x)] x)

(for [x [0 1 2 3 4 5]
      :let [y (* x 3)]
      :when (even? y)]
  y)

(for [x (range 10) :while (not= x 5)] x)

(into [] (for [x ['a 'b 'c]
      y [1 2 3]]
  [x y]))

;; Recursion

(defn fib [n]
  (if (or (= n 0) (= n 1))
    n
    (+(fib (- n 1) ) (fib (- n 2)))))

(fib 7)

(defn fib-recur [iteration]
  (let [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))

(fib-recur 6)

(defn count-down
  "Recursive function that counts down from n to 1"
  [result n]
  (if (= n 0)
    result(recur (conj result n) (dec n))))

(count-down [] 30)

(defn count-up [max]
  (loop [count 0]
    (if (= count max)
      (println "Done")
    (do
    (println (str "counting " count))
    (recur (inc count))))))

(count-up 15)

(defn count-up-no-loop [count max]
  (if (= count max)
    (println "Done!")
    (do
      (println (str "Counting " count))
      (recur (inc count) max))))

(count-up-no-loop 1 16)
