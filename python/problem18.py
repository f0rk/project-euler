#!/usr/bin/python
#solution: 1074

def load_triangle(filename):
    fh = None
    try:
        fh = open(filename, "r")
    except IOError:
        return [[0]]

    triangle = []
    lines = fh.read().rstrip().split("\n")
    for line in lines:
        triangle.append(map(lambda n: int(n), line.split(" ")))

    return triangle


def euler_problem_18():
    triangle = load_triangle("problem18.txt")
    triangle.reverse()
    i = 0
    while i < len(triangle):
        #merge the row into the one below
        j = 0
        while j < len(triangle[i]) - 1:
            if triangle[i][j] > triangle[i][j + 1]:
                triangle[i + 1][j] += triangle[i][j]
            else:
                triangle[i + 1][j] += triangle[i][j + 1]
            j += 1
        i += 1

    return triangle[len(triangle) - 1][0]

print euler_problem_18()
