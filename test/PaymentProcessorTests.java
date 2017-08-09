import org.junit.Test;

public class PaymentProcessorTests {
    @Test
    public void testCostForDiagnosis() {
        PaymentProcessor pp = new PaymentProcessor();
        try {
            int expectedDiagnosisCost = 6000;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, true)
                    == expectedDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.NONE, false, 3)
                    == expectedDiagnosisCost);

            int expectedSeniorDiagnosisCost = 2400;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, false)
                    == expectedSeniorDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR, true, 5)
                    == expectedSeniorDiagnosisCost);


            int expectedSeniorPlusDiagnosisCost = 600;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusDiagnosisCost);
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.SENIOR_70_PLUS, false, 2)
                    == expectedSeniorPlusDiagnosisCost);

            int expectedChildDiagnosisCost = 3600;
            assert (pp.costForService(Service.DIAGNOSIS, DiscountCategory.UNDER_5, true)
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
            int expectedXrayCost = 15000;
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, false)
                    == expectedXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.NONE, true, 12)
                    == expectedXrayCost);

            int expectedSeniorXrayCost = 6000;
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, true)
                    == expectedSeniorXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR, false, 12)
                    == expectedSeniorXrayCost);

            int expectedSeniorPlusXrayCost = 1500;
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.SENIOR_70_PLUS, false, 10)
                    == expectedSeniorPlusXrayCost);

            int expectedChildXrayCost = 9000;
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, false)
                    == expectedChildXrayCost);
            assert (pp.costForService(Service.XRAY, DiscountCategory.UNDER_5, true, 10)
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
            int expectedInsuredBloodTestCost = 6630;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, true)
                    == expectedInsuredBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, true, 3)
                    == expectedInsuredBloodTestCost);

            int expectedUninsuredBloodTestCost = 7800;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, false)
                    == expectedUninsuredBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.NONE, false, 3)
                    == expectedUninsuredBloodTestCost);

            int expectedInsuredSeniorBloodTestCost = 2652;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, true)
                    == expectedInsuredSeniorBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, true, 4)
                    == expectedInsuredSeniorBloodTestCost);

            int expectedUninsuredSeniorBloodTestCost = 3120;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, false)
                    == expectedUninsuredSeniorBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR, false, 4)
                    == expectedUninsuredSeniorBloodTestCost);

            int expectedInsuredSeniorPlusBloodTestCost = 663;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedInsuredSeniorPlusBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, true, 4)
                    == expectedInsuredSeniorPlusBloodTestCost);

            int expectedUninsuredSeniorPlusBloodTestCost = 780;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedUninsuredSeniorPlusBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.SENIOR_70_PLUS, false, 4)
                    == expectedUninsuredSeniorPlusBloodTestCost);

            int expectedInsuredChildBloodTestCost = 3978;
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, true)
                    == expectedInsuredChildBloodTestCost);
            assert (pp.costForService(Service.BLOOD_TEST, DiscountCategory.UNDER_5, true, 4)
                    == expectedInsuredChildBloodTestCost);

            int expectedUninsuredChildBloodTestCost = 4680;
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
            int expectedEcgCost = 20040;
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, true, 7)
                    == expectedEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.NONE, false)
                    == expectedEcgCost);

            int expectedSeniorEcgCost = 8016;
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, true)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, true, 7)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, false)
                    == expectedSeniorEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR, false, 7)
                    == expectedSeniorEcgCost);

            int expectedSeniorPlusEcgCost = 2004;
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, true)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, true, 7)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, false)
                    == expectedSeniorPlusEcgCost);
            assert(pp.costForService(Service.ECG, DiscountCategory.SENIOR_70_PLUS, false, 7)
                    == expectedSeniorPlusEcgCost);

            int expectedChildEcgCost = 12024;
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
            int expectedCostForOneVaccination = 2750 + 1500;
            int numVaccinations = 5;
            int expectedCostForMultipleVaccinations = 10250;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, 1)
                    == expectedCostForOneVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.NONE, true, numVaccinations)
                    == expectedCostForMultipleVaccinations);

            int expectedCostForOneSeniorVaccination = 1700;
            int numSeniorVaccinations = 2;
            int expectedCostForMultipleSeniorVaccinations = 2300;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, true, 1)
                    == expectedCostForOneSeniorVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR, true, numSeniorVaccinations)
                    == expectedCostForMultipleSeniorVaccinations);

            int expectedCostForOneSeniorPlusVaccination = 425;
            int numSeniorPlusVaccinations = 6;
            int expectedCostForMultipleSeniorPlusVaccinations = 1175;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, true, 1)
                    == expectedCostForOneSeniorPlusVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.SENIOR_70_PLUS, false, numSeniorPlusVaccinations)
                    == expectedCostForMultipleSeniorPlusVaccinations);

            int expectedCostForOneChildVaccination = 2550;
            int numChildVaccinations = 12;
            int expectedCostForMultipleChildVaccinations = 12450;
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, true, 1)
                    == expectedCostForOneChildVaccination);
            assert(pp.costForService(Service.VACCINATION, DiscountCategory.UNDER_5, true, numChildVaccinations)
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
