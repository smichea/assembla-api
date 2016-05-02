package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "milestone")
public class Milestone {

	private Integer plannerType;
	private String prettyReleseLevel;
	private Object releaseNotes;
	private String description;
	private Object releaseLevel;
	private Object completedDate;
	private String createdBy;
	private Object dueDate;
	private Boolean isCompleted;
	private String updatedBy;
	private String updatedAt;
	private String createdAt;
	private String title;
	private Object userId;
	private String id;
	private String spaceId;

	public Integer getPlannerType() {
		return plannerType;
	}

	public Milestone setPlannerType(Integer plannerType) {
		this.plannerType = plannerType;
		return this;
	}

	public String getPrettyReleseLevel() {
		return prettyReleseLevel;
	}

	public Milestone setPrettyReleseLevel(String prettyReleseLevel) {
		this.prettyReleseLevel = prettyReleseLevel;
		return this;
	}

	public Object getReleaseNotes() {
		return releaseNotes;
	}

	public Milestone setReleaseNotes(Object releaseNotes) {
		this.releaseNotes = releaseNotes;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Milestone setDescription(String description) {
		this.description = description;
		return this;
	}

	public Object getReleaseLevel() {
		return releaseLevel;
	}

	public Milestone setReleaseLevel(Object releaseLevel) {
		this.releaseLevel = releaseLevel;
		return this;
	}

	public Object getCompletedDate() {
		return completedDate;
	}

	public Milestone setCompletedDate(Object completedDate) {
		this.completedDate = completedDate;
		return this;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Milestone setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public Object getDueDate() {
		return dueDate;
	}

	public Milestone setDueDate(Object dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public Milestone setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
		return this;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Milestone setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Milestone setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Milestone setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Milestone setTitle(String title) {
		this.title = title;
		return this;
	}

	public Object getUserId() {
		return userId;
	}

	public Milestone setUserId(Object userId) {
		this.userId = userId;
		return this;
	}

	public String getId() {
		return id;
	}

	public Milestone setId(String id) {
		this.id = id;
		return this;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public Milestone setSpaceId(String spaceId) {
		this.spaceId = spaceId;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Milestone other = (Milestone) obj;
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
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Milestone [title=");
		builder.append(title);
		builder.append(", id=");
		builder.append(id);
		builder.append(", spaceId=");
		builder.append(spaceId);
		builder.append("]");
		return builder.toString();
	}

}