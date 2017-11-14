K = 8   #Board size
P = 8   #Queen force

def under_attack(col,queens):
    left = right = col
    for r,c in queens[::-1]:    #reverse queens
        left, right = left-1, right+1   #left, right be reduced gradually
        if r>P:
            return False
        if c in (left, col, right):
            return True
    return False

def solve(n):
    if n == 0:
        return[[]]
    smaller_solutions = solve(n-1)
    return[solution+[(n,i+1)]
            for i in range(K)
                for solution in smaller_solutions
                    if not under_attack(i+1, solution)]

def display_board(queens):
    q_icon =  "♕"
    print('='*K*(K+1))
    for i in range(1,K+1):
        print(K-i+1,'\t|'*(queens[i-1][1]),' ',q_icon,'  |','\t|'*(K-queens[i-1][1]))
        if i == K:
            print('='*K*(K+1))
        else:
            print("-"*K*(K+1))
    quit()

for answer in solve(K):
    display_board(answer)
