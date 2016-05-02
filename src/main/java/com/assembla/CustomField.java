package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ticket")
public class CustomField {

	private Integer id;
	private String spaceToolId;
	private String type;
	private String title;
	private Object order;
	private Boolean required;
	private Boolean hide;
	private String defaultValue;
	private String createdAt;
	private String updatedAt;

	public CustomField() {
	}

	public Integer getId() {
		return id;
	}

	public CustomField setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getSpaceToolId() {
		return spaceToolId;
	}

	public CustomField setSpaceToolId(String spaceToolId) {
		this.spaceToolId = spaceToolId;
		return this;
	}

	public String getType() {
		return type;
	}

	public CustomField setType(String type) {
		this.type = type;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public CustomField setTitle(String title) {
		this.title = title;
		return this;
	}

	public Object getOrder() {
		return order;
	}

	public CustomField setOrder(Object order) {
		this.order = order;
		return this;
	}

	public Boolean getRequired() {
		return required;
	}

	public CustomField setRequired(Boolean required) {
		this.required = required;
		return this;
	}

	public Boolean getHide() {
		return hide;
	}

	public CustomField setHide(Boolean hide) {
		this.hide = hide;
		return this;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public CustomField setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public CustomField setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public CustomField setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		CustomField other = (CustomField) obj;
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
		if (updatedAt == null) {
			if (other.updatedAt != null) {
				return false;
			}
		} else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomField [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}
	
	

}