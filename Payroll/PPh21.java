/**
 * 
 * @author Eddy
 */
 
 import java.math.*;
 
 public class PPh21 {
	private MaritalStatus maritalStatus;
	private int ptkp;
	private Month firstMonth=Month.JANUARY, lastMonth=Month.DECEMBER;

	private boolean Final=false;
	
	private BigDecimal brutto = new BigDecimal(BigDecimal.ZERO);
	private BigDecimal bonus = new BigDecimal(BigDecimal.ZERO);
	
	private boolean hasMaritalStatusSet, has1stMonthSet;
	private boolean hasLastMonthSet, hasFinalSet, hasBruttoSet, hasBonusSet;
	
	private BigDecimal OccupationFeeValue = new BigDecimal(BigDecimal.ZERO);
        private BigDecimal oFeeReg = new BigDecimal(BigDecimal.ZERO);
        private BigDecimal oFeeBonus = new BigDecimal(BigDecimal.ZERO);
	
	public void setMaritalStatus(MaritalStatus ms) {
	    PTKP objPTKP = new PTKP(ms);
	    
		this.maritalStatus = ms;
		this.ptkp = objPTKP.value();
                
                this.hasMaritalStatusSet = true;
	}
	
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	
	public int getPTKP() {
	    return this.ptkp;
	}
	
	public void setFinal(boolean fin) {
	    this.Final = fin;
            this.hasFinalSet = true;
	}
	
	public void set1stMonth(Month firstMonth) throws InvalidMonthPeriodException {
	    if (firstMonth.ordinal() < this.lastMonth.ordinal())
	        throw InvalidMonthPeriodException(firstMonth, this.lastMonth);
	    this.firstMonth = firstMonth;
            this.hasFirstMonthSet = true;
	}
	
	public void setLastMonth(Month lastMonth) throws InvalidMonthPeriodException {
	    if (lastMonth.ordinal() < this.firstMonth.ordinal())
	        throw InvalidMonthPeriodException(this.firstMonth, lastMonth);
	    this.lastMonth = lastMonth;
            this.hasLastMonthSet = true;
	}
	
	public void setBrutto(BigDecimal brutto) {
	    this.brutto = brutto;
            this.hasBruttoSet = true;
	}
	
	public void setBonus(BigDecimal bonus) {
	    this.bonus = bonus;
            this.hasBonusSet = true;
	}
	
	/*
	 * Should only be excecuted when month periods and Final have been set.
	 */
	private void CalcOccupationFeeValue() {
	    assert has1stMonthSet && hasLastMonthSet && hasFinalSet && hasBruttoSet && hasBonusSet;
	    
            int monthCnt = 0;
            
            if (isFinal)
                monthCnt = this.lastMonth.getMonth()-this.firstMonth.getMonth()+1;
            else
                monthCnt = 12-this.firstMonthh.getMonth()+1;
            
            BigDecimal oFee = new BigDecimal(OccupationFee.Percentage.multiply(this.brutto));
            oFee = oFee.setScale(0, RoundingMode.HALF_UP);
            
            BigDecimal maxOcFee = OccupationFee.MaxValuePerMonth.multiply(monthCnt);
            
            BIgDecimal oFeeBonus = new BigDecimal(BigDecimal.ZERO);
            
            if (oFee.compareTo(maxOcFee)==1)
                oFee = maxOcFee; // Biaya Jabatan as Brutto exclude THR
            else {
                oFeeBonus = OccupationFee.MaxValuePerMonth.multiply(this.brutto);
                oFeeBonus = oFeeBonus.setScale(0, RoundingMode.HALF_UP);
                BigDecimal mod = new BigDecimal(maxOcFee.subtract(oFee));
                oFeeBonus = (oFeeBonus.compareTo(mod)==1 ? mod : oFeeBonus);
            }
            
            this.oFeeReg = oFee;
            this.oFeeBonus = oFeeBonus;
	}
 }
