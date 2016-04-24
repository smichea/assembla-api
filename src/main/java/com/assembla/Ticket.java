package com.assembla;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ticket")
public class Ticket {
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(int id) {
		this.id = id;
	}

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

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Object getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Object completedDate) {
		this.completedDate = completedDate;
	}

	public Object getComponentId() {
		return componentId;
	}

	public void setComponentId(Object componentId) {
		this.componentId = componentId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public Double getImportance() {
		return importance;
	}

	public void setImportance(Double importance) {
		this.importance = importance;
	}

	public Boolean getIsStory() {
		return isStory;
	}

	public void setIsStory(Boolean isStory) {
		this.isStory = isStory;
	}

	public Object getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(Object milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(String notificationList) {
		this.notificationList = notificationList;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getStoryImportance() {
		return storyImportance;
	}

	public void setStoryImportance(Integer storyImportance) {
		this.storyImportance = storyImportance;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
	}

	public Double getEstimate() {
		return estimate;
	}

	public void setEstimate(Double estimate) {
		this.estimate = estimate;
	}

	public Double getTotalEstimate() {
		return totalEstimate;
	}

	public void setTotalEstimate(Double totalEstimate) {
		this.totalEstimate = totalEstimate;
	}

	public Double getTotalInvestedHours() {
		return totalInvestedHours;
	}

	public void setTotalInvestedHours(Double totalInvestedHours) {
		this.totalInvestedHours = totalInvestedHours;
	}

	public Double getTotalWorkingHours() {
		return totalWorkingHours;
	}

	public void setTotalWorkingHours(Double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

	public String getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(String assignedToId) {
		this.assignedToId = assignedToId;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public Map<String, Object> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(Map<String, Object> customFields) {
		this.customFields = customFields;
	}

	public Integer getHierarchyType() {
		return hierarchyType;
	}

	public void setHierarchyType(Integer hierarchyType) {
		this.hierarchyType = hierarchyType;
	}

	public String getStatus() {
		return status;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@JsonProperty("tags")
	public List<String> tags(){
		return tags;
	}
	
	public Ticket addTag(String tag) {
		if(tags == null) {
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
		builder.append(", milestoneId=");
		builder.append(milestoneId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", customFields=");
		if(tags != null) {
			tags().stream().forEach(builder::append);
		}
		builder.append("]");
		return builder.toString();
	}

}