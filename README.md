# java_coverage
given a collection of lines in the form customerId,contractId,geozone,teamcode,projectcode,buildduration;

output the followng information : - 

The number of unique customerId for each contractId.
  The number of unique customerId for each geozone.
  The average buildduration for each geozone.
  The list of unique customerId for each geozone
  
  

source code path: - java_coverage/teamprojects/src/com/home/teamprojects/

sample input :
<<<<<>>>>>>>>

2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s

sample output : 
<<<<<>>>>>>>>

contractId = 2345, unique customerIds = 3
contractId = 2346, unique customerIds = 2
geozone = eu_west
----------------------------------
unique customerIds = 2
average buildduration = 4222.0
list of unique customerIds = 3244132, 3244332, 
----------------------------------
geozone = us_west
----------------------------------
unique customerIds = 2
average buildduration = 2216.0
list of unique customerIds = 1223456, 1233456, 
----------------------------------
geozone = us_east
----------------------------------
unique customerIds = 1
average buildduration = 3445.0
list of unique customerIds = 2343225, 
----------------------------------


Added regex for input data fields validation. assumed customerId, contractId and build duration to be 9 digit numbers.

Added two interfaces for abstraction of emitting of output.

Specialized these interfaces for outout emit(printing) on console


Added JUnit5 test cases.

Total 9 unit tests added.

Added factory methods for customer, contract, team, project and geozones.

Default types of customer, contract, team, project and geozones are created.

Moved printing to container classes.

Added dataAnalyser class to do input parsing, processing and print formatting.
