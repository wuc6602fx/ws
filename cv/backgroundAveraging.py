# It will not save the photo.
# Use opencv to detect movement and take a shot,
# if background substract value acheive your setting.

import numpy as np
import cv2
#import Image
#import ImageDraw
#import pygame


class BackGroundSubtractor:
#alpha adjust grayscale refresh rate from 0 to 1
    def __init__(self,alpha,firstFrame):
        self.alpha = alpha
        self.backGroundModel = firstFrame

#Background substraction formula
    def getForeground(self,frame):
        self.backGroundModel = frame * self.alpha + self.backGroundModel * (1 - self.alpha)
        return cv2.absdiff(self.backGroundModel.astype(np.uint8),frame)

#activate camera
cam = cv2.VideoCapture(0)

#some blur
def denoise(frame):
    frame = cv2.medianBlur(frame,5)
    frame = cv2.GaussianBlur(frame,(5,5),0)
    return frame
#read numpy array of camera
ret,frame = cam.read()
if ret is True:
    backSubtractor = BackGroundSubtractor(0.1,denoise(frame))   #Alpha value with 0.1
    run = True
else:
    run = False

#color who at range in boundaries with GBR value will satisfy requirement
boundaries = [([220,220,220],[255,255,255])]
for (lower, upper) in boundaries:
        # create NumPy arrays from the boundaries
        lower = np.array(lower, dtype = "uint8")
        upper = np.array(upper, dtype = "uint8")
#i counts times
i=0
#beta adjust the time u need to stop in the rectangle
beta=20
while(run):
    ret,frame = cam.read()
    if ret is True:
#create frame, mask(threshold), result(detect)
        font = cv2.FONT_HERSHEY_SIMPLEX
        cv2.putText(frame,'Try hand selfie',(0,300), font, 1.5,(0,0,0),2,cv2.LINE_AA)
        #create rectangle
        cv2.rectangle(frame,(50,50),(150,150),(0,255,0),5)
        cv2.imshow('input',denoise(frame))
        foreGround = backSubtractor.getForeground(denoise(frame))
        ret, mask = cv2.threshold(foreGround, 15, 255, cv2.THRESH_BINARY)
        result = cv2.inRange(mask, lower, upper)

#Detect if the mid of the rectangle is white
        if result[100,100] == 255:
            i+=1
            if i%beta == 0:
                print('Satisfy ', i/beta)
                _, im = cam.read() # captures image
                cv2.imshow('Awesome!', im) # displays captured image


        #cv2.imshow('mask',mask)
        #cv2.imshow('result',result)
        key = cv2.waitKey(10) & 0xFF
    else:
        break

    if key == 27:
        break

cam.release()
cv2.destroyAllWindows()
