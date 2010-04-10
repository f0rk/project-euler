; solution: 1366

(defun problem16 ()
    (let ((digit-string (write-to-string (expt 2 1000))) (sum 0))
        (loop for i from 0 below (length digit-string)
            do (setf sum (+ sum (parse-integer (string (char digit-string i)))))
            finally (return-from problem16 sum))))

(print (problem16))
