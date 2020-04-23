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

(concat)
