package assignment;

/* simple POJO to contain the payment data like month, rentPaymentDay, energyPaymentDay 
 * author:nirozjungkarki
 * */

public class PaymentDate {
	String month;
	int rentPaymentDay;
	int energyPaymentDay;
	
	public PaymentDate(){
		
	}
	public PaymentDate(String month, int rentPaymentDay, int energyPaymentDay) {
		super();
		this.month = month;
		this.rentPaymentDay = rentPaymentDay;
		this.energyPaymentDay = energyPaymentDay;
	}
	// Getters and Setters
	public void setMonth(String month) {
		this.month = month;
	}
	public void setRentPaymentDay(int rentPaymentDay) {
		this.rentPaymentDay = rentPaymentDay;
	}
	public void setEnergyPaymentDay(int energyPaymentDay) {
		this.energyPaymentDay = energyPaymentDay;
	}
	public String getMonth() {
		return month;
	}
	public int getRentPaymentDay() {
		return rentPaymentDay;
	}
	public int getEnergyPaymentDay() {
		return energyPaymentDay;
	}
	@Override
	public String toString() {
		return "PaymentDate [month=" + month + ", rentPaymentDay=" + rentPaymentDay + ", energyPaymentDay="
				+ energyPaymentDay + "]";
	}
}
