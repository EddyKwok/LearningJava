/*
 * Used to hold PTKP's value. The value is calculated based on MaritalStatus
 * enum passed to the construction method.
 *
 * @author Eddy
 */

public class PTKP {
    private static final int PRIMARY_PTKP = 24300000;
    private static final int ADDITIONAL_PTKP = 2025000;
    
    private int ptkp = PRIMARY_PTKP;
    
    public PTKP(MaritalStatus maritalStatus) {
        if (maritalStatus.isMarried())
            ptkp += ADDITIONAL_PTKP;
            
        int additionalPTKPs = maritalStatus.getDependencyNumber() * ADDITIONAL_PTKP;
        
        ptkp += additionalPTKPs;
    }
    
    public int value() {
        return this.ptkp;
    }
}