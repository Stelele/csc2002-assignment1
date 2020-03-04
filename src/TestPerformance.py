import os
import random as r

def main():
    #folder locations
    fileLocation = "../input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"
    pathDir = "/home/gift/Documents/CSC2001F/Assignment1/input"
    testPerformanceStatistics = "../output/TestPerformance.csv"

    data = [line.strip() for line in open(fileLocation,'r')]

    dataSpaces = len(data) // 10
    
    #final information for each dataset
    binTreeComparisonStatistics = {'best':[], 'worst':[],'average':[]}
    arrayComparisonStatistics = {'best':[], 'worst':[],'average':[]} 
    binTreeInsertionStatistics = {'best':[], 'worst':[],'average':[]} 
    subDataSetSize = []

    for i in range(dataSpaces,len(data),dataSpaces):
        tempFile = "../input/subDataSet_{}.txt".format(i)
        tempFileLocation = pathDir+ '/' + tempFile.split("/")[-1]
        terminalOutput = "../output/terminalOutput.txt"

        subDataSetSize.append(i)

        subDataset = [r.choice(data) for j in range(i)]
        
        dataComparisons = {'LSArrayApp':[], 'LSBSTApp':[]}
        dataInsertions = {'LSArrayApp':[], 'LSBSTApp':[]} 

        with open(tempFile, 'w') as f:
            f.write("\n".join(subDataset))

        for index, entry in enumerate(subDataset):
            for app in dataComparisons.keys():
                key = entry.split(" ")[0]
                os.system("java -cp ../bin {} {} {} > {}".format(app," ".join(key.split("_")), tempFileLocation, terminalOutput))

                systemOutput = [line.strip() for line in open(terminalOutput, 'r')]

                comparisons = int(systemOutput[1].split(" ")[2])
                insertions = int(systemOutput[1].split(" ")[2])

                dataComparisons[app].append(comparisons)
                dataInsertions[app].append(insertions)

        binTreeComparisonStatistics['best'].append(min(dataComparisons['LSBSTApp']))
        binTreeComparisonStatistics['worst'].append(max(dataComparisons['LSBSTApp']))
        binTreeComparisonStatistics['average'].append(sum(dataComparisons['LSBSTApp'])//len(dataComparisons['LSBSTApp']))

        binTreeInsertionStatistics['best'].append(min(dataInsertions['LSBSTApp']))
        binTreeInsertionStatistics['worst'].append(max(dataInsertions['LSBSTApp'])) 
        binTreeInsertionStatistics['average'].append(sum(dataInsertions['LSBSTApp'])//len(dataInsertions['LSBSTApp']))

        arrayComparisonStatistics['best'].append(min(dataComparisons['LSArrayApp']))
        arrayComparisonStatistics['worst'].append(max(dataComparisons['LSArrayApp']))
        arrayComparisonStatistics['average'].append(sum(dataComparisons['LSArrayApp'])//len(dataComparisons['LSArrayApp']))

    with open(testPerformanceStatistics,'w') as f:
        f.write(',' + ','.join(map(str,subDataSetSize)) + '\n')
        f.write('Bin Comp Best,' + ','.join(map(str,binTreeComparisonStatistics['best'])) + '\n')
        f.write('Bin Comp Worst,' + ','.join(map(str,binTreeComparisonStatistics['worst'])) + '\n')
        f.write('Bin Comp Average,' + ','.join(map(str,binTreeComparisonStatistics['average'])) +'\n')
        f.write('Bin Insert Best,' + ','.join(map(str,binTreeInsertionStatistics['best'])) + '\n')
        f.write('Bin Insert Worst,' + ','.join(map(str,binTreeInsertionStatistics['worst'])) + '\n')
        f.write('Bin Insert Average,' + ','.join(map(str,binTreeInsertionStatistics['average'])) + '\n')
        f.write('Arr Comp Best,' + ','.join(map(str,arrayComparisonStatistics['best'])) + '\n')
        f.write('Arr Comp Worst,' + ','.join(map(str,arrayComparisonStatistics['worst'])) + '\n')
        f.write('Arr Comp Average,' + ','.join(map(str,arrayComparisonStatistics['average'])) + '\n')

if __name__ == "__main__":
    main()
