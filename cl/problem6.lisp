; solution: 25164150

(defun sum-squares (n)
    (loop for i from 1 to n sum (* i i)))

(defun square-sum (n)
    (expt (loop for i from 1 to n sum i) 2))

(defun problem6 ()
    (- (square-sum 100) (sum-squares 100)))

(print (problem6))
