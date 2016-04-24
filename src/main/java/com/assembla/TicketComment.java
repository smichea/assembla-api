package com.assembla;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ticket_comment")
public class TicketComment {

	private String ticketChanges;
	private Integer id;
	private String createdOn;
	private Integer ticketId;
	private String comment;
	private String updatedAt;
	private String userId;

	public String getTicketChanges() {
		return ticketChanges;
	}

	public void setTicketChanges(String ticketChanges) {
		this.ticketChanges = ticketChanges;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TicketComment [id=");
		builder.append(id);
		builder.append(", ticketId=");
		builder.append(ticketId);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}

	
	
}