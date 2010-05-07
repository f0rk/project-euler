#!/usr/bin/python
#solution: 871198282

def name_score(name):
    total = 0
    for i in range(len(name)):
        total += ord(name[i]) - ord("A") + 1
    return total

def euler_problem_22():
    name_file = open("problem22.txt", "r")
    names = name_file.read()
    names = names.strip('"')
    name_list = names.split('","')
    name_list.sort()
    total = 0
    for i in range(len(name_list)):
        score = name_score(name_list[i])
        total += score * (i + 1)
    return total

print euler_problem_22()
