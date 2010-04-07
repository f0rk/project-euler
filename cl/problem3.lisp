; solution: 6857

(defun primep (n)
    (if (evenp n)
        (return-from primep)
        (loop with i = 1
            until (> i (sqrt n))
            do (setf i (+ i 2))
            when (= (mod n i) 0)
            do (return)
            finally (return t))))

(defvar max-factor 0)
(defun max-prime-factor (n)
    (loop with i = 1 
        until (> i (sqrt n))
        do (setf i (+ i 2))
        when (and (= (mod n i) 0) (primep i))
        do (setf max-factor i)
        finally (return max-factor)))

(defun problem3 ()
    (max-prime-factor 600851475143))

(print (problem3))
