package com.assembla.service;

import java.util.Optional;

import com.assembla.client.AssemblaConstants;
import com.assembla.client.Paging;
import com.assembla.client.Sort;
import com.assembla.client.Sort.Direction;
import com.assembla.enums.TicketReport;

public class TicketRequest {

	private TicketReport report;
	private Paging paging;
	private Sort sort;

	public TicketRequest(Builder builder) {
		this.paging = new Paging(builder.pageSize, builder.pageNumber);
		this.sort = new Sort(builder.sortByField, builder.sortDirection);
		this.report = builder.report;
	}

	public int getPageSize() {
		return paging.size();
	}

	public int getPageNumber() {
		return paging.page();
	}

	public Optional<String> getSortBy() {
		return Optional.ofNullable(sort.getField());
	}

	public Optional<Direction> getDirection() {
		return Optional.ofNullable(sort.getDirection());
	}

	public Optional<TicketReport> getReport() {
		return Optional.ofNullable(report);
	}

	public static class Builder {

		private int pageSize = AssemblaConstants.DEFAULT_PAGE_SIZE;
		private int pageNumber = 1;
		private String sortByField;
		private Direction sortDirection;
		private TicketReport report;

		public Builder pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public Builder page(int pageNumber) {
			this.pageNumber = pageNumber;
			return this;
		}

		public Builder sortBy(String sortByField) {
			this.sortByField = sortByField;
			return this;
		}

		public Builder desc() {
			this.sortDirection = Sort.Direction.DESC;
			return this;
		}

		public Builder asc() {
			this.sortDirection = Sort.Direction.ASC;
			return this;
		}

		public Builder report(TicketReport report) {
			this.report = report;
			return this;
		}

		public TicketRequest build() {
			return new TicketRequest(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("TicketRequest [");
		if (report != null) {
			builder2.append("report=");
			builder2.append(report);
			builder2.append(", ");
		}
		if (paging != null) {
			builder2.append("paging=");
			builder2.append(paging);
			builder2.append(", ");
		}
		if (sort != null) {
			builder2.append("sort=");
			builder2.append(sort);
		}
		builder2.append("]");
		return builder2.toString();
	}

}
