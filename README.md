# costofTrip
1. Clone the project to any directory
2. Copy the testing file to interchanges.json to d:/interchanges.json
3. Execute windows command
    cmd.exe
4. Go to the code directory and execute
    sourcedir> mvn clean assembly:assembly
5. Go to the directory target and execute java jar
    sourcedir> cd target
    sourcedir> java -jar costofTrip-1.0-SNAPSHOT.jar
5. Input the testing data after ">" 
   for exmaple:
    input costofTrip("point1","point2") ,it will caculate distance and cost.
# demo
>costofTrip("Keele Street","Bathurst Street")
# 
distance: 5.715
#
cost:1.429


