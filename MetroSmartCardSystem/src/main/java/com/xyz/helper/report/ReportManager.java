package com.xyz.helper.report;

import java.io.PrintStream;

/**
 * Created by raj on 17/4/16.
 */
public class ReportManager {

	public PrintStream getWriter() {
		return System.out;
	}

	public String generateReport(Reportable item) {
		return item.generateReport(getWriter());
	}
}
