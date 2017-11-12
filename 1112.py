import numpy as np


file_name = 'is17_1108_1.txt'
input_x = []
input_y = []
with open(file_name) as f:
    f.readline()
    for line in f:
        input_x, input_y = line.split(',')

x = np.array(input_x)
y = np.array(input_y)
A = np.vstack([x, np.ones(len(x))]).T
m, c = np.linalg.lstsq(A, y)[0]
print(m, c)
