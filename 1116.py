#read file into data
data = [[],[],[],[],[],[],[]]
with open('samples.txt') as f:
    f.readline()
    for line in f:
        line = line.rstrip('\n')    #Avoid '\n' be append to data
        for i in range(0,7):
            data[i].append(line.split(',')[i])

#calculate probilities
pr = []
for d in data:
    bcount = 0
    count = 0
    for i in d:
        if i == 'B':
            bcount = bcount + 1
        if i == 'T':
            count = count + 1
    if bcount:
        pr.append((bcount/len(d), count/len(d), 1-bcount/len(d)-count/len(d)))
    else:
        pr.append((count/len(d),1-count/len(d)))

#print pr
dcount = ord('a')
for p in pr:
    print('pr(', chr(dcount), ') :')
    for ap in p:
        print('\t','%.4f'%ap)
    dcount = dcount + 1
