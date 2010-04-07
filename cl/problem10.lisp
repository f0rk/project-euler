; solution: 142913828922

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

(defun problem10 ()
    (let ((sum 2))
        (loop for i from 3 below 2000001 by 2
            when (primep i)
            do (setf sum (+ sum i))
            finally (return-from problem10 sum))))

(print (problem10))
