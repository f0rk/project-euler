; solution: 233168 

(defvar ret 0)
(defun problem1 ()
    (loop for i from 1 to 999
        if (or (= (mod i 3) 0)
               (= (mod i 5) 0))
        do (setf ret (+ ret i))
        finally (return ret)))

(print (problem1))
