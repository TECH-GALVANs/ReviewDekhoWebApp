package com.reviewdekho.report.model;

import java.sql.Timestamp;

public class ReportDescription {
	private Integer report_desc_id;
	private String report_desc;
	private Report report;
	private Timestamp desc_created_at;
	private Timestamp desc_updated_at;
	
	public ReportDescription() {
		
	}
	
	public Integer getReport_desc_id() {
		return report_desc_id;
	}
	public void setReport_desc_id(Integer report_desc_id) {
		this.report_desc_id = report_desc_id;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public Timestamp getDesc_created_at() {
		return desc_created_at;
	}
	public void setDesc_created_at(Timestamp desc_created_at) {
		this.desc_created_at = desc_created_at;
	}
	public Timestamp getDesc_updated_at() {
		return desc_updated_at;
	}
	public void setDesc_updated_at(Timestamp desc_updated_at) {
		this.desc_updated_at = desc_updated_at;
	}
	
}
