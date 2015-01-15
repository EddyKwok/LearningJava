class FinalParams {
	void displayMsg(final String msg1, final String msg2, String msg3) {
		System.out.println(msg1);
		System.out.println(msg2);

		// Following code will causing error while compiling.
		// msg2 = msg2 + ". Hi, Doraemon.";

		if (msg3 != "non-final parameter")
			msg3 += ". What?!";
		System.out.println(msg3);
	}
}
