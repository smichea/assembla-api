package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "tag")
public class Tag {

	private Integer id;
	private String name;
	private String spaceId;
	private Integer state;
	private String createdAt;
	private String updatedAt;

	public Integer getId() {
		return id;
	}

	public Tag setId(Integer id) {
		this.id = id;return this;
	}

	public String getName() {
		return name;
	}

	public Tag setName(String name) {
		this.name = name;return this;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public Tag setSpaceId(String spaceId) {
		this.spaceId = spaceId;return this;
	}

	public Integer getState() {
		return state;
	}

	public Tag setState(Integer state) {
		this.state = state;return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Tag setCreatedAt(String createdAt) {
		this.createdAt = createdAt;return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Tag setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
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
		Tag other = (Tag) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (spaceId == null) {
			if (other.spaceId != null) {
				return false;
			}
		} else if (!spaceId.equals(other.spaceId)) {
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

}