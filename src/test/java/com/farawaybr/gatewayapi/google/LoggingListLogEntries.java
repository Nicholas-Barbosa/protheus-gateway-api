package com.farawaybr.gatewayapi.google;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.google.api.gax.paging.Page;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.LoggingOptions;

class LoggingListLogEntries {

	@Test
	void test() {
		String logName = "compute.googleapis.com%2Ffirewall";

		try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

			// When composing a filter, using indexed fields, such as timestamp,
			// resource.type, logName
			// and
			// others can help accelerate the results
			// Full list of indexed fields here:
			// https://cloud.google.com/logging/docs/view/advanced-queries#finding-quickly
			// This sample restrict the results to only last minute to minimize number of
			// API calls

			DateTimeFormatter rfc3339 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			String logFilter = "logName=projects/" + logging.getOptions().getProjectId() + "/logs/" + logName
					+ " AND timestamp>=\"" + rfc3339.format(LocalDateTime.now(ZoneId.of(ZoneOffset.UTC.getId())).minusMinutes(1))
					+ "\"";
			
			// List all log entries
			Page<LogEntry> entries = logging.listLogEntries(EntryListOption.filter(logFilter));
			while (entries != null) {
				for (LogEntry logEntry : entries.iterateAll()) {
					System.out.println(logEntry);
				}
				entries = entries.getNextPage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
