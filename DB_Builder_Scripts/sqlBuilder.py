
INPUT_CSV = "tableFields.csv"
OUTPUT_TXT = "script_javaSQLoutput.txt"
#
TABLE_NAME = "appointments"
PRIMARY_KEY_FIELD = "apptID"
FOREIGN_KEY_FIELD = "patientID"
#
tableList = [] # list of [sqlColName, sqlType]

def loadListFromFile():
	with open(INPUT_CSV, "r") as inFile:
		tableRow = 0
		for fileLine in inFile:
			print("fileLine: " + fileLine + "\n")
			rowElements = fileLine.split(",")
			removedNewLineElement = rowElements[0][1]
			tableList.append(rowElements)
			#tableList[tableRow][0] = rowElements[0]
			#tableList[tableRow][1] = rowElements[1]
			#print(tableList[tableRow][0] + ": " + tableList[tableRow][1] + "\n")
			tableRow += 1

def generateInitSqlTableJavaFromList():
	sqlString = "createTableString = \"CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\\n\"\n"
	
	for tableRow in tableList:
		if tableRow[0] == PRIMARY_KEY_FIELD:
			sqlString += "+ \"" + tableRow[0] + "\t\t" + tableRow[1][:-1] + " PRIMARY KEY,\\n\"\n"
		#elif tableRow[0] == FOREIGN_KEY_FIELD:
		#	sqlString += "+ \"" + tableRow[0] + "\t\t" + tableRow[1] + " FOREIGN KEY NOT NULL
		else:
			sqlString += " + \"" + tableRow[0] + "\t\t" + (tableRow[1])[:-1] + ",\\n\"\n"
			
	sqlString += "+ \");\""
	print(sqlString)
	
def generateSelectFieldsFromID():
	sqlString = "Select from "
		
loadListFromFile()
#generateInitSqlTableJavaFromList()
