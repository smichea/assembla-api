package com.assembla;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("user_role")
public class UserRole {

	public Object invitedById;
	public String agreedTime;
	public Integer status;
	public String spaceId;
	public String userId;
	public String invitedTime;
	public Integer id;
	public String title;
	public String role;
	public Object getInvitedById() {
		return invitedById;
	}
	public void setInvitedById(Object invitedById) {
		this.invitedById = invitedById;
	}
	public String getAgreedTime() {
		return agreedTime;
	}
	public void setAgreedTime(String agreedTime) {
		this.agreedTime = agreedTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInvitedTime() {
		return invitedTime;
	}
	public void setInvitedTime(String invitedTime) {
		this.invitedTime = invitedTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRole [status=");
		builder.append(status);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreedTime == null) ? 0 : agreedTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invitedById == null) ? 0 : invitedById.hashCode());
		result = prime * result + ((invitedTime == null) ? 0 : invitedTime.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		UserRole other = (UserRole) obj;
		if (agreedTime == null) {
			if (other.agreedTime != null) {
				return false;
			}
		} else if (!agreedTime.equals(other.agreedTime)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (invitedById == null) {
			if (other.invitedById != null) {
				return false;
			}
		} else if (!invitedById.equals(other.invitedById)) {
			return false;
		}
		if (invitedTime == null) {
			if (other.invitedTime != null) {
				return false;
			}
		} else if (!invitedTime.equals(other.invitedTime)) {
			return false;
		}
		if (role == null) {
			if (other.role != null) {
				return false;
			}
		} else if (!role.equals(other.role)) {
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

	
	
}