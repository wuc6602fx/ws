K = 8   #Board size


def under_attack(col,queens):
    left = right = col
    for r,c in reversed(queens):
        left, right = left-1, right+1
        if c in (left, col, right):
            return True
    return False

def solve(n):
    if n==0:
        return[[]]
    smaller_solutions = solve(n-1)
    return[solution+[(n,i+1)]
            for i in range(K)
                for solution in smaller_solutions
                    if not under_attack(i+1, solution)]


for answer in solve(K):
    print (answer)
