package mas.model;

public class JumaatPrayer {
	private String slotID;
	private String date;
	private String khutbahTitle;
	private Slot slot;
	
	public JumaatPrayer() {}

	public String getSlotID() {
		return slotID;
	}

	public void setSlotID(String slotID) {
		this.slotID = slotID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getKhutbahTitle() {
		return khutbahTitle;
	}

	public void setKhutbahTitle(String khutbahTitle) {
		this.khutbahTitle = khutbahTitle;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	
}
