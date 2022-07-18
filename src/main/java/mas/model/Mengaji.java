package mas.model;

public class Mengaji {
	private String slotID; //primary key of Mengaji Slot
	private String date; 
	private String time;
	private String guruname;
	private String venue;
	private Slot slot;
	
	public String getSlotID() {
		return slotID;
	}
	public void setSlotID(String string) {
		this.slotID = string;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGuruname() {
		return guruname;
	}
	public void setGuruname(String guruname) {
		this.guruname = guruname;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
}
