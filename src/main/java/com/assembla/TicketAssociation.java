package com.assembla;

import com.assembla.enums.IntValuedEnum;
import com.assembla.enums.ValuedEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonRootName(value = "ticket_association")
public class TicketAssociation {
	
	public enum TicketRelationship implements IntValuedEnum {
		PARENT(0), 
		CHILD(1), 
		RELATED(2), 
		DUPLICATE(3), 
		SIBLING(4), 
		STORY(5), 
		SUBTASK(6), 
		DEPENDANT(7),
		BLOCK(8); 
		
		private int value;

		TicketRelationship(int value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public Integer getValue() {
			return value;
		}

		@JsonCreator
		public static TicketRelationship parse(int value) {
			return ValuedEnum.parse(value, TicketRelationship.values());
		}

	}
	
	public String createdAt;
	public Integer id;
	public TicketRelationship relationship;
	public Integer ticket1Id;
	public Integer ticket2Id;

	public String getCreatedAt() {
		return createdAt;
	}

	public Integer getId() {
		return id;
	}

	public TicketRelationship getRelationship() {
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

	public TicketAssociation setRelationship(TicketRelationship relationship) {
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
		builder.append("TicketAssociation [");
		if (createdAt != null) {
			builder.append("createdAt=");
			builder.append(createdAt);
			builder.append(", ");
		}
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (relationship != null) {
			builder.append("relationship=");
			builder.append(relationship);
			builder.append(", ");
		}
		if (ticket1Id != null) {
			builder.append("ticket1Id=");
			builder.append(ticket1Id);
			builder.append(", ");
		}
		if (ticket2Id != null) {
			builder.append("ticket2Id=");
			builder.append(ticket2Id);
		}
		builder.append("]");
		return builder.toString();
	}

}
