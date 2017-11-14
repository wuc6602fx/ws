#import numpy as np
import cv2

cap = cv2.VideoCapture(0)

while(True):
    _, frame = cap.read()
    cv2.imshow('frame',frame)
    cv2.waitKey(30)

cap.release()
cv2.destroyAllWindows()
