package com.assembla;

public class Document {

	private String name;
	private String filename;
	private String contentType;
	private String createdBy;
	private String id;
	private Integer version;
	private Integer filesize;
	private String updatedBy;
	private String description;
	private String cachedTagList;
	private Integer position;
	private String url;
	private String createdAt;
	private String updatedAt;
	private Integer ticketId;
	private String attachableType;
	private Boolean hasThumbnail;
	private String spaceId;
	private Integer attachableId;

	public String getName() {
		return name;
	}

	public Document setName(String name) {
		this.name = name;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public Document setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	public String getContentType() {
		return contentType;
	}

	public Document setContentType(String contentType) {
		this.contentType = contentType;
		return this;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Document setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public String getId() {
		return id;
	}

	public Document setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getVersion() {
		return version;
	}

	public Document setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public Integer getFilesize() {
		return filesize;
	}

	public Document setFilesize(Integer filesize) {
		this.filesize = filesize;
		return this;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Document setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Document setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getCachedTagList() {
		return cachedTagList;
	}

	public Document setCachedTagList(String cachedTagList) {
		this.cachedTagList = cachedTagList;
		return this;
	}

	public Integer getPosition() {
		return position;
	}

	public Document setPosition(Integer position) {
		this.position = position;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Document setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Document setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Document setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public Document setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
		return this;
	}

	public String getAttachableType() {
		return attachableType;
	}

	public Document setAttachableType(String attachableType) {
		this.attachableType = attachableType;
		return this;
	}

	public Boolean getHasThumbnail() {
		return hasThumbnail;
	}

	public Document setHasThumbnail(Boolean hasThumbnail) {
		this.hasThumbnail = hasThumbnail;
		return this;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public Document setSpaceId(String spaceId) {
		this.spaceId = spaceId;
		return this;
	}

	public Integer getAttachableId() {
		return attachableId;
	}

	public Document setAttachableId(Integer attachableId) {
		this.attachableId = attachableId;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((spaceId == null) ? 0 : spaceId.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
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
		Document other = (Document) obj;
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
		if (updatedBy == null) {
			if (other.updatedBy != null) {
				return false;
			}
		} else if (!updatedBy.equals(other.updatedBy)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [name=");
		builder.append(name);
		builder.append(", filename=");
		builder.append(filename);
		builder.append(", id=");
		builder.append(id);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}

}