package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "space")
public class Space {

	private Integer status;
	private Object bannerHeight;
	private Object banner;
	private String updatedAt;
	private Object lastPayerChangedAt;
	private Integer teamTabRole;
	private String createdAt;
	private Boolean approved;
	private Object tabsOrder;
	private Boolean isCommercial;
	private Boolean isManager;
	private Integer teamPermissions;
	private Boolean canJoin;
	private Object bannerText;
	private Boolean restricted;
	private Boolean sharePermissions;
	private Boolean canApply;
	private Boolean isVolunteer;
	private Integer privatePermissions;
	private String wikiName;
	private String name;
	private Object style;
	private Object parentId;
	private String defaultShowpage;
	private Object description;
	private String id;
	private Object bannerLink;
	private Object commercialFrom;
	private Object restrictedDate;
	private Integer watcherPermissions;

	public Space() {
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getBannerHeight() {
		return bannerHeight;
	}

	public void setBannerHeight(Object bannerHeight) {
		this.bannerHeight = bannerHeight;
	}

	public Object getBanner() {
		return banner;
	}

	public void setBanner(Object banner) {
		this.banner = banner;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Object getLastPayerChangedAt() {
		return lastPayerChangedAt;
	}

	public void setLastPayerChangedAt(Object lastPayerChangedAt) {
		this.lastPayerChangedAt = lastPayerChangedAt;
	}

	public Integer getTeamTabRole() {
		return teamTabRole;
	}

	public void setTeamTabRole(Integer teamTabRole) {
		this.teamTabRole = teamTabRole;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Object getTabsOrder() {
		return tabsOrder;
	}

	public void setTabsOrder(Object tabsOrder) {
		this.tabsOrder = tabsOrder;
	}

	public Boolean getIsCommercial() {
		return isCommercial;
	}

	public void setIsCommercial(Boolean isCommercial) {
		this.isCommercial = isCommercial;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Integer getTeamPermissions() {
		return teamPermissions;
	}

	public void setTeamPermissions(Integer teamPermissions) {
		this.teamPermissions = teamPermissions;
	}

	public Boolean getCanJoin() {
		return canJoin;
	}

	public void setCanJoin(Boolean canJoin) {
		this.canJoin = canJoin;
	}

	public Object getBannerText() {
		return bannerText;
	}

	public void setBannerText(Object bannerText) {
		this.bannerText = bannerText;
	}

	public Boolean getRestricted() {
		return restricted;
	}

	public void setRestricted(Boolean restricted) {
		this.restricted = restricted;
	}

	public Boolean getSharePermissions() {
		return sharePermissions;
	}

	public void setSharePermissions(Boolean sharePermissions) {
		this.sharePermissions = sharePermissions;
	}

	public Boolean getCanApply() {
		return canApply;
	}

	public void setCanApply(Boolean canApply) {
		this.canApply = canApply;
	}

	public Boolean getIsVolunteer() {
		return isVolunteer;
	}

	public void setIsVolunteer(Boolean isVolunteer) {
		this.isVolunteer = isVolunteer;
	}

	public Integer getPrivatePermissions() {
		return privatePermissions;
	}

	public void setPrivatePermissions(Integer privatePermissions) {
		this.privatePermissions = privatePermissions;
	}

	public String getWikiName() {
		return wikiName;
	}

	public void setWikiName(String wikiName) {
		this.wikiName = wikiName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getStyle() {
		return style;
	}

	public void setStyle(Object style) {
		this.style = style;
	}

	public Object getParentId() {
		return parentId;
	}

	public void setParentId(Object parentId) {
		this.parentId = parentId;
	}

	public String getDefaultShowpage() {
		return defaultShowpage;
	}

	public void setDefaultShowpage(String defaultShowpage) {
		this.defaultShowpage = defaultShowpage;
	}

	public Object getDescription() {
		return description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(Object bannerLink) {
		this.bannerLink = bannerLink;
	}

	public Object getCommercialFrom() {
		return commercialFrom;
	}

	public void setCommercialFrom(Object commercialFrom) {
		this.commercialFrom = commercialFrom;
	}

	public Object getRestrictedDate() {
		return restrictedDate;
	}

	public void setRestrictedDate(Object restrictedDate) {
		this.restrictedDate = restrictedDate;
	}

	public Integer getWatcherPermissions() {
		return watcherPermissions;
	}

	public void setWatcherPermissions(Integer watcherPermissions) {
		this.watcherPermissions = watcherPermissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Space other = (Space) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}