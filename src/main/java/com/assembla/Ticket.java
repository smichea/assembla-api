package com.assembla;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assembla.client.CustomFieldSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName(value = "ticket")
public class Ticket {

	private Integer id;
	private Integer number;
	private String summary;
	private String description;
	private Priority priority;
	private ZonedDateTime completedDate;
	private Integer componentId;
	private String createdOn;
	private PermissionType permissionType;
	private Double importance;
	private Boolean isStory;
	private Integer milestoneId;
	private String notificationList;
	private String spaceId;
	private State state;
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
	@JsonSerialize(keyUsing = CustomFieldSerializer.class)
	private Map<String, String> customFields;
	private HeirarchyType hierarchyType;
	@JsonProperty("tags")
	private List<String> tags;
	private Boolean isSupport;
	private List<String> followers;

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

	public Priority getPriority() {
		return priority;
	}

	public Ticket setPriority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public ZonedDateTime getCompletedDate() {
		return completedDate;
	}

	public Ticket setCompletedDate(ZonedDateTime completedDate) {
		this.completedDate = completedDate;
		return this;
	}

	public Integer getComponentId() {
		return componentId;
	}

	public Ticket setComponentId(Integer componentId) {
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

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public Ticket setPermissionType(PermissionType permissionType) {
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

	public Integer getMilestoneId() {
		return milestoneId;
	}

	public Ticket setMilestoneId(Integer milestoneId) {
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

	public State getState() {
		return state;
	}

	public Ticket setState(State state) {
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

	public Map<String, String> getCustomFields() {
		return customFields;
	}

	public Ticket setCustomFields(Map<String, String> customFields) {
		this.customFields = customFields;
		return this;
	}

	public Ticket addCustomField(String name, String value) {
		if (this.customFields == null) {
			this.customFields = new HashMap<>();
		}
		customFields.put(name, value);
		return this;
	}

	public HeirarchyType getHierarchyType() {
		return hierarchyType;
	}

	public Ticket setHierarchyType(HeirarchyType hierarchyType) {
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

	public Boolean isSupport() {
		return isSupport;
	}

	public Ticket setIsSupport(Boolean isSupport) {
		this.isSupport = isSupport;
		return this;
	}

	public List<String> getFollowers() {
		return followers;
	}

	public Ticket setFollowers(List<String> followers) {
		this.followers = followers;
		return this;
	}

	public Ticket addFollower(String follower) {
		if (this.followers == null) {
			this.followers = new ArrayList<>();
		}
		followers.add(follower);
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
