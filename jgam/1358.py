# W H X Y Player

# 20 10 5 0 3

from sys import stdin
'''
#inputList = map(str, stdin.read().split())
while True:
    try:
        lists = input().split()
    except EOFError:
        break
'''
import math

def solution(inputList):
    # W H X Y Player

    # 20 10 5 0 3

    width = inputList[0]
    height = inputList[1]
    xaxis = inputList[2]
    yaxis = inputList[3]
    numPlayers = inputList[4]

    def circleCheck(x, y):
        #newly calculate its yaxis with given xaixs
        #left circle
        if x <= xaxis:
            newYaxisFirst = math.sqrt((height/2)**2 - (abs(xaxis-x))**2)
            #here two regions first and second
            if y >= int(height/2):
                #if first region
                if y <= newYaxisFirst:
                    return 1
            else:
                if y >= newYaxisFirst:
                    return 1
        
        #right circle
        if x >= (xaxis+width):
            newYaxisSecond = math.sqrt((height/2)**2 - (abs(x-xaxis))**2)
            #two regions
            if y>= int(height/2):
                if y <= newYaxisSecond and y >= (yaxis+):
                    return 1
            else:
                if y <= newYaxisSecond and y >= yaxis:
                    return 1
        return 0

    def squareCheck(x, y):
        if x >= xaxis and x <= (width+xaxis):
            if y >= yaxis and y <= (yaxis+height):
                return 1
        return 0
    squareCheck(1, 2)
    # for loop num players and its indexes


solution([20, 10, 5, 0, 3])
