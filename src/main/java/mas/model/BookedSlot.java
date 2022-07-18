package mas.model;

public class BookedSlot {
	private int bookID;
	private String slotID;
	private String userID;
	private String bookDate;
	
	public BookedSlot() {}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getSlotID() {
		return slotID;
	}

	public void setSlotID(String slotID) {
		this.slotID = slotID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	
}
