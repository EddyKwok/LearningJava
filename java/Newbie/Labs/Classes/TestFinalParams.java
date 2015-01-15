class TestFinalParams {
	public static void main(String[] args) {
		FinalParams myObject = new FinalParams();
		myObject.displayMsg("Testing", "Passing Messages", "");
		myObject.displayMsg("Here is...", "another testing.", "non-final parameter");
	}
}
