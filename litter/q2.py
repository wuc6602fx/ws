#ques2
from collections import OrderedDict
#tuple
myTuple = list()
with open('example.csv') as f:
    for line in f.read().splitlines():  #avoid \r\n
        myTuple.append(line.split(', '))
myTuple = sorted(myTuple)   #by alphblet
myTuple.pop(len(myTuple)-1) #remove header
print 'Tuple = ', myTuple
#dict
scores = [x[2] for x in myTuple]
counts = [0, 0, 0, 0]
for score in scores:
    if int(score)/10 == 9:
        counts[3] = counts[3] + 1
    elif int(score)/10 == 8:
        counts[2] = counts[2] + 1
    elif int(score)/10 == 7:
        counts[1] = counts[1] + 1
    elif int(score)/10 == 6:
        counts[0] = counts[0] + 1
myRange = ['60~69', '70~79', '80~89', '90~99']
myDict = OrderedDict(zip(myRange, counts))  #70~79 90~99 80~89 60~69, if no use ordereddict
print myDict
