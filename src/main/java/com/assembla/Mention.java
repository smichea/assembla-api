package com.assembla;

public class Mention {

	private Integer id;
	private String authorId;
	private String link;
	private String message;
	private Boolean read;
	private String createdAt;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}