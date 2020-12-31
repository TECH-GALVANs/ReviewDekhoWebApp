package com.reviewdekho.report.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.reviewdekho.report.dao.ReportDao;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.report.model.ReportDescription;

public class ReportService {
	private ReportDao dao;
	
	public ReportService() {
		dao = new ReportDao();
	}
	
//	Report Methods...
	public int addReport( Report report ) throws MalformedURLException, IOException {
		return dao.add(report);
	}
	
	public List< Report > get(){
		return dao.get();
	}
	
	public Report getReport( Integer reportId ) {
		return dao.get(reportId);
	}
	
	public int update( Integer reportId, Report report ) throws MalformedURLException, IOException {
		return dao.update(reportId, report);
	}
	
	public int delete( Integer reportId ) throws MalformedURLException, IOException {
		return dao.delete(reportId);
	}
	
//	Methods for Report-Description
	public int addDeacription( ReportDescription reportDescription ) throws MalformedURLException, IOException {
		return dao.addDescription(reportDescription);
	}
	
	public List< ReportDescription > getDescriptions(){
		return dao.getDescription();
	}
	
	public ReportDescription getDescription( Integer descriptionId ) {
		return dao.getDescription(descriptionId);
	}
	
	public int updateDescription( Integer descriptionId, ReportDescription reportDescription ) throws MalformedURLException, IOException {
		return dao.updateDescription( descriptionId, reportDescription);
	}
	
	public int deleteDescription( Integer descriptionId ) throws MalformedURLException, IOException {
		return dao.deleteDescription(descriptionId);
	}
}
