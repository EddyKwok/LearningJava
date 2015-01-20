class A {
	public int x = 1;
	protected int y = 2;
	private int z = 3;
	int a = 100;
	static final String SEX = "Male.";
	
	public void setMyPrivateZ(int val) {
	    z = val; // We can also type this.z = val;
	}
	
	public int showMyPrivateZ() {
	    return z;
	}
}
