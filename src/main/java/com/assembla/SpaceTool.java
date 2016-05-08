package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("space_tool")
public class SpaceTool {

	public String type;
	public Integer toolId;
	public Boolean active;
	public String createdAt;
	public Object teamPermissions;
	public Object url;
	public String spaceId;
	public Integer number;
	public Object publicPermissions;
	public Object parentId;
	public String name;
	public String menuName;
	public Object watcherPermissions;
	public Settings settings;
	public String id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getToolId() {
		return toolId;
	}

	public void setToolId(Integer toolId) {
		this.toolId = toolId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Object getTeamPermissions() {
		return teamPermissions;
	}

	public void setTeamPermissions(Object teamPermissions) {
		this.teamPermissions = teamPermissions;
	}

	public Object getUrl() {
		return url;
	}

	public void setUrl(Object url) {
		this.url = url;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Object getPublicPermissions() {
		return publicPermissions;
	}

	public void setPublicPermissions(Object publicPermissions) {
		this.publicPermissions = publicPermissions;
	}

	public Object getParentId() {
		return parentId;
	}

	public void setParentId(Object parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Object getWatcherPermissions() {
		return watcherPermissions;
	}

	public void setWatcherPermissions(Object watcherPermissions) {
		this.watcherPermissions = watcherPermissions;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpaceTool [createdAt=");
		builder.append(createdAt);
		builder.append(", url=");
		builder.append(url);
		builder.append(", name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((publicPermissions == null) ? 0 : publicPermissions.hashCode());
		result = prime * result + ((settings == null) ? 0 : settings.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
		result = prime * result + ((teamPermissions == null) ? 0 : teamPermissions.hashCode());
		result = prime * result + ((toolId == null) ? 0 : toolId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((watcherPermissions == null) ? 0 : watcherPermissions.hashCode());
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
		SpaceTool other = (SpaceTool) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
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
		if (menuName == null) {
			if (other.menuName != null) {
				return false;
			}
		} else if (!menuName.equals(other.menuName)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (parentId == null) {
			if (other.parentId != null) {
				return false;
			}
		} else if (!parentId.equals(other.parentId)) {
			return false;
		}
		if (publicPermissions == null) {
			if (other.publicPermissions != null) {
				return false;
			}
		} else if (!publicPermissions.equals(other.publicPermissions)) {
			return false;
		}
		if (settings == null) {
			if (other.settings != null) {
				return false;
			}
		} else if (!settings.equals(other.settings)) {
			return false;
		}
		if (spaceId == null) {
			if (other.spaceId != null) {
				return false;
			}
		} else if (!spaceId.equals(other.spaceId)) {
			return false;
		}
		if (teamPermissions == null) {
			if (other.teamPermissions != null) {
				return false;
			}
		} else if (!teamPermissions.equals(other.teamPermissions)) {
			return false;
		}
		if (toolId == null) {
			if (other.toolId != null) {
				return false;
			}
		} else if (!toolId.equals(other.toolId)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (watcherPermissions == null) {
			if (other.watcherPermissions != null) {
				return false;
			}
		} else if (!watcherPermissions.equals(other.watcherPermissions)) {
			return false;
		}
		return true;
	}



	public static class Settings {

		public String state;
		public Object vcsUrl;

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Object getVcsUrl() {
			return vcsUrl;
		}

		public void setVcsUrl(Object vcsUrl) {
			this.vcsUrl = vcsUrl;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + ((vcsUrl == null) ? 0 : vcsUrl.hashCode());
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
			Settings other = (Settings) obj;
			if (state == null) {
				if (other.state != null) {
					return false;
				}
			} else if (!state.equals(other.state)) {
				return false;
			}
			if (vcsUrl == null) {
				if (other.vcsUrl != null) {
					return false;
				}
			} else if (!vcsUrl.equals(other.vcsUrl)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Settings [state=");
			builder.append(state);
			builder.append(", vcsUrl=");
			builder.append(vcsUrl);
			builder.append("]");
			return builder.toString();
		}

	}

}