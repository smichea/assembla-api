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

	public void setPlannerType(Integer plannerType) {
		this.plannerType = plannerType;
	}

	public String getPrettyReleseLevel() {
		return prettyReleseLevel;
	}

	public void setPrettyReleseLevel(String prettyReleseLevel) {
		this.prettyReleseLevel = prettyReleseLevel;
	}

	public Object getReleaseNotes() {
		return releaseNotes;
	}

	public void setReleaseNotes(Object releaseNotes) {
		this.releaseNotes = releaseNotes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getReleaseLevel() {
		return releaseLevel;
	}

	public void setReleaseLevel(Object releaseLevel) {
		this.releaseLevel = releaseLevel;
	}

	public Object getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Object completedDate) {
		this.completedDate = completedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Object getDueDate() {
		return dueDate;
	}

	public void setDueDate(Object dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
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