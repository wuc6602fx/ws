#
# Linear Regression practice, input data from file, and use the method from numpy to calculate.
#
import numpy as np
#import matplotlib.pyplot as plt

def run():
    file_name = 'is17_1108_1.txt'
    input_x = []
    input_y = []
    with open(file_name) as f:
        f.readline()
        for line in f:
            input_x.append(line.split(',')[0])
            input_y.append(line.split(',')[1])

    x = np.array(input_x)
    y = np.array(input_y)
    A = np.vstack([x, np.ones(len(x))]).T
    m, c = np.linalg.lstsq(A, y)[0] #y=mx+c
    print(m, c)
    return m,c
#print('x = 0, y = ', c)
#print('y = 0, x = ', -1*c/m)

#Graph drawing
#plt.plot(x, y, 'ro')
#plt.axis([-1, 1, -12, -6])
#plt.show()
