package com.reviewdekho.report.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.report.model.Report;
import com.reviewdekho.report.model.ReportDescription;

public interface ReportDaoI {
	//	For getting Reports...
	public int add( Report report ) throws MalformedURLException, IOException;
	public List< Report > get();
	public Report get( Integer report_id );
	public int update( Integer report_id, Report report ) throws MalformedURLException, IOException;
	public int delete( Integer report_id ) throws MalformedURLException, IOException;

	//	For Getting Report-Descriptions..........
	public int addDescription( ReportDescription reportDescription ) throws MalformedURLException, IOException;
	public List< ReportDescription > getDescription();
	public ReportDescription getDescription( Integer desc_id );
	public int updateDescription( Integer desc_id, ReportDescription reportDescription ) throws MalformedURLException, IOException;
	public int deleteDescription( Integer desc_id ) throws MalformedURLException, IOException;
}
