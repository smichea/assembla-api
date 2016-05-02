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

	public Space setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Object getBannerHeight() {
		return bannerHeight;
	}

	public Space setBannerHeight(Object bannerHeight) {
		this.bannerHeight = bannerHeight;
		return this;
	}

	public Object getBanner() {
		return banner;
	}

	public Space setBanner(Object banner) {
		this.banner = banner;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Space setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public Object getLastPayerChangedAt() {
		return lastPayerChangedAt;
	}

	public Space setLastPayerChangedAt(Object lastPayerChangedAt) {
		this.lastPayerChangedAt = lastPayerChangedAt;
		return this;
	}

	public Integer getTeamTabRole() {
		return teamTabRole;
	}

	public Space setTeamTabRole(Integer teamTabRole) {
		this.teamTabRole = teamTabRole;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Space setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public Boolean getApproved() {
		return approved;
	}

	public Space setApproved(Boolean approved) {
		this.approved = approved;
		return this;
	}

	public Object getTabsOrder() {
		return tabsOrder;
	}

	public Space setTabsOrder(Object tabsOrder) {
		this.tabsOrder = tabsOrder;
		return this;
	}

	public Boolean getIsCommercial() {
		return isCommercial;
	}

	public Space setIsCommercial(Boolean isCommercial) {
		this.isCommercial = isCommercial;
		return this;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public Space setIsManager(Boolean isManager) {
		this.isManager = isManager;
		return this;
	}

	public Integer getTeamPermissions() {
		return teamPermissions;
	}

	public Space setTeamPermissions(Integer teamPermissions) {
		this.teamPermissions = teamPermissions;
		return this;
	}

	public Boolean getCanJoin() {
		return canJoin;
	}

	public Space setCanJoin(Boolean canJoin) {
		this.canJoin = canJoin;
		return this;
	}

	public Object getBannerText() {
		return bannerText;
	}

	public Space setBannerText(Object bannerText) {
		this.bannerText = bannerText;
		return this;
	}

	public Boolean getRestricted() {
		return restricted;
	}

	public Space setRestricted(Boolean restricted) {
		this.restricted = restricted;
		return this;
	}

	public Boolean getSharePermissions() {
		return sharePermissions;
	}

	public Space setSharePermissions(Boolean sharePermissions) {
		this.sharePermissions = sharePermissions;
		return this;
	}

	public Boolean getCanApply() {
		return canApply;
	}

	public Space setCanApply(Boolean canApply) {
		this.canApply = canApply;
		return this;
	}

	public Boolean getIsVolunteer() {
		return isVolunteer;
	}

	public Space setIsVolunteer(Boolean isVolunteer) {
		this.isVolunteer = isVolunteer;
		return this;
	}

	public Integer getPrivatePermissions() {
		return privatePermissions;
	}

	public Space setPrivatePermissions(Integer privatePermissions) {
		this.privatePermissions = privatePermissions;
		return this;
	}

	public String getWikiName() {
		return wikiName;
	}

	public Space setWikiName(String wikiName) {
		this.wikiName = wikiName;
		return this;
	}

	public String getName() {
		return name;
	}

	public Space setName(String name) {
		this.name = name;
		return this;
	}

	public Object getStyle() {
		return style;
	}

	public Space setStyle(Object style) {
		this.style = style;
		return this;
	}

	public Object getParentId() {
		return parentId;
	}

	public Space setParentId(Object parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getDefaultShowpage() {
		return defaultShowpage;
	}

	public Space setDefaultShowpage(String defaultShowpage) {
		this.defaultShowpage = defaultShowpage;
		return this;
	}

	public Object getDescription() {
		return description;
	}

	public Space setDescription(Object description) {
		this.description = description;
		return this;
	}

	public String getId() {
		return id;
	}

	public Space setId(String id) {
		this.id = id;
		return this;
	}

	public Object getBannerLink() {
		return bannerLink;
	}

	public Space setBannerLink(Object bannerLink) {
		this.bannerLink = bannerLink;
		return this;
	}

	public Object getCommercialFrom() {
		return commercialFrom;
	}

	public Space setCommercialFrom(Object commercialFrom) {
		this.commercialFrom = commercialFrom;
		return this;
	}

	public Object getRestrictedDate() {
		return restrictedDate;
	}

	public Space setRestrictedDate(Object restrictedDate) {
		this.restrictedDate = restrictedDate;
		return this;
	}

	public Integer getWatcherPermissions() {
		return watcherPermissions;
	}

	public Space setWatcherPermissions(Integer watcherPermissions) {
		this.watcherPermissions = watcherPermissions;
		return this;
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