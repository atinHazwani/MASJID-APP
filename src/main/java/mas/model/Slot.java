package mas.model;

public class Slot {
	private int id;
	private String slotID;
	private String slotTime;
	private String slotDate;
	private Slot slot;
	
	public Slot(int id, String slotID, String slotTime, String slotDate, Slot slot) {
		super();
		this.id = id;
		this.slotID = slotID;
		this.slotTime = slotTime;
		this.slotDate = slotDate;
		this.slot = slot;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Slot() {}

	public String getSlotID() {
		return slotID;
	}

	public void setSlotID(String slotID) {
		this.slotID = slotID;
	}
	
	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public String getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	

}
