import numpy as np
import cv2
#import Image
#import ImageDraw
#import pygame

class BackGroundSubtractor:
    def __init__(self,alpha,firstFrame):
        self.alpha = alpha
        self.backGroundModel = firstFrame

    def getForeground(self,frame):
        self.backGroundModel = frame * self.alpha + self.backGroundModel * (1 - self.alpha)
        return cv2.absdiff(self.backGroundModel.astype(np.uint8),frame)

cam = cv2.VideoCapture(0)

def denoise(frame):
    frame = cv2.medianBlur(frame,5)
    frame = cv2.GaussianBlur(frame,(5,5),0)
    return frame

ret,frame = cam.read()
if ret is True:
    backSubtractor = BackGroundSubtractor(0.1,denoise(frame))   #Alpha value with 0.1
    run = True
else:
    run = False

while(run):
    ret,frame = cam.read()
    if ret is True:
        cv2.imshow('input',denoise(frame))
        foreGround = backSubtractor.getForeground(denoise(frame))
        ret, mask = cv2.threshold(foreGround, 15, 255, cv2.THRESH_BINARY)



        cv2.imshow('mask',mask)
        key = cv2.waitKey(10) & 0xFF
    else:
        break

    if key == 27:
        break

cam.release()
cv2.destroyAllWindows()
