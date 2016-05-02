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

	public TicketComment setTicketChanges(String ticketChanges) {
		this.ticketChanges = ticketChanges;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public TicketComment setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public TicketComment setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public TicketComment setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public TicketComment setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public TicketComment setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public TicketComment setUserId(String userId) {
		this.userId = userId;
		return this;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TicketComment other = (TicketComment) obj;
		if (comment == null) {
			if (other.comment != null) {
				return false;
			}
		} else if (!comment.equals(other.comment)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (ticketId == null) {
			if (other.ticketId != null) {
				return false;
			}
		} else if (!ticketId.equals(other.ticketId)) {
			return false;
		}
		if (updatedAt == null) {
			if (other.updatedAt != null) {
				return false;
			}
		} else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}