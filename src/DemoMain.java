
public class DemoMain {

    public static void main(String[] args){
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Service service = null;
        DiscountCategory discount = null;
        boolean insured = false;
        int numVaccines = -1;

        if (args.length == 3 || args.length == 4) {
            try {
                service = ServiceParse(Integer.parseInt(args[0]));
                discount = DiscountParse(Integer.parseInt(args[1]));
                insured = args[2].equalsIgnoreCase("true") ? true :false;
                numVaccines = args.length == 4 ? Integer.parseInt(args[3]) : 0;
            }
            catch (Exception e) {
                System.out.println("Could not parse arguments given.\n");
                PrintUsage();
            }
            try {
                System.out.println("The cost of the service is: "
                        + paymentProcessor.costForService(service, discount, insured, numVaccines)/100);
            }
            catch (Exception e) {
                System.out.println("Something went wrong generating the cost from the arguments given.");
                e.printStackTrace();
            }

        }
        else PrintUsage();
    }

    public static Service ServiceParse(int i) throws Exception {
        switch (i) {
            case 0:
                return Service.DIAGNOSIS;
            case 1:
                return Service.XRAY;
            case 2:
                return Service.BLOOD_TEST;
            case 3:
                return Service.ECG;
            case 4:
                return Service.VACCINATION;
            default:
                throw new Exception("Given Service could not be found.");
        }
    }

    public static DiscountCategory DiscountParse(int i) throws Exception {
        switch (i) {
            case 0:
                return DiscountCategory.NONE;
            case 1:
                return DiscountCategory.SENIOR;
            case 2:
                return DiscountCategory.SENIOR_70_PLUS;
            case 3:
                return DiscountCategory.UNDER_5;
            default:
                throw new Exception("Given Discount could not be found.");
        }
    }

    public static void PrintUsage() {
        System.out.println("Usage: \n" +
                "Arg1: Service \n" +
                "\t 0 - DIAGNOSIS \n" +
                "\t 1 - XRAY \n" +
                "\t 2 - BLOOD_TEST \n" +
                "\t 3 - ECG \n" +
                "\t 4 - VACCINATION \n\n" +
                "Arg2: Discount Code \n" +
                "\t 0 - NONE\n" +
                "\t 1 - SENIOR CITIZEN (<70) \n" +
                "\t 2 - SENIOR CITIZEN (>70) \n" +
                "\t 3 - CHILD (UNDER 5) \n\n" +
                "Arg3: Insured? (true/false) \n\n" +
                "Arg4: Number of Vaccines given (only needed if Arg1 = 4) \n");
    }
}
