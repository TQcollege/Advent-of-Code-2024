'''
LISTS ARE SAVED IN numberLists.txt

READ FILE, CREATE TWO ARRAYS, DELIMITER WILL BE " "

EXAMPLE: 
87501   76559
70867   16862
ETC...

- SORT LISTS IN ASCENDING ORDER
- COMPARE DIFFERENCE BETWEEN FIRST LIST AND SECOND LIST
- SUM ALL DIFFERENCES BETWEEN FIRST AND SECOND LIST
- ANSWER WILL BE SUM OF ALL DIFFERENCES


PT 2: BASICALLY JUST COMPARE EACH VALUE FROM FIRST LIST TO EACH VALUE IN SECOND LIST

 - NESTED LOOPS TO ITERATE AND COMPARE THE AMOUNT OF TIMES A NUMBER FROM THE FIRST LIST APPEARS IN THE SECOND LIST
 - COUNT VARIABLE += NUMBER OF TIMES THE NUMBER APPEARS IN EACH LIST
 - THIRD LIST VALUES WILL BE THE VALUE OF firstList[i] * COUNT
 - RESET COUNT TO 0 WITH EACH ITERATION OF THE OUTER FOR LOOP
 - SUM ALL VALUES OF THIRD LIST
 - ANSWER WILL BE THE SUM
'''

import os

firstList = []
secondList = []
thirdList = []
sumOfDifferences = 0
total = 0

with open("C:\\Users\\trevo\\Documents\\numberLists.txt", "r") as f:
    for line in f:
        line = line.strip().split()
        firstList.append(int(line[0]))
        secondList.append(int(line[1]))

firstList = sorted(firstList)
secondList = sorted(secondList)

for i in range(len(firstList)):
    sumOfDifferences += abs(firstList[i] - secondList[i])

print(sumOfDifferences) # ANSWER 1

# ----------------- PART 2 -------------------

for i in range(len(firstList)):
    count = 0
    for j in range(len(firstList)):
        if firstList[i] == secondList[j]:
            count += 1
    thirdList.append(int(firstList[i] * count))

#print(thirdList)

for i in range(len(thirdList)):
    total += thirdList[i]

print(total) # ANSWER 2