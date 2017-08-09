enum Service {
    DIAGNOSIS,
    XRAY,
    BLOOD_TEST,
    ECG,
    VACCINATION
}

enum DiscountCategory {
    NONE,
    SENIOR,
    SENIOR_70_PLUS,
    UNDER_5
}

public class PaymentProcessor {
    /*
    Monetary values are considered to be in any base10 currency, counting cents
     */
    public final static double INSURED_MULTIPLIER = 0.85;
    public final static int DIAGNOSIS_BASE_COST =  6000;
    public final static int XRAY_BASE_COST = 15000;
    public final static int BLOOD_TEST_BASE_COST = 7800;
    public final static int ECG_BASE_COST = 20040;
    public final static int VACCINATION_BASE_COST = 2750;
    public final static int VACCINE_COST = 1500;

    PaymentProcessor() {}

    public int costForService(Service service, DiscountCategory discount, boolean insured, int numVaccinations) throws Exception {
        switch (service) {
            case DIAGNOSIS:
                return costForDiagnosis(discount);
            case XRAY:
                return costForXray(discount);
            case BLOOD_TEST:
                return costForBloodTest(discount, insured);
            case ECG:
                return costForEcg(discount);
            case VACCINATION:
                return costForVaccination(discount, numVaccinations);
            default:
                throw new Exception("Could not process service requested" + service);
        }
    }

    public int costForService(Service service, DiscountCategory discount, boolean insured) throws Exception {
        return costForService(service, discount, insured, 0);
    }

    private int costForDiagnosis(DiscountCategory discount) throws Exception {
        try {
            return (int) Math.round(DIAGNOSIS_BASE_COST * multiplierForDiscount(discount));
        }
        catch (Exception e) {
            throw e;
        }
    }

    private int costForXray(DiscountCategory discount) throws Exception {
        try {
            return (int) Math.round(XRAY_BASE_COST * multiplierForDiscount(discount));
        }
        catch (Exception e) {
            throw e;
        }
    }

    private int costForBloodTest(DiscountCategory discount, boolean insured) throws Exception {
        try {
            if (insured) {
                return (int) Math.round((BLOOD_TEST_BASE_COST * multiplierForDiscount(discount)) * INSURED_MULTIPLIER);
            }
            else {
                return (int) Math.round((BLOOD_TEST_BASE_COST * multiplierForDiscount(discount)));
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    private int costForEcg(DiscountCategory discount) throws Exception {
        return (int) Math.round(ECG_BASE_COST * multiplierForDiscount(discount));
    }

    private int costForVaccination(DiscountCategory discount, int numVaccinations) throws Exception {
        if(numVaccinations < 1) {
            throw new NoVaccineException("Invalid number of vaccinations: " + numVaccinations);
        }
        else {
            return (int) Math.round((VACCINATION_BASE_COST + (VACCINE_COST * numVaccinations)) * multiplierForDiscount(discount));
        }
    }

    private double multiplierForDiscount(DiscountCategory discount) throws Exception {
        switch (discount) {
            case NONE:
                return 1.0;
            case SENIOR:
                return 0.4;
            case SENIOR_70_PLUS:
                return 0.1;
            case UNDER_5:
                return 0.6;
            default:
                throw new Exception("Could not process discount category: " + discount);
        }
    }
}
