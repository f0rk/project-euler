#!/usr/bin/python
#solution: 906609

def is_palindrome(str):
    for i in range(len(str) / 2):
        if str[i] != str[len(str) - i - 1]:
            return False
    return True

def euler_problem_4():
    max = 0
    for i in range(100, 999, 1):
        for j in range(100, 999, 1):
            p = i * j
            if is_palindrome(str(p)) and max < p:
                max = p
    return max 

print euler_problem_4()
