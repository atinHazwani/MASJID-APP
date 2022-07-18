package mas.model;

public class Umrah {
	private String slotID; //primary key of Umrah Slot
	private String date;
	private String time;
	private String chapter;
	private String venue;
	private Slot slot;
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
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
