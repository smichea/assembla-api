package com.assembla.service;

import java.time.LocalDate;
import java.util.List;

import com.assembla.StandupReport;

public interface StandupReportResource {

	List<StandupReport> getAll(LocalDate from, LocalDate to);

	StandupReport get(LocalDate date);

	StandupReport create(StandupReport report, LocalDate date);

	StandupReport update(StandupReport report, LocalDate date);

}
