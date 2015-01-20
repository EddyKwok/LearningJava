/*
 * Used to hold PTKP's value. The value is calculated based on MaritalStatus
 * enum passed to the construction method.
 *
 * @author Eddy
 */

public class PTKP {
    // Not sure mulai kapan berlakunya
    private static final int PRIMARY_PTKP_BEF_2013 = 15840000;
    private static final int ADDITIONAL_PTKP_BEF_2013 = 1320000;
    
    // Berlaku per 1 Januari 2013
    private static final int PRIMARY_PTKP_2013 = 24300000;
    private static final int ADDITIONAL_PTKP_2013 = 2025000;
    
    private int ptkp;
    
    public PTKP(int tahunPajak, MaritalStatus maritalStatus) {
        ptkp = tahunPajak > 2012 ? PRIMARY_PTKP_2013 : PRIMARY_PTKP_BEF_2013;
        
        if (maritalStatus.isMarried())
            ptkp += tahunPajak > 2012 ? ADDITIONAL_PTKP_2013 : ADDITIONAL_PTKP_BEF_2013;
            
        int additionalPTKPs = maritalStatus.getDependencyNumber() * (tahunPajak > 2012 ? ADDITIONAL_PTKP_2013 : ADDITIONAL_PTKP_BEF_2013);
        
        ptkp += additionalPTKPs;
    }
    
    public int value() {
        return this.ptkp;
    }
}