; solution: 31875000

(defun problem9 ()
    (loop for a from 1 to 999 
        do (loop for b from 1 to 999
            do (loop for c from 1 to 999
                do (if (= (+ a b c) 1000)
                        (if (= (+ (expt a 2) (expt b 2)) (expt c 2))
                            (return-from problem9 (* a b c))))))))

(print (problem9))
