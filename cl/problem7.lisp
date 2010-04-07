; solution: 104743

(defun primep (n)
    (if (evenp n)
        (return-from primep)
        (loop with i = 1 
            until (> i (sqrt n))
            do (setf i (+ i 2))
            when (= (mod n i) 0)
            do (if (= i n)
                    (return-from primep t)
                    (return-from primep))
            finally (return-from primep t))))

(defvar prime-count 1)
(defun problem7 ()
    (loop for i from 3 to 1000001 by 2
        do (if (primep i)
                (setf prime-count (+ prime-count 1)))
        when (= prime-count 10001)
        do (return i)))

(print (problem7))
