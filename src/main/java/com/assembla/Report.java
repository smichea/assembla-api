package com.assembla;

public class Report {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public Report setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Report setName(String name) {
		this.name = name;
		return this;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Report [id=");
		builder.append(getId());
		builder.append(", name=");
		builder.append(getName());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Report other = (Report) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}