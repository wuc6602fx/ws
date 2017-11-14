#pythin3
from itertools import repeat
import math


count = input("Count = ")
number = []
#list(map(int, number))
pr = []
#list(map(float, pr))
who = []
#list(map(int, who))
for t in repeat(None, int(count)):
    inputData = input("")
    number.append(inputData.split(" ")[0])
    pr.append(inputData.split(" ")[1])
    who.append(inputData.split(" ")[2])
#print number
#print pr 
#print who
for t in repeat(None, int(count)):
    #ans = (Math.pow(1-p[i],I[i]-1) * p[i]) / (1-Math.pow(1-p[i],n[i]));
    i = 0
    ans = math.pow(1 - float(pr[i]), int(who[i]) - 1) * float(pr[i])
    ans = ans/(1 - math.pow(1 - float(pr[i]), int(number[i])))
    print ("%.4f"% (ans))
    i = i + 1
