; solution: 4613732

(defvar sum 0)
(defvar prev 1)
(defvar tmp 0)
(defun problem2 ()
    (loop with i = 1
        while (< i 4000000)
        do (setf tmp prev prev i i (+ i tmp))
        when (evenp i)
        do (setf sum (+ sum i))
        finally (return sum)))

(print (problem2))
