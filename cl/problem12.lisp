; solution: 76576500

(defun primep (n)
    (if (= n 2)
        (return-from primep t))
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

(defun next-prime (p)
    (loop with i = (+ p 1)
        do (if (primep i)
            (return-from next-prime i)
            (setf i (+ i 1)))))

(defun num-divisors (n)
    (let ((div-count 1) (p 2))
        (loop
            until (= n 1)
            do (if (= (mod n p) 0)
                (let ((cur-count 0))
                   (loop
                        until (/= (mod n p) 0)
                        do (setf n (/ n p))
                        do (setf cur-count (+ cur-count 1))
                    finally (setf div-count (* div-count (+ cur-count 1)))))
                (setf p (next-prime p)))
            finally (return-from num-divisors div-count))))

(defun problem12 ()
    (let ((cur 1))
        (loop with i = 2
            do (setf cur (+ cur i))
            do (setf i (+ i 1))
            do (if (> (num-divisors cur) 500)
                (return-from problem12 cur)))))

(print (problem12))
