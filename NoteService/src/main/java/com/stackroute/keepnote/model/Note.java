package com.stackroute.keepnote.model;

import java.util.Date;
import java.util.List;

public class Note {
	
	/*
	 * This class should have eight fields
	 * (noteId,noteTitle,noteContent,noteStatus,createdAt,
	 * category,reminder,createdBy). This class should also contain the
	 * getters and setters for the fields along with the no-arg , parameterized
	 * constructor and toString method. The value of createdAt should not be
	 * accepted from the user but should be always initialized with the system date.
	 * 
	 */


	private int noteId;
	private String noteTitle;
	
	private String noteContent;
	
	private String noteStatus;
	
	//private Date createdAt;
	
	private Date noteCreationDate;
	
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteCreatedBy() {
		return noteCreatedBy;
	}
	public void setNoteCreatedBy(String noteCreatedBy) {
		this.noteCreatedBy = noteCreatedBy;
	}

	private String noteCreatedBy;

	private Category category;
    
    public Note(int noteId, String noteTitle, String noteContent, String noteStatus, Date noteCreationDate, 
			Category category, Reminder reminder,String noteCreatedBy) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.noteCreationDate = noteCreationDate;
		this.noteCreatedBy = noteCreatedBy;
		this.category = category;
		this.reminders = reminders;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


	public Date getNoteCreationDate() {
		return noteCreationDate;
	}
	public void setNoteCreationDate(Date noteCreationDate) {
		this.noteCreationDate = noteCreationDate;
	}
	private List<Reminder> reminders;
	
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	@Override
	public String toString() {
		return "Note [noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteStatus=" + noteStatus
				+ ", createdAt=" + noteCreationDate + ", categoty=" + category + ", reminder=" + reminders + "]";
	}
	public Note() {
		super();
	}
	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}
	/*
	 * public Date getCreatedAt() { return createdAt; } public void
	 * setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	 */
	public List<Reminder> getReminders() {
		return reminders;
	}
	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	
}
