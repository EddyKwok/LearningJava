/*
 * @author Eddy
 */
 
public class InvalidMonthPeriodException extends Exception {
    private Month firstMonth, lastMonth;
    
    public InvalidMonthPeriodException(Month firstMonth, Month lastMonth) {
        super("The starting month period must be smaller or equal to the end month periode.");
        this.firstMonth = firstMonth;
        this.lastMonth = lastMonth;
    }
    
    public Month get1stMonth() {
        return this.firstMonth;
    }
    
    public Month getLastMonth() {
        return this.lastMonth;
    }
}