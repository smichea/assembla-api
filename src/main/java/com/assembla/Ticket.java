package com.assembla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ticket")
public class Ticket {

	private Integer id;
	private Integer number;
	private String summary;
	private String description;
	private Integer priority;
	private Object completedDate;
	private Object componentId;
	private String createdOn;
	private Integer permissionType;
	private Double importance;
	private Boolean isStory;
	private Object milestoneId;
	private String notificationList;
	private String spaceId;
	private Integer state;
	private String status;
	private Integer storyImportance;
	private String updatedAt;
	private Double workingHours;
	private Double estimate;
	private Double totalEstimate;
	private Double totalInvestedHours;
	private Double totalWorkingHours;
	private String assignedToId;
	private String reporterId;
	private Map<String, Object> customFields;
	private Integer hierarchyType;
	private List<String> tags;

	public Ticket() {
	}

	public Ticket(int id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public Ticket setNumber(int number) {
		this.number = number;
		return this;
	}

	public Ticket setStatus(String status) {
		this.status = status;
		return this;
	}

	public List<String> getTags() {
		return tags;
	}

	public Ticket setTags(List<String> tags) {
		this.tags = tags;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Ticket setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public Ticket setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Ticket setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getPriority() {
		return priority;
	}

	public Ticket setPriority(Integer priority) {
		this.priority = priority;
		return this;
	}

	public Object getCompletedDate() {
		return completedDate;
	}

	public Ticket setCompletedDate(Object completedDate) {
		this.completedDate = completedDate;
		return this;
	}

	public Object getComponentId() {
		return componentId;
	}

	public Ticket setComponentId(Object componentId) {
		this.componentId = componentId;
		return this;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public Ticket setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Integer getPermissionType() {
		return permissionType;
	}

	public Ticket setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
		return this;
	}

	public Double getImportance() {
		return importance;
	}

	public Ticket setImportance(Double importance) {
		this.importance = importance;
		return this;
	}

	public Boolean getIsStory() {
		return isStory;
	}

	public Ticket setIsStory(Boolean isStory) {
		this.isStory = isStory;
		return this;
	}

	public Object getMilestoneId() {
		return milestoneId;
	}

	public Ticket setMilestoneId(Object milestoneId) {
		this.milestoneId = milestoneId;
		return this;
	}

	public String getNotificationList() {
		return notificationList;
	}

	public Ticket setNotificationList(String notificationList) {
		this.notificationList = notificationList;
		return this;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public Ticket setSpaceId(String spaceId) {
		this.spaceId = spaceId;
		return this;
	}

	public Integer getState() {
		return state;
	}

	public Ticket setState(Integer state) {
		this.state = state;
		return this;
	}

	public Integer getStoryImportance() {
		return storyImportance;
	}

	public Ticket setStoryImportance(Integer storyImportance) {
		this.storyImportance = storyImportance;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Ticket setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public Double getWorkingHours() {
		return workingHours;
	}

	public Ticket setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
		return this;
	}

	public Double getEstimate() {
		return estimate;
	}

	public Ticket setEstimate(Double estimate) {
		this.estimate = estimate;
		return this;
	}

	public Double getTotalEstimate() {
		return totalEstimate;
	}

	public Ticket setTotalEstimate(Double totalEstimate) {
		this.totalEstimate = totalEstimate;
		return this;
	}

	public Double getTotalInvestedHours() {
		return totalInvestedHours;
	}

	public Ticket setTotalInvestedHours(Double totalInvestedHours) {
		this.totalInvestedHours = totalInvestedHours;
		return this;
	}

	public Double getTotalWorkingHours() {
		return totalWorkingHours;
	}

	public Ticket setTotalWorkingHours(Double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
		return this;
	}

	public String getAssignedToId() {
		return assignedToId;
	}

	public Ticket setAssignedToId(String assignedToId) {
		this.assignedToId = assignedToId;
		return this;
	}

	public String getReporterId() {
		return reporterId;
	}

	public Ticket setReporterId(String reporterId) {
		this.reporterId = reporterId;
		return this;
	}

	public Map<String, Object> getCustomFields() {
		return customFields;
	}

	public Ticket setCustomFields(Map<String, Object> customFields) {
		this.customFields = customFields;
		return this;
	}

	public Integer getHierarchyType() {
		return hierarchyType;
	}

	public Ticket setHierarchyType(Integer hierarchyType) {
		this.hierarchyType = hierarchyType;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Ticket setNumber(Integer number) {
		this.number = number;
		return this;
	}

	@JsonProperty("tags")
	public List<String> tags() {
		return tags;
	}

	public Ticket addTag(String tag) {
		if (tags == null) {
			tags = new ArrayList<>();
		}
		this.tags.add(tag);
		return this;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", description=");
		builder.append(description);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (spaceId == null) {
			if (other.spaceId != null) {
				return false;
			}
		} else if (!spaceId.equals(other.spaceId)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
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