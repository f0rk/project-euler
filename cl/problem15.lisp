; solution: 137846528820

(defun factorial (n)
    (let ((res 1)) 
        (loop for i from n downto 2
            do (setf res (* i res))
            finally (return-from factorial res))))

(defun combinations (n r)
    (return-from combinations (/ (factorial n) (* (factorial r) (factorial (- n r))))))

(defun problem15 ()
    (return-from problem15 (combinations 40 20)))

(print (problem15))
