import java.math.BigDecimal;

public class TestNestedClass {
    public class TaxDetailInfo {
        private int level = 0;
		private double taxPercentage = 0.00;
		private BigDecimal netIncomePortion = BigDecimal.ZERO;
		private BigDecimal taxPortion = BigDecimal.ZERO;

		public double taxPercentage()
		{
			return taxPercentage;
		}

		public BigDecimal netIncomePortion()
		{
			return netIncomePortion;
		}

		public BigDecimal taxPortion()
		{
			return taxPortion;
		}
    }
    
    private TaxDetailInfo[] taxDetailInfo;
    
    public TestNestedClass() {
		// Watch out! Here, I often fooled to thought that following
		// line of code was actually created a 4 dimentional array which
		// containing 4 TaxDetailInfo() instances. It isn't! This command
		// only created a 4 dimentional array of type TaxDetailInfo().
        taxDetailInfo = new TaxDetailInfo[4];
		// Here are the commands that eventually instantiating the 
		// TaxDetailInfo() class and stored into each compartment of the
		// array variable.
		for (int i=0;i<taxDetailInfo.length;i++)
			taxDetailInfo[0] = new TaxDetailInfo();
    }
    
    public void setTaxDetailInfo() {
        taxDetailInfo[0].level = 1;
        taxDetailInfo[0].taxPercentage = 0.05;
        taxDetailInfo[0].netIncomePortion = new BigDecimal("25000000");
        taxDetailInfo[0].taxPortion = new BigDecimal("25000000");
    }

	public TaxDetailInfo getTaxDetailInfo(int index)
	{
		index = (index > 3 ? 3 : index);
		return taxDetailInfo[index];
	}
}
