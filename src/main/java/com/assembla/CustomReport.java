package com.assembla;

import java.util.ArrayList;
import java.util.List;

public class CustomReport {

	private List<Report> teamReports = new ArrayList<>();
	private List<Report> userReports = new ArrayList<>();

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

	public List<Report> getTeamReports() {
		return teamReports;
	}

	public void setTeamReports(List<Report> teamReports) {
		this.teamReports = teamReports;
	}

	public List<Report> getUserReports() {
		return userReports;
	}

	public void setUserReports(List<Report> userReports) {
		this.userReports = userReports;
	}

}