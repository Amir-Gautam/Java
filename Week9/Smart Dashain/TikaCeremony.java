package TikaCeremony;
public class TikaCeremony extends FestivalActivity {
    int expectedGuests;
    String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (expectedGuests < 5) {
            throw new InvalidGuestCountException("Not enough guests for a lively Tika! Is everyone on vacation?");
        }
        if (estimatedCost > 50000) {
            throw new BudgetExceededException("Tika budget too high! Is this for the whole village?");
        }
        System.out.println("Tika ceremony with " + mainFamilyElder + " planned successfully for " + expectedGuests + " guests!");
    }

    public static void main(String[] args) {
        TikaCeremony valid = new TikaCeremony(30000, 20, "Hajurba");
        TikaCeremony tooFewGuests = new TikaCeremony(20000, 3, "Hajurba");
        TikaCeremony overBudget = new TikaCeremony(75000, 10, "Hajurba");

        TikaCeremony[] ceremonies = {valid, tooFewGuests, overBudget};

        for (TikaCeremony ceremony : ceremonies) {
            try {
                ceremony.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Guest Issue: " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Budget Issue: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("Planning Issue: " + e.getMessage());
            }
        }
    }
}
