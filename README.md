The API demo was produced with the following assumptions:
* 60% discount means 60% of the total cost is removed, so the final price is actually 40% of the non-discounted price.
* Only one discount can be applied (this was for speed and due to the way the task is worded, applying multiple discounts would require a refactor).


DemoMain exposes a simple command line, which takes three or four arguments and returns the expected cost of the service after discount.
Arg1: Type of service as an integer, 0-4.
Arg2: Type of discount to apply as an integer, 0-3.
Arg3: Insured? Type true or false, case insensitive.
Arg4: Number of vaccines given, only needed if Arg1 = 4.

Example (from out/production/MediPayAPI/):
 `java DemoMain 0 0 true 0` outputs 60.0
 `java DemoMain 4 1 false 2` outputs 23.0
 
 
The test can be run by importing the project into an IDE (I used IntelliJ) and running them through the IDE test runner.
This is done by right-clicking test/PaymentProcessorTests and selecting Run.