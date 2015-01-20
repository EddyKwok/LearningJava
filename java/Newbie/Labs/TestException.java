public class TestException {
    public static void main(String[] args) {
        try {
            int x = devide(4, 0);
            System.out.println(x);
        } catch(BadNumberException e) {
            // Do something...
        }
    }
    
    private static int devide(int numberToDevide, int numberToDevideBy) throws BadNumberException {
            if (numberToDevideBy == 0) {
                throw new BadNumberException("Cannot devide by 0");
            }
            return numberToDevide / numberToDevideBy;
    }
    
    private static class BadNumberException extends Exception {
        BadNumberException(String errMsg) {
            System.out.println(errMsg);
        }
    }
}
