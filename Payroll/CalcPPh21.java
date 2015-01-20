public class CalcPPh21 {
	public static void main(String[] args) {
		PPh21 pph21 = new PPh21();
		
		pph21.setMaritalStatus(readMaritalStatus());
		
		System.out.println("Marital Status = " + pph21.getMaritalStatus() + ", PTKP = " + pph21.getPTKP());
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