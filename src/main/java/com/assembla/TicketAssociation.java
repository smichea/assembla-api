package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ticket_association")
public class TicketAssociation {

	public String createdAt;
	public Integer id;
	public Integer relationship;
	public Integer ticket1Id;
	public Integer ticket2Id;

	public String getCreatedAt() {
		return createdAt;
	}

	public Integer getId() {
		return id;
	}

	public Integer getRelationship() {
		return relationship;
	}

	public Integer getTicket1Id() {
		return ticket1Id;
	}

	public Integer getTicket2Id() {
		return ticket2Id;
	}

	public TicketAssociation setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public TicketAssociation setId(Integer id) {
		this.id = id;
		return this;
	}

	public TicketAssociation setRelationship(Integer relationship) {
		this.relationship = relationship;
		return this;
	}

	public TicketAssociation setTicket1Id(Integer ticket1Id) {
		this.ticket1Id = ticket1Id;
		return this;
	}

	public TicketAssociation setTicket2Id(Integer ticket2Id) {
		this.ticket2Id = ticket2Id;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TicketAssociation [createdAt=");
		builder.append(createdAt);
		builder.append(", id=");
		builder.append(id);
		builder.append(", relationship=");
		builder.append(relationship);
		builder.append(", ticket1Id=");
		builder.append(ticket1Id);
		builder.append(", ticket2Id=");
		builder.append(ticket2Id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
		result = prime * result + ((ticket1Id == null) ? 0 : ticket1Id.hashCode());
		result = prime * result + ((ticket2Id == null) ? 0 : ticket2Id.hashCode());
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
		TicketAssociation other = (TicketAssociation) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (relationship == null) {
			if (other.relationship != null) {
				return false;
			}
		} else if (!relationship.equals(other.relationship)) {
			return false;
		}
		if (ticket1Id == null) {
			if (other.ticket1Id != null) {
				return false;
			}
		} else if (!ticket1Id.equals(other.ticket1Id)) {
			return false;
		}
		if (ticket2Id == null) {
			if (other.ticket2Id != null) {
				return false;
			}
		} else if (!ticket2Id.equals(other.ticket2Id)) {
			return false;
		}
		return true;
	}

}