import java.math.BigDecimal;
import java.util.Scanner;

public class CalcPPh21 {
    private static Month m1, m2;
    private static Scanner sc = new Scanner(System.in);
    private static PPh21 pph21 = new PPh21();    
    
	public static void main(String[] args) {
	    int defaultTahunPajak = pph21.getTahunPajak();
	    System.out.print("Tahun Pajak [Invalid input = default = " + defaultTahunPajak + "]: ");
	    try {
	        pph21.setTahunPajak(sc.nextInt());
	        if (pph21.getTahunPajak()<PPh21.minTahunPajak)
	            pph21.setTahunPajak(defaultTahunPajak);
	    }
	    catch (java.util.InputMismatchException e) {
	        pph21.setTahunPajak(defaultTahunPajak);
	    }
	    
        pph21.setMaritalStatus(readMaritalStatus());
        
        try {
            System.out.print("Periode awal (1) Januari, (2) Februari, ... (12) Desember: ");
            m1 = getMonth();
            System.out.print("Periode akhir (1) Januari, (2) Februari, ... (12) Desember: ");
            m2 = getMonth(); 
            pph21.setStartMonth(m1);
            pph21.setEndMonth(m2);
        }
        catch (InvalidMonthPeriodException e) {
            System.out.println("Invalid range of period! Start & end month auto-switched to the default value.");
            try {
                pph21.setStartMonth(Month.JANUARY);
                pph21.setEndMonth(Month.DECEMBER);
            }
            catch (InvalidMonthPeriodException e2) {
                assert false;
            }
        }
        
        System.out.println("Selected start month: " + pph21.getStartMonth() + ", end month: " + pph21.getEndMonth());
        
        System.out.print("Final (has already resigned) (1) No, (2) Yes [Invalid input = default = 1]? ");
        pph21.setFinal((sc.nextInt()==2));
        
        System.out.print("Bruto YTD [Invalid input = default = 600000000] = ");
        try {
            pph21.setBruto(sc.nextBigDecimal());
        }
        catch (java.util.InputMismatchException e2) {
            pph21.setBruto(new BigDecimal("600000000"));
        }
        
        System.out.print("Tantiem, Bonus, Gratifikasi, Jasa Produksi & THR [Invalid input = default = 0] = ");
        try {
            pph21.setTHR(sc.nextBigDecimal());
        }
        catch (java.util.InputMismatchException e3) {
            pph21.setTHR(BigDecimal.ZERO);
        }
        
        System.out.print("JHT ditanggung karyawan (2% dari bruto) [Invalid input = default = 0] = ");
        try {
            pph21.setPersonalJHT(sc.nextBigDecimal());
        }
        catch (java.util.InputMismatchException e4) {
            pph21.setPersonalJHT(BigDecimal.ZERO);
        }
        
        CalcAndDisplayResults();
	}
	
	private static void CalcAndDisplayResults() {
        System.out.println();
        System.out.println("CALCULATION RESULTS: ");
        
        System.out.println();
        System.out.println("Tax Period : " + pph21.getStartMonth() + " - " + pph21.getEndMonth() + " " + pph21.getTahunPajak());
        System.out.println("Marital Status : " + pph21.getMaritalStatus());
        System.out.println();
        System.out.println("PENGHASILAN BRUTO:");
        System.out.println("Total penghasilan bruto: " + pph21.getBruto());
        System.out.println("Tantiem, Bonus, Gratifikasi, THR : " + pph21.getTHR());
        
        pph21.setYTDNetIncome(pph21.getBruto(), pph21.getTHR(), pph21.getStartMonth(), pph21.getEndMonth());
        
        System.out.println();
        System.out.println("PENGURANG BRUTO:");
        System.out.println("Jaminan Hari Tua yang boleh dikurangkan dari Bruto: " + pph21.getPersonalJHT());
        System.out.println("Biaya Jabatan atas penghasilan rutin: " + pph21.getBiayaJbtRegular());
        System.out.println("Biaya Jabatan atas penghasilan THR/Bonus/Tantiem: " + pph21.getBiayaJbtTHR());
        
        System.out.println();
        System.out.println("Penghasilan Netto YTD : " + pph21.getYTDNetIncome());
        System.out.println("PTKP : " + pph21.getPTKP());
        
        pph21.setTaxableIncome(pph21.getYTDNetIncome(), pph21.getPTKP());
        
        System.out.println("Penghasilan Kena Pajak YTD : " + pph21.getTaxableIncome());
        
        pph21.setTax21YTD(pph21.getTaxableIncome());
        
        System.out.println("PPh21 YTD : " + pph21.getTax21YTD());
	}
	
	private static Month getMonth() {
	    int m = 0;
	    Month selectedMonth = Month.JANUARY;
	    while (m < 1 || m > 12) {
	        m = sc.nextInt();
    	    switch (m) {
    	        case 1: selectedMonth = Month.JANUARY; break;
    	        case 2: selectedMonth = Month.FEBRUARY; break;
    	        case 3: selectedMonth = Month.MARCH; break;
    	        case 4: selectedMonth = Month.APRIL; break;
    	        case 5: selectedMonth = Month.MAY; break;
    	        case 6: selectedMonth = Month.JUNE; break;
    	        case 7: selectedMonth = Month.JULY; break;
    	        case 8: selectedMonth = Month.AUGUST; break;
    	        case 9: selectedMonth = Month.SEPTEMBER; break;
    	        case 10: selectedMonth = Month.OCTOBER; break;
    	        case 11: selectedMonth = Month.NOVEMBER; break;
    	        case 12: selectedMonth = Month.DECEMBER;
    	    }
	    }
	    return selectedMonth;
	}
	
	private static int prompt(String msg, int min, int max) {
        System.out.print(msg);
	    try {
	        int ch = 0;
	        while (ch-48 < min || ch-48 > max) {
	            ch = System.in.read();
	            while (System.in.read() != '\n');
	        }
	        return ch;
	    }
	    catch (java.io.IOException e) {
	        // What do I do?!
	    }
	    return 0;
	}
	
	private static MaritalStatus readMaritalStatus() {
	    MaritalStatus ms = MaritalStatus.S0;
	    int selectedMaritalStatus = 0;
	    
	    selectedMaritalStatus = prompt("Marital status (1) S0, (2) S1, (3) S2, (4) S3, "+
	                                   "(5) K0, (6) K1, (7) K2, (8) K3 ? ", 1, 8);
	                                   
	    switch(selectedMaritalStatus-48) {
	        case 1: ms = MaritalStatus.S0; break;
	        case 2: ms = MaritalStatus.S1; break;
	        case 3: ms = MaritalStatus.S2; break;
	        case 4: ms = MaritalStatus.S3; break;
	        case 5: ms = MaritalStatus.K0; break;
            case 6: ms = MaritalStatus.K1; break;
            case 7: ms = MaritalStatus.K2; break;
            case 8: ms = MaritalStatus.K3; break;
            default: assert selectedMaritalStatus > 8 : "selectedMaritalStatus = " + selectedMaritalStatus;
	    }
	    
	    return ms;
	}
}
