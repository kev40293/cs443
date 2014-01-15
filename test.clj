(def q '(5 + 6 * 4))

(defn itp [[x y & more]]
  (if (== (count more) 1)
    `(~y ~x ~(first more))
    `(~y ~x ~(itp more))

    )
  )

(itp q)