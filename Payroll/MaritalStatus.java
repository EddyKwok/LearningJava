public enum MaritalStatus {
	S0(Married.NO, Dependent.NONE),
	S1(Married.NO, Dependent.ONE),
	S2(Married.NO, Dependent.TWO),
	S3(Married.NO, Dependent.THREE),
	K0(Married.YES, Dependent.NONE),
	K1(Married.YES, Dependent.ONE),
	K2(Married.YES, Dependent.TWO),
	K3(Married.YES, Dependent.THREE);
	
	private Married married;
	private Dependent dependent;
	
	MaritalStatus(Married m, Dependent d) {
		this.married = m;
		this.dependent = d;
	}
	
	private enum Married {
		YES, NO
	}
	
	/*
	 * @return <code>true</code>, <code>false</code>.
	 */
	public boolean isMarried() {
		return (married==Married.YES);
	}
	
	private enum Dependent {
		NONE(0), ONE(1), TWO(2), THREE(3);
		
		private final int numberOfDependency;
		
		Dependent(int nod) {
		    this.numberOfDependency = nod;
		}
		
		private int getNumberOfDependency() {
		    return this.numberOfDependency;
		}
	}
	
	public int getDependencyNumber() {
		return (dependent.getNumberOfDependency());
	}
}