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
    private final double INSURED_MULTIPLIER = 0.85;

    PaymentProcessor() {}

    public double costForService(Service service, DiscountCategory discount, boolean insured, int numVaccinations) throws Exception {
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

    public double costForService(Service service, DiscountCategory discount, boolean insured) throws Exception {
        return costForService(service, discount, insured, 0);
    }

    private double costForDiagnosis(DiscountCategory discount) throws Exception {
        try {
            return 60.0 * multiplierForDiscount(discount);
        }
        catch (Exception e) {
            throw e;
        }
    }

    private double costForXray(DiscountCategory discount) throws Exception {
        try {
            return 150.0 * multiplierForDiscount(discount);
        }
        catch (Exception e) {
            throw e;
        }
    }

    private double costForBloodTest(DiscountCategory discount, boolean insured) throws Exception {
        try {
            if (insured) {
                return (78.0 * multiplierForDiscount(discount)) * INSURED_MULTIPLIER;
            }
            else {
                return 78.0 * multiplierForDiscount(discount);
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    private double costForEcg(DiscountCategory discount) throws Exception {
        return 200.4 * multiplierForDiscount(discount);
    }

    private double costForVaccination(DiscountCategory discount, int numVaccinations) throws Exception {
        if(numVaccinations < 1) {
            throw new NoVaccineException("Invalid number of vaccinations: " + numVaccinations);
        }
        else {
            return (27.5 + (15.0 * numVaccinations)) * multiplierForDiscount(discount);
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
