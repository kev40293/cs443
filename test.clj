(def q '(5 + 6 * 4))
(def q2 '(5 * 6 + 4))
(def q4 '((3 + 9) * 5))
(def q3 '(5 + (3 + 9) * 5))

(def qp '(* (+ 6 5) 4))

(cons `(* 4 5)  [5])

(defn itp [[x y & more]]
  (if (== (count more) 1)
    `(~y ~x ~(first more))
    (if (or (= '* y) (= '/ y))
      (itp (cons `(~y ~x ~(first more)) (rest more)))
      (if (instance? Long x)
        `(~y ~x ~(itp more))
        (itp (cons (itp x) (cons y more)))
        )
      )
    )
  )

(itp q)
(itp q2)
(itp q3)
(itp q4)
