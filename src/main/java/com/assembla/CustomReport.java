package com.assembla;

import java.util.ArrayList;
import java.util.List;

public class CustomReport {

	private List<Report> teamReports = new ArrayList<>();
	private List<Report> userReports = new ArrayList<>();

	public List<Report> getTeamReports() {
		return teamReports;
	}

	public CustomReport setTeamReports(List<Report> teamReports) {
		this.teamReports = teamReports;
		return this;
	}

	public List<Report> getUserReports() {
		return userReports;
	}

	public CustomReport setUserReports(List<Report> userReports) {
		this.userReports = userReports;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomReport [teamReports=");
		builder.append(getTeamReports());
		builder.append(", userReports=");
		builder.append(getUserReports());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamReports == null) ? 0 : teamReports.hashCode());
		result = prime * result + ((userReports == null) ? 0 : userReports.hashCode());
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
		CustomReport other = (CustomReport) obj;
		if (teamReports == null) {
			if (other.teamReports != null) {
				return false;
			}
		} else if (!teamReports.equals(other.teamReports)) {
			return false;
		}
		if (userReports == null) {
			if (other.userReports != null) {
				return false;
			}
		} else if (!userReports.equals(other.userReports)) {
			return false;
		}
		return true;
	}
	
}