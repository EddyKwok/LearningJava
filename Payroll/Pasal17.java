/*
 * Tarif pajak pasal 17.
 */

import java.math.BigDecimal;

public enum Pasal17 {
    TARIF_LEVEL_1(TaxableIncomeRange.ZERO, TaxableIncomeRange.FIFTY_M, "0.05"),
    TARIF_LEVEL_2(TaxableIncomeRange.FIFTY_M, TaxableIncomeRange.TWO_HUNDRED_FIFTY_M, "0.15"),
    TARIF_LEVEL_3(TaxableIncomeRange.TWO_HUNDRED_FIFTY_M, TaxableIncomeRange.FIVE_HUNDRED_M, "0.25"),
    TARIF_LEVEL_4(TaxableIncomeRange.FIVE_HUNDRED_M, "0.3") ;
    
    private TaxableIncomeRange incomeRange_gt, incomeRange_upto;
    private BigDecimal taxPercentage;
    
    private enum TaxableIncomeRange {
        ZERO(0),
        FIFTY_M(50000000),
        TWO_HUNDRED_FIFTY_M(250000000),
        FIVE_HUNDRED_M(500000000);
        
        BigDecimal incomeRange;
        
        TaxableIncomeRange(int incomeRange) {
            this.incomeRange = new BigDecimal(incomeRange);
        }
        
        public BigDecimal getIncomeRangeValue() {
            return this.incomeRange;
        }
    }
    
    public BigDecimal getIncomeRangeGTValue() {
       return this.incomeRange_gt.getIncomeRangeValue();
    }
    
    public BigDecimal getIncomeRangeUpToValue() {
        return this.incomeRange_upto.getIncomeRangeValue();
    }
    
    public BigDecimal getTaxPercentage() {
        return this.taxPercentage;
    }
    
    Pasal17(TaxableIncomeRange t1, TaxableIncomeRange t2, String percent) {
        this.incomeRange_gt = t1;
        this.incomeRange_upto = t2;
        this.taxPercentage = new BigDecimal(percent);
    }
    
    Pasal17(TaxableIncomeRange t2, String percent) {
        this.incomeRange_gt = t2;
        this.taxPercentage = new BigDecimal(percent);
    }
}
