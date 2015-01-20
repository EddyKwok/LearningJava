/**
 * 
 * @author Eddy
 */
 
 import java.math.*;
 import java.util.Calendar;
 
 public class PPh21 {
    public static final int minTahunPajak = 2012;
    
	private int tahunPajak = Calendar.getInstance().get(Calendar.YEAR);
	private MaritalStatus maritalStatus;
	private BigDecimal ptkp;
	private Month startMonth=Month.JANUARY, endMonth=Month.DECEMBER;

	private boolean isFinal=false;
	
	private BigDecimal bruto = BigDecimal.ZERO; // Sum of bruto exclude bonus from start to end  month.
	private BigDecimal thr = BigDecimal.ZERO; // Bonus dan/atau THR
	
    // Komponen Pengurang Penghasilan bruto.
    private BigDecimal biayaJbtRegular = BigDecimal.ZERO;   // Biaya Jabatan atas Penghasilan Rutin.
    private BigDecimal biayaJbtTHR = BigDecimal.ZERO; // Biaya Jabatan atas Penghasilan tidak rutin (THR/Bonus/Tantiem).
    private BigDecimal personalJHT = BigDecimal.ZERO; // Iuran Jaminan Hari Tua yang ditanggung oleh karyawan.
    
    private BigDecimal theYTDNetIncome = BigDecimal.ZERO;
    private BigDecimal theTaxableIncome = BigDecimal.ZERO; // Penghasil Kena Pajak
    private BigDecimal tax21YTD = BigDecimal.ZERO;         // PPh21 YTD
    
	public void setTahunPajak(int tahunPajak) {
	    this.tahunPajak = (tahunPajak < PPh21.minTahunPajak ? PPh21.minTahunPajak : tahunPajak);
	}
	
	public int getTahunPajak() {
	    return this.tahunPajak;
	}
	
	public void setPersonalJHT(BigDecimal pJHT) {
        this.personalJHT = pJHT;
    }
    
    public BigDecimal getPersonalJHT() {
        return this.personalJHT;
    }
    
    public BigDecimal getBiayaJbtRegular() {
        return this.biayaJbtRegular;
    }
    
    public BigDecimal getBiayaJbtTHR() {
        return this.biayaJbtTHR;
    }
        
    public void setMaritalStatus(MaritalStatus ms) {
	    PTKP objPTKP = new PTKP(this.tahunPajak, ms);
	    this.maritalStatus = ms;
	    this.ptkp = new BigDecimal(objPTKP.value());
	}
	
	public BigDecimal getPTKP() {
	    return this.ptkp;
	}
	
	public void setFinal(boolean fin) {
	    this.isFinal = fin;
	}
	
	public void setStartMonth(Month startMonth) throws InvalidMonthPeriodException {
	    if (startMonth.ordinal() > this.endMonth.ordinal())
	        throw new InvalidMonthPeriodException(startMonth, this.endMonth);
	    this.startMonth = startMonth;
	}
	
	public void setEndMonth(Month endMonth) throws InvalidMonthPeriodException {
	    if (endMonth.ordinal() < this.startMonth.ordinal())
	        throw new InvalidMonthPeriodException(this.startMonth, endMonth);
	    this.endMonth = endMonth;
	}
	
	public void setBruto(BigDecimal bruto) {
	    this.bruto = bruto;
	}
	
	public void setTHR(BigDecimal thr) {
	    this.thr = thr;
	}
        
    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }
    
    public BigDecimal getBruto() {
        return this.bruto;
    }
    
    public BigDecimal getTHR() {
        return this.thr;
    }
    
    public Month getStartMonth() {
        return this.startMonth;
    }
    
    public Month getEndMonth() {
        return this.endMonth;
    }
    
    public BigDecimal getYTDNetIncome() {
        return this.theYTDNetIncome;
    }
        	
	/*
         * Kalkulasi Biaya Jabatan atas penghasilan bruto rutin dan biaya jabatan atas THR/Bonus.
	 */
	private void setBiayaJbt(BigDecimal bruto, BigDecimal thr, Month startMonth, Month endMonth) {
        BigDecimal biayaJbtTHR = BigDecimal.ZERO;
        
        BigDecimal monthCnt = calcMonthCnt(startMonth, endMonth);
        BigDecimal maxBiayaJbt = OccupationFee.MaxValuePerMonth.multiply(monthCnt);
        
        BigDecimal biayaJbtRegular = OccupationFee.Percentage.multiply(bruto);
        biayaJbtRegular = biayaJbtRegular.setScale(0, RoundingMode.HALF_UP);
         
        if (biayaJbtRegular.compareTo(maxBiayaJbt)==1) // Bila biaya jabatan penghasilan rutin > max biaya jabatan, maka
            biayaJbtRegular = maxBiayaJbt;             // nilai biaya jabatan atas penghasilan rutin = max biaya jabatan.
        else {
            // Hitung biaya jabatan atas penghasilan tidak rutin (THR/Bonus).
            biayaJbtTHR = OccupationFee.Percentage.multiply(thr);
            biayaJbtTHR = biayaJbtTHR.setScale(0, RoundingMode.HALF_UP);
            BigDecimal mod = maxBiayaJbt.subtract(biayaJbtRegular);
            biayaJbtTHR = (biayaJbtTHR.compareTo(mod)==1 ? mod : biayaJbtTHR);
        }
        
        this.biayaJbtRegular = biayaJbtRegular;
        this.biayaJbtTHR = biayaJbtTHR;
	}
        
    public void setYTDNetIncome(BigDecimal bruto, BigDecimal thr, Month startMonth, Month endMonth) {
        BigDecimal monthCnt, finalMonthCnt;
        BigDecimal theNetIncome = bruto;
        
        setBiayaJbt(bruto, thr, startMonth, endMonth);
        
        theNetIncome = theNetIncome.subtract(this.biayaJbtRegular);
        theNetIncome = theNetIncome.subtract(this.personalJHT);
        
        monthCnt = calcMonthCnt(startMonth, endMonth);
        finalMonthCnt = calcMonthCnt(startMonth, isFinal ? endMonth : Month.DECEMBER);
        
        theNetIncome = theNetIncome.multiply(finalMonthCnt).divide(monthCnt);
        theNetIncome = theNetIncome.add(thr.subtract(this.biayaJbtTHR));
        theNetIncome = theNetIncome.setScale(0, RoundingMode.HALF_UP);
        
        this.theYTDNetIncome = theNetIncome;
    }
    
    public void setTaxableIncome(BigDecimal theYTDNetIncome, BigDecimal ptkp) {
        BigDecimal theNetIncome = theYTDNetIncome.subtract(ptkp);
        String t = theNetIncome.toString();
        if (t.length()>3) {
            t = t.substring(0, t.length()-3) + "000";
            this.theTaxableIncome = new BigDecimal(t);
        }
        else
            this.theTaxableIncome = theNetIncome;
    }
    
    public BigDecimal getTaxableIncome() {
        return this.theTaxableIncome;
    }
    
    private Pasal17[] psl17 = {Pasal17.TARIF_LEVEL_1,
                               Pasal17.TARIF_LEVEL_2,
                               Pasal17.TARIF_LEVEL_3,
                               Pasal17.TARIF_LEVEL_4};
                               
    private BigDecimal theTax = BigDecimal.ZERO, theNet = BigDecimal.ZERO;
    
    public void setTax21YTD(BigDecimal netYTD) {
        //this.tax21YTD = calcTax21(netYTD, 3);
        //System.out.println();
        this.tax21YTD = calcTax21H(netYTD, 0); 
    }
    
    public BigDecimal getTax21YTD() {
        return this.tax21YTD;
    }
    
    private BigDecimal calcTax21(BigDecimal netYTD, int level) {
        if (level>0)
            if (netYTD.compareTo(psl17[level].getIncomeRangeGTValue())==1) {
                // Hitung nilai pajak current level.
                theNet = netYTD.subtract(psl17[level-1].getIncomeRangeUpToValue());
                theTax = theNet.multiply(psl17[level].getTaxPercentage());
                System.out.print("Pajak (level: " + (level+1) + ") ");
                System.out.print(psl17[level].getTaxPercentage() + " dari ");
                System.out.println(theNet + " berikutnya : " + theTax);
                // Akumulasikan nilai pajak dari hasil perhitungan nilai pajak level sebelumnya.
                theTax = theTax.add(calcTax21(psl17[level-1].getIncomeRangeUpToValue(), level-1));
            }
            else
                calcTax21(netYTD, level-1);
        else {
            theTax = netYTD.multiply(psl17[level].getTaxPercentage());
            System.out.print("Pajak (level: " + (level+1) + ") ");
            System.out.print(psl17[level].getTaxPercentage() + " dari ");
            System.out.println(netYTD + " pertama : " + theTax);
            //return theTax;
        }
        return theTax; // Required by the compiler
    }
    
    /*
     * A more human readable result. This method does the tax calculation
     * from the lowest tax fare up to the next higher level. The end result of this method
     * is the same as the <code>calcTax21()</code> method.
     *
     * @deprecated
     * Since this was designed to be a based class, then: (1) It doesn't make any sense to 
     * print outputs to the standard screen display. (2) The detail information which were
     * printed out from calcTax21 & calcTax21H methods are moving out to this PPh21 based class'
     * fields and provided get methods. (3) The calcTax21 is more efficient than calcTax21H.
     */
    @Deprecated
    private BigDecimal calcTax21H(BigDecimal netYTD, int level) {
        if (level < 3)
            if (netYTD.compareTo(psl17[level].getIncomeRangeUpToValue())==1) {
                // Hitung pajak berjenjang upto, current level.
                BigDecimal upto = psl17[level].getIncomeRangeUpToValue();
                BigDecimal gt = psl17[level].getIncomeRangeGTValue();
                //theNet = theNet.subtract(upto.subtract(gt));
                theTax = upto.subtract(gt).multiply(psl17[level].getTaxPercentage());
                System.out.print("Pajak (Level: " + (level+1) + ") ");
                System.out.print(psl17[level].getTaxPercentage() + " dari ");
                System.out.println(upto.subtract(gt) + (level==0 ? " pertama : " : " berikutnya : ") + theTax);
                // Hitung pajak berjenjang level berikutnya, dan akumulasikan pajak current level ke hasil hitungan berikutnya.
                theTax = theTax.add(calcTax21H(netYTD, level+1));
            }
            else {
                // Hitung pajak level tertinggi atas net (sisa)
                theNet = netYTD.subtract(psl17[level].getIncomeRangeGTValue());
                theTax = theNet.multiply(psl17[level].getTaxPercentage());
                System.out.print("Pajak (Level: " + (level+1) + ") ");
                System.out.print(psl17[level].getTaxPercentage() + " dari ");
                System.out.println(theNet + (level==0 ? " pertama : " : " berikutnya : ") + theTax);
                return theTax;
            }
        else {
            // Hitung pajak level tertinggi dari tarif pajak perjenjang pasal 17.
            theNet = netYTD.subtract(psl17[level].getIncomeRangeGTValue());
            theTax = theNet.multiply(psl17[level].getTaxPercentage());
            System.out.print("Pajak (Level: " + (level+1) + ") ");
            System.out.print(psl17[level].getTaxPercentage() + " dari ");
            System.out.println(theNet + " berikutnya : " + theTax);
            return theTax;
        }
        return theTax; // Required by the compiler
    }
    
    private BigDecimal calcMonthCnt(Month startMonth, Month endMonth) {
        return (new BigDecimal(endMonth.getMonth()-startMonth.getMonth()+1));
    }
 }
