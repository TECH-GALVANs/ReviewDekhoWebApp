package com.reviewdekho.report.dao;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.report.model.ReportDescription;

public class ReportDao implements ReportDaoI {

	public int add(Report report) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/report" );		
		
		JSONObject reportJson = new JSONObject( report );
		
		String data = reportJson.toString();
		System.out.println(data);

		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "POST" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( data.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		if( responseCode == 200 )
			return 1;
		else
			return 0;
	}

	public List<Report> get() {
		String url = "http://localhost:8080/api/report";
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		Gson gson = new Gson();
		Type reportListType = new TypeToken< List< Report > >() {}.getType();
		List<Report> reports = gson.fromJson( resp.body().toString(), reportListType );
		System.out.println(reports.get(0).getReport_id());
		
		return reports;
	}

	public Report get(Integer report_id) {
		String url = "http://localhost:8080/api/report/"+report_id;
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		Gson gson = new Gson();
		Report report = gson.fromJson( resp.body().toString(), Report.class );
		System.out.println(report.getReport_id());
		
		return report;
	}

	public int update(Integer report_id, Report report) throws MalformedURLException, IOException {
		return 0;
	}

	public int delete(Integer report_id) throws MalformedURLException, IOException {
		return 0;
	}

	public int addDescription(ReportDescription reportDescription) throws MalformedURLException, IOException {
		URL url = new URL( "http://localhost:8080/api/report_description" );		
		
		JSONObject rDescriptionJson = new JSONObject( reportDescription );
		
		String data = rDescriptionJson.toString();
		System.out.println(data);

		HttpURLConnection postReq = (HttpURLConnection) url.openConnection();
		postReq.setRequestMethod( "POST" );
		postReq.setRequestProperty( "Content-Type", "application/json" );
		
		postReq.setDoOutput( true );
		OutputStream os = postReq.getOutputStream();
		os.write( data.getBytes() );
		os.flush();
		os.close();
		
		int responseCode = postReq.getResponseCode();
		System.out.println(responseCode);
		
		if( responseCode == 200 )
			return 1;
		else
			return 0;
	}

	public List<ReportDescription> getDescription() {
		String url = "http://localhost:8080/api/report_description";
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		Gson gson = new Gson();
		Type descriptionListType = new TypeToken< List< ReportDescription > >() {}.getType();
		List<ReportDescription> descriptions = gson.fromJson( resp.body().toString(), descriptionListType );
		System.out.println(descriptions.get(0).getReport_desc());
		
		return descriptions;
	}

	public ReportDescription getDescription(Integer desc_id) {
		String url = "http://localhost:8080/api/report_description/"+desc_id;
		
		HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse resp = null;
		try {
			resp = client.send( req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		Gson gson = new Gson();
		ReportDescription reportDesc = gson.fromJson( resp.body().toString(), ReportDescription.class );
		System.out.println(reportDesc.getReport_desc());
		
		return reportDesc;
	}

	public int updateDescription(Integer desc_id, ReportDescription reportDescription)
			throws MalformedURLException, IOException {
		return 0;
	}

	public int deleteDescription(Integer desc_id) throws MalformedURLException, IOException {
		return 0;
	}

}
