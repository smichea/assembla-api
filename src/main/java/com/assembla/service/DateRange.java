package com.assembla.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

import com.assembla.client.AssemblaConstants;
import com.assembla.utils.ObjectUtils;

/**
 * simple wrapper around a duration , makes it easier to format and test for now
 * 
 * @author matthewsladen
 *
 */
public class DateRange {

	private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter
			.ofPattern(AssemblaConstants.YYYY_MM_DD_HH_MM);

	private final LocalDateTime start;
	private final LocalDateTime end;
	private final DateTimeFormatter formatter;
	private final Duration duration;

	public DateRange(LocalDateTime start, LocalDateTime end) {
		ObjectUtils.notNull(start, "Must enter start");
		ObjectUtils.notNull(end, "Must enter end");

		if (start.isAfter(end)) {
			throw new IllegalArgumentException("Start must be before end");
		}

		this.start = start;
		this.end = end;
		this.formatter = DEFAULT_FORMATTER;
		this.duration = Duration.between(start, end);
	}

	public LocalDateTime getFrom() {
		return this.start;
	}

	public LocalDateTime getTo() {
		return this.end;
	}

	public String getFromString() {
		return this.formatter.format(start);
	}

	public String getToString() {
		return this.formatter.format(end);
	}

	public DateTimeFormatter getFormatter() {
		return this.formatter;
	}

}
