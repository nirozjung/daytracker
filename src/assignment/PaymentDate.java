package assignment;

/** A simple POJO that contains payment date like month, rentPaymentDay, energyPaymentDay 
 * @author nirozjungkarki
 * @since 2016-07-20
 * */

public class PaymentDate {
	String month;
	int rentPaymentDay;
	int energyPaymentDay;

	public PaymentDate() {

	}
	/**
	 * @param month    
	 * @param rentPaymentDay 
	 * @param energyPaymentDay      
	 */
	public PaymentDate(String month, int rentPaymentDay, int energyPaymentDay) {
		super();
		this.month = month;
		this.rentPaymentDay = rentPaymentDay;
		this.energyPaymentDay = energyPaymentDay;
	}

	// Getters and Setters
	/**
	 * @param month the month to set         
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * @param rentPaymentDay the rentPaymentDay to set         
	 */
	public void setRentPaymentDay(int rentPaymentDay) {
		this.rentPaymentDay = rentPaymentDay;
	}
	/**
	 * @param energyPaymentDay the energyPaymentDay to set         
	 */
	public void setEnergyPaymentDay(int energyPaymentDay) {
		this.energyPaymentDay = energyPaymentDay;
	}
	/**
	 * @return the month         
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @return the rentPaymentDay         
	 */
	public int getRentPaymentDay() {
		return rentPaymentDay;
	}

	/**
	 * @return the energyPaymentDay         
	 */
	public int getEnergyPaymentDay() {
		return energyPaymentDay;
	}

	@Override
	public String toString() {
		return "PaymentDate [month=" + month + ", rentPaymentDay=" + rentPaymentDay + ", energyPaymentDay="
				+ energyPaymentDay + "]";
	}
}
