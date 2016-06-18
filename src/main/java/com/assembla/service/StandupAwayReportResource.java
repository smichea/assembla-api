package com.assembla.service;

import java.time.LocalDate;
import java.util.List;

import com.assembla.StandupReport;

public interface StandupAwayReportResource {

	List<StandupReport> getAll(LocalDate date);

	StandupReport get(LocalDate date);

	StandupReport create(StandupReport report, LocalDate date);

	StandupReport update(StandupReport report, LocalDate date);

}
