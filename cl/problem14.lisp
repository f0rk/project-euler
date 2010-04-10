; solution: 837799

(defun problem14 ()
    (let ((max-len 0) (max-num 0))
        (loop for i from 1 below 1000000
            do (let ((cur-len 0)) 
                (loop with j = i
                    until (= j 1)
                    do (if (evenp j)
                        (setf j (/ j 2))
                        (setf j (+ (* 3 j) 1)))
                    do (setf cur-len (+ cur-len 1))
                    finally (if (> cur-len max-len)
                        (progn (setf max-len cur-len)
                            (setf max-num i)))))
            finally (return-from problem14 max-num))))

(print (problem14))
