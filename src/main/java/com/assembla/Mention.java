package com.assembla;

public class Mention {

	private Integer id;
	private String authorId;
	private String link;
	private String message;
	private Boolean read;
	private String createdAt;

	public Integer getId() {
		return id;
	}

	public Mention setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getAuthorId() {
		return authorId;
	}

	public Mention setAuthorId(String authorId) {
		this.authorId = authorId;
		return this;
	}

	public String getLink() {
		return link;
	}

	public Mention setLink(String link) {
		this.link = link;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Mention setMessage(String message) {
		this.message = message;
		return this;
	}

	public Boolean getRead() {
		return read;
	}

	public Mention setRead(Boolean read) {
		this.read = read;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Mention setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mention [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", read=");
		builder.append(read);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		Mention other = (Mention) obj;
		if (authorId == null) {
			if (other.authorId != null) {
				return false;
			}
		} else if (!authorId.equals(other.authorId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		return true;
	}

}