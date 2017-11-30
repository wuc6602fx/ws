K=2
P=1
pre=[]

def attack(q,x,y):
    print('attack: ',q,x,y)
    dx=abs(q[0]-x)
    dy=abs(q[1]-y)
    if dx==0 or dx==dy:
        if dy<P:
            return True
    if dy==0:
        if dx<P:
            return True
    return False


def solve(k):
    if k==1:
        return[[(1,1)]]
    solutions = solve(k-1)
    print('solve k = ',k)
    for solution in solutions:
            for q in solution:#!!!!!q,xy loop position, and solution add
                for x in range(1,k+1):
                    for y in range(1,k+1):
#                    for q in solution:
                        coda = len(solution)
                        if not attack(q,x,y):
                            coda = coda-1
                            print('coda-- ')
                            if coda==0:
                                solution.append((x,y))
    return solutions

#!!!!!(1,2)print at(2,2)
#Method to display chess board
def display_board(queens):
    q_icon =  "♕"
    for i in range(1,K+1):
        if len(queens)>=i:
            print(K-i+1,'\t|'*(queens[i-1][1]),' ',q_icon,'  |','\t|'*(K-queens[i-1][1]))
        else:
            print(K-i+1,'\t|'*K,'\t|')
        print("-"*(8*K+9))


#for calculate, we rotate the board 90 degrees with clockwise
def rotate_board(queens):
    rlt = []
    for q in queens:
        rlt.append((K - q[1] + 1, q[0]))
    return rlt


r_pre = rotate_board(pre)
answers = solve(K)
print(answers)
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
