package hallodoc.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;


@Service
public class ExportAllService {
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestClientDao requestClientDao;
	
public ByteArrayInputStream allRequests() {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("New Request Sheet");
		
		List<Request> requests=requestDao.getRequests();
		
		int rowNum=0;
		Row headerRow=sheet.createRow(rowNum++);

		 headerRow.createCell(0).setCellValue("Name");
		    headerRow.createCell(1).setCellValue("Date Of Birth");
		    headerRow.createCell(2).setCellValue("Requestor");
		    headerRow.createCell(3).setCellValue("Requested Date");
		    headerRow.createCell(4).setCellValue("Phone");
		    headerRow.createCell(5).setCellValue("Address");
		    headerRow.createCell(6).setCellValue("Notes");
	   
		
			for(Request request: requests) {
				
				
				List<RequestClient> requestClients = requestClientDao.getRequests(request);
				RequestClient requestClient= requestClients.get(0);
		    	Row row=sheet.createRow(rowNum++);
		    	row.createCell(0).setCellValue(requestClient.getFirstName()+","+requestClient.getLastName());
		    	row.createCell(1).setCellValue(requestClient.getIntDate()+"/"+ requestClient.getStrMonth()+"/"+ requestClient.getIntYear());
		    	row.createCell(2).setCellValue(request.getFirstName()+", "+request.getLastName());
		    	row.createCell(3).setCellValue(request.getCreatedDate().toString());
		    	row.createCell(4).setCellValue(requestClient.getPhoneNumber());
		    	row.createCell(5).setCellValue(requestClient.getStreet()+", "+requestClient.getCity()+", "+requestClient.getState()+", "+requestClient.getZipcode());
		    	row.createCell(6).setCellValue(requestClient.getNotes());
		    	
		    }
		
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		try {
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				outputStream.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ByteArrayInputStream(outputStream.toByteArray());
		
		
	}

}
