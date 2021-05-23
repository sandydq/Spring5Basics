package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	@Qualifier("htmlGenerator")
	private ReportGenerator master;

	@Value("0")
	private int recordsPerPage;
	
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	public void setMaster(ReportGenerator master) {
		this.master = master;
	}

	public void generateReport() throws Exception {
		System.out.println("In Report Service generate method");
		if (recordsPerPage <= 0) {
			throw new ArithmeticException("No records to update");
		}

		String ret = master.generateReport(recordsPerPage);
		System.out.println("Value return by report:" + ret);
	}
}
