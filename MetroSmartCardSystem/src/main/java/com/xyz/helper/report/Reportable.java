package com.xyz.helper.report;

import java.io.PrintStream;

/**
 * Created by raj on 17/4/16.
 */
public interface Reportable {

	String generateReport(PrintStream writer);
}
