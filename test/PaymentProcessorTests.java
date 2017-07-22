import org.junit.Test;

public class PaymentProcessorTests {
    @Test
    public void testCostForDiagnosis() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            double expectedDiagnosisCost = 60.0;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, true)
                    == expectedDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, false)
                    == expectedDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, true, 5)
                    == expectedDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, false, 5)
                    == expectedDiagnosisCost);

            double expectedSeniorDiagnosisCost = 60.0 * 0.4;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, true)
                    == expectedSeniorDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, false)
                    == expectedSeniorDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, true, 5)
                    == expectedSeniorDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, false, 5)
                    == expectedSeniorDiagnosisCost);


            double expectedSeniorPlusDiagnosisCost = 60.0 * 0.1;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedSeniorPlusDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, true, 2)
                    == expectedSeniorPlusDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, false, 2)
                    == expectedSeniorPlusDiagnosisCost);

            double expectedChildDiagnosisCost = 60.0 * 0.6;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.UNDER_5, true)
                    == expectedChildDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.UNDER_5, false)
                    == expectedChildDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.UNDER_5, false, 6)
                    == expectedChildDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.UNDER_5, false, 6)
                    == expectedChildDiagnosisCost);
        }
        catch (Exception e) {
            // do nothing as tests already failed if anything was thrown here
            e.printStackTrace();
        }
    }

    @Test
    public void testCostForXray() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            double expectedXrayCost = 150.0;
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, true)
                    == expectedXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, false)
                    == expectedXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, true, 12)
                    == expectedXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, false, 12)
                    == expectedXrayCost);

            double expectedSeniorXrayCost = 150.0 * 0.4;
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, true)
                    == expectedSeniorXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, false)
                    == expectedSeniorXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, true, 12)
                    == expectedSeniorXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, false, 12)
                    == expectedSeniorXrayCost);

            double expectedSeniorPlusXrayCost = 150.0 * 0.1;
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedSeniorPlusXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, true, 10)
                    == expectedSeniorPlusXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, false, 10)
                    == expectedSeniorPlusXrayCost);

            double expectedChildXrayCost = 150.0 * 0.6;
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, true)
                    == expectedChildXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, false)
                    == expectedChildXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, true, 10)
                    == expectedChildXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, false, 10)
                    == expectedChildXrayCost);

        }
        catch (Exception e) {
            // do nothing as tests already failed if anything was thrown here
            e.printStackTrace();
        }
    }

    @Test
    public void testCostForBloodTest() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            double expectedInsuredBloodTestCost = 78.0 * 0.85;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, true)
                    == expectedInsuredBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, true, 3)
                    == expectedInsuredBloodTestCost);

            double expectedUninsuredBloodTestCost = 78.0;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, false)
                    == expectedUninsuredBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, false, 3)
                    == expectedUninsuredBloodTestCost);

            double expectedInsuredSeniorBloodTestCost = (78.0 * 0.4) * 0.85;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, true)
                    == expectedInsuredSeniorBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, true, 4)
                    == expectedInsuredSeniorBloodTestCost);

            double expectedUninsuredSeniorBloodTestCost = 78.0 * 0.4;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, false)
                    == expectedUninsuredSeniorBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, false, 4)
                    == expectedUninsuredSeniorBloodTestCost);

            double expectedInsuredSeniorPlusBloodTestCost = (78.0 * 0.1) * 0.85;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedInsuredSeniorPlusBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, true, 4)
                    == expectedInsuredSeniorPlusBloodTestCost);

            double expectedUninsuredSeniorPlusBloodTestCost = 78.0 * 0.1;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedUninsuredSeniorPlusBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, false, 4)
                    == expectedUninsuredSeniorPlusBloodTestCost);

            double expectedInsuredChildBloodTestCost = (78.0 * 0.6) * 0.85;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, true)
                    == expectedInsuredChildBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, true, 4)
                    == expectedInsuredChildBloodTestCost);

            double expectedUninsuredChildBloodTestCost = 78.0 * 0.6;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, false)
                    == expectedUninsuredChildBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, false, 4)
                    == expectedUninsuredChildBloodTestCost);
        }
        catch (Exception e) {
            // do nothing as tests already failed if anything was thrown here
            e.printStackTrace();
        }
    }

    @Test
    public void testCostForEcg() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            double expectedEcgCost = 200.4;
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, true)
                    == expectedEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, true, 7)
                    == expectedEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, false)
                    == expectedEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, false, 7)
                    == expectedEcgCost);

            double expectedSeniorEcgCost = 200.4 * 0.4;
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, true)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, true, 7)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, false)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, false, 7)
                    == expectedSeniorEcgCost);

            double expectedSeniorPlusEcgCost = 200.4 * 0.1;
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, true, 7)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, false, 7)
                    == expectedSeniorPlusEcgCost);

            double expectedChildEcgCost = 200.4 * 0.6;
            assert(pp.costForService(Service.ECG, DiscountCategory.UNDER_5, true)
                    == expectedChildEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.UNDER_5, true, 7)
                    == expectedChildEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.UNDER_5, false)
                    == expectedChildEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.UNDER_5, false, 7)
                    == expectedChildEcgCost);
        }
        catch (Exception e) {
            // do nothing as tests already failed if anything was thrown here
            e.printStackTrace();
        }
    }

    @Test
    public void testCostForVaccination() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            double expectedCostForOneVaccination = 27.5 + 15.0;
            int numVaccinations = 5;
            double expectedCostForMultipleVaccinations = 27.5 + (15.0 * numVaccinations);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, 1)
                    == expectedCostForOneVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, numVaccinations)
                    == expectedCostForMultipleVaccinations);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, false, 1)
                    == expectedCostForOneVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, false, numVaccinations)
                    == expectedCostForMultipleVaccinations);

            double expectedCostForOneSeniorVaccination = (27.5 + 15.0) * 0.4;
            int numSeniorVaccinations = 2;
            double expectedCostForMultipleSeniorVaccinations = (27.5 + (15.0 * numSeniorVaccinations)) * 0.4;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, true, 1)
                    == expectedCostForOneSeniorVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, true, numSeniorVaccinations)
                    == expectedCostForMultipleSeniorVaccinations);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, false, 1)
                    == expectedCostForOneSeniorVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, false, numSeniorVaccinations)
                    == expectedCostForMultipleSeniorVaccinations);

            double expectedCostForOneSeniorPlusVaccination = (27.5 + 15.0) * 0.1;
            int numSeniorPlusVaccinations = 6;
            double expectedCostForMultipleSeniorPlusVaccinations = (27.5 + (15.0 * numSeniorPlusVaccinations)) * 0.1;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, true, 1)
                    == expectedCostForOneSeniorPlusVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, true, numSeniorPlusVaccinations)
                    == expectedCostForMultipleSeniorPlusVaccinations);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, false, 1)
                    == expectedCostForOneSeniorPlusVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, false, numSeniorPlusVaccinations)
                    == expectedCostForMultipleSeniorPlusVaccinations);

            double expectedCostForOneChildVaccination = (27.5 + 15.0) * 0.6;
            int numChildVaccinations = 12;
            double expectedCostForMultipleChildVaccinations = (27.5 + (15.0 * numChildVaccinations)) * 0.6;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, true, 1)
                    == expectedCostForOneChildVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, true, numChildVaccinations)
                    == expectedCostForMultipleChildVaccinations);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, false, 1)
                    == expectedCostForOneChildVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, false, numChildVaccinations)
                    == expectedCostForMultipleChildVaccinations);
        }
        catch (Exception e) {
            // do nothing as tests already failed if anything was thrown here
            e.printStackTrace();
        }
    }

    @Test (expected = NoVaccineException.class)
    public void testCostForVaccinationNoVaccineGiven() throws Exception {
        PaymentProcessor pp = new PaymentProcessor();
        pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, 0);
    }

    @Test (expected = NoVaccineException.class)
    public void testCostForVaccinationNegativeVaccinesGiven() throws Exception {
        PaymentProcessor pp = new PaymentProcessor();
        pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, -12);
    }
}
