The Task
Produce a demonstration of the basis of a Java API. The API provides functions for generating the cost of a given transaction as follows:

MediHealth is a private medical centre. They provide following services:
1. Diagnosis
2. X-Ray
3. Blood Test
4. ECG
5. Vaccine
Each of the services has an associated default cost
1. Diagnosis £60
2. X-Ray £150
3. Blood Test £78
4. ECG £200.40
5. Vaccine £27.50 (service) + £15 (for each vaccine)

Discounts are applied for services based on the following criteria:
1. Senior citizens (between 65 and 70) receive a 60% discount
2. Senior citizens (over 70) receive a 90% discount
3. Children under 5 receive 40% discount
4. Patients with "MediHealth Health insurance" get additional 15% discount on Blood test
when they are diagnosed by a MediHealth practitioner

The API demo was produced with the following assumptions:
* 60% discount means 60% of the total cost is removed, so the final price is actually 40% of the non-discounted price.
* The insured discount is assumed to be applied on top of other discounts if applicable, though only one discount + insurance can be applied. Also, the insurance discount is always assumed to be applied last (it is a further discount).


DemoMain exposes a simple command line, which takes three or four arguments and returns the expected cost of the service after discount. Note that the output has been divided by 100 to give a value in 'pounds'.

Arg1: Type of service as an integer, 0-4.\
Arg2: Type of discount to apply as an integer, 0-3.\
Arg3: Insured? Type true or false, case insensitive.\
Arg4: Number of vaccines given, only needed if Arg1 = 4.

Example (from out/production/MediPayAPI/):

 `java DemoMain 0 0 true 0` outputs 60.0\
 `java DemoMain 4 1 false 2` outputs 23.0
 
 
The test can be run by importing the project into an IDE (I used IntelliJ) and running them through the IDE test runner.
This is done by right-clicking test/PaymentProcessorTests and selecting Run.