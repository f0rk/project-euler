; solution: 906609 

(defvar rev "")
(defun palindromep (str)
    (setf rev (reverse str))
    (if (string= str rev)
        (return-from palindromep t)
        (return-from palindromep nil)))

(defvar max-prod 0)
(defun problem4 ()
    (loop for i from 100 to 999
          do (loop for j from 100 to 999
             do (if (palindromep (write-to-string (* i j)))
                (if (> (* i j) max-prod)
                    (setf max-prod (* i j)))))
          finally (return max-prod)))

(print (problem4))
