K = 10   #Board size
P = 10   #Queen force
#pre = [(4,5),(7,7)] #prelocate
pre = []

def under_attack(col,queens,n):
    left = right = col
    for r,c in queens[::-1]:    #reverse queens
        left, right = left-1, right+1   #left, right be reduced gradually
        if n-r>P: #Determine Whether out of queen force
            return False
        if c in (left, col, right): #Because we use top-bottom way, so we only need to detect upper position
            return True
    return False


#Recurrsive function to solve K-queens problem
def solve(n):
    if n == 0:
        return[[]]
    smaller_solutions = solve(n-1)  #To solve K,We should solve every case smaller then K
    return[solution+[(n,i+1)]
            for i in range(K)
                for solution in smaller_solutions
                if not under_attack(i+1, solution, n)]#parameter(col[1:i+1], each smaller_solutions, board size now)


#Method to display chess board
def display_board(queens):
    q_icon =  "♕"
    for i in range(1,K+1):
        print(K-i+1,'\t|'*(queens[i-1][1]),' ',q_icon,'  |','\t|'*(K-queens[i-1][1]))
        print("-"*(8*K+9))


#for calculate, we rotate the board 90 degrees with clockwise
def rotate_board(queens):
    rlt = []
    for q in queens:
        rlt.append((K - q[1] + 1, q[0]))
    return rlt
r_pre = rotate_board(pre)


#Start from here
answers = solve(K)

#if member in pre not in the answer, the answer should be remove
if len(pre)>0:
    new_answers = []
    for a in answers:
        for p in r_pre:
            if p in a:
                if p == r_pre[-1]:
                    new_answers.append(a)
            else:
                break
    answers = new_answers
counts = len(answers)
print('K = ',K,' P = ',P,' has ',counts,' solutions.')
i=1
for answer in answers:
    print('\nMethod ', i)
    display_board(answer)
    i+=1
if len(pre)>0:
    print('Prelocate = ',pre)
if len(answers)>50:
    print('The above only show first 50 solutions.')
