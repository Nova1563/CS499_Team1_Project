
INPUT_CSV = "tableFields.csv"
OUTPUT_TXT = "script_javaSQLoutput.txt"
#
TABLE_NAME = "patientInfo"
PRIMARY_KEY_FIELD = "patiendID"
FOREIGN_KEY_FIELD = "patientID"
#
tableList = [] # list of [sqlColName, sqlType]

def load2colListFromFile():
	with open(INPUT_CSV, "r") as inFile:
		tableRow = 0
		for fileLine in inFile:
			print("fileLine: " + fileLine + "\n")
			rowElements = fileLine.split(",")
			fieldName = rowElements[0]
			fieldType = rowElements[1]
			trimmeFieldType = fieldType[:-1]
			trimmedRowElements = [fieldName, trimmeFieldType]
			tableList.append(trimmedRowElements)
			#tableList[tableRow][0] = rowElements[0]
			#tableList[tableRow][1] = rowElements[1]
			#print(tableList[tableRow][0] + ": " + tableList[tableRow][1] + "\n")
			tableRow += 1
	print(tableList)
	
def load3colListFromFile():
	with open(INPUT_CSV, "r") as inFile:
		tableRow = 0
		for fileLine in inFile:
			print("fileLine: " + fileLine + "\n")
			rowElements = fileLine.split(",")
			fieldName = rowElements[0]
			fieldSQLType = rowElements[1]
			fieldJavaType = rowElements[2][:-1]
			trimmedRowElements = [fieldName, fieldSQLType, fieldJavaType]
			tableList.append(trimmedRowElements)
			#tableList[tableRow][0] = rowElements[0]
			#tableList[tableRow][1] = rowElements[1]
			#print(tableList[tableRow][0] + ": " + tableList[tableRow][1] + "\n")
			tableRow += 1
	print(tableList)

def generateInitSqlTableJavaFromList():
	sqlString = "createTableString = \"CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\\n\"\n"
	
	for tableRow in tableList:
		if tableRow[0] == PRIMARY_KEY_FIELD:
			sqlString += "+ \"" + tableRow[0] + "\t\t" + tableRow[1] + " PRIMARY KEY,\\n\"\n"
		#elif tableRow[0] == FOREIGN_KEY_FIELD:
		#	sqlString += "+ \"" + tableRow[0] + "\t\t" + tableRow[1] + " FOREIGN KEY NOT NULL
		else:
			sqlString += " + \"" + tableRow[0] + "\t\t" + tableRow[1] + ",\\n\"\n"
			
	sqlString += "+ \");\""
	print(sqlString)
	
def generateUpdateTableFieldsStatement():
	sqlString = "UPDATE " + TABLE_NAME + " SET \\n\"\n"
	
	for tableRow in tableList:
		sqlString += "+ \"" + tableRow[0] + " = ? ,\"\n"
	
	sqlString += "+ \"WHERE " + PRIMARY_KEY_FIELD + " = ? \"";
	
	print("\n\nSQL Statement:\n" + sqlString + "\n")
	
	javaString = "PreparedStatement theSQLstatement = conn.preparedStatement(sqlString);\n\n"
	rowNum = 0
	for tableRow in tableList:
		javaString += "theSQLstatement.set" + tableRow[2] + "(\"" + str(rowNum) + "\" , \t\t \\\\ " + tableRow[0] + "\n"
		rowNum += 1
		
	print("\nJava code:\n" + javaString + "\n")
	
	
#def generateSelectFieldsFromID():
#	sqlString = "Select from "
		
load3colListFromFile()
generateUpdateTableFieldsStatement()
