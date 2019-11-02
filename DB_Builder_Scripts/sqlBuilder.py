
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
			#print("fileLine: " + fileLine + "\n")
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
	#print(tableList)
	
def load3colListFromFile():
	with open(INPUT_CSV, "r") as inFile:
		tableRow = 0
		for fileLine in inFile:
			#print("fileLine: " + fileLine + "\n")
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
	#print(tableList)

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
	rowNum = 1
	for tableRow in tableList:
		theSetType = ""
		if tableRow[2] == "Integer":
			theSetType = "Int"
		elif tableRow[2] == "Text":
			theSetType = "String"
		elif tableRow[2] == "Real":
			theSetType = "Double"
		else:
			theSetType = tableRow[2]
		 
		javaString += "theSQLstatement.set" + theSetType + "(" + str(rowNum) + " , theResults.get" + tableRow[0][0].upper() + tableRow[0][1:] + "());\t\t // " + tableRow[0] + "\n"
		rowNum += 1
		
	print("\nJava code:\n" + javaString + "\n")
	
def generateLoadJavaObjectStatement():
	javaString = ""
	
	for tableRow in tableList:
		theGetType = ""
		if tableRow[2] == "Integer":
			theGetType = "Int"
		elif tableRow[2] == "Text":
			theGetType = "String"
		elif tableRow[2] == "Real":
			theGetType = "Double"
		else:
			theGetType = tableRow[2]
			
		javaString += "theFoundExam.set" + tableRow[0][0].upper() + tableRow[0][1:] + "(theResults.get" + theGetType + "(\"" + tableRow[0] + "\"));\n"
	
	print(javaString);
	
def generatePrintAllFieldsStatement():
	javaString = ""
	
	for tableRow in tableList:
		javaString += "+ \"\\t" + tableRow[0] + ": \" + queryResults.get" + tableRow[2] + "(\"" + tableRow[0] + "\")\n";
		
	print(javaString)
	
#def generateSelectFieldsFromID():
#	sqlString = "Select from "
		
load3colListFromFile()
generateUpdateTableFieldsStatement()
#generateInitSqlTableJavaFromList()
#generatePrintAllFieldsStatement()
#generateLoadJavaObjectStatement()
