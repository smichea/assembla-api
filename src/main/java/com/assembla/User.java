package com.assembla;

public class User {

	private String phone;
	private String login;
	private String name;
	private String id;
	private String organization;
	private String picture;
	private InstantMessenger im;
	private InstantMessenger im2;

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public String getOrganization() {
		return organization;
	}

	public User setOrganization(String organization) {
		this.organization = organization;
		return this;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public InstantMessenger getIm() {
		return im;
	}

	public void setIm(InstantMessenger im) {
		this.im = im;
	}

	public InstantMessenger getIm2() {
		return im2;
	}

	public void setIm2(InstantMessenger im2) {
		this.im2 = im2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [");
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
			builder.append(", ");
		}
		if (login != null) {
			builder.append("login=");
			builder.append(login);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (organization != null) {
			builder.append("organization=");
			builder.append(organization);
			builder.append(", ");
		}
		if (im != null) {
			builder.append("im=");
			builder.append(im);
			builder.append(", ");
		}
		if (im2 != null) {
			builder.append("im2=");
			builder.append(im2);
		}
		builder.append("]");
		return builder.toString();
	}

}
