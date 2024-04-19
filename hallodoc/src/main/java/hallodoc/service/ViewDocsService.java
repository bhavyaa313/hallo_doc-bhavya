package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.ViewDocumentsDTO;
import hallodoc.model.Request;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;

@Service 
public class ViewDocsService {

	@Autowired
	private RequestWiseFileDao requestWiseFileDao;
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private UserDao userDao;
	
public List<ViewDocumentsDTO> getRequestWiseFiles(int id,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Request request2 = requestDao.getRequests(id).get(0);
		List<RequestWiseFile> requestWiseFileList = requestWiseFileDao.getRequestsWiseFileList(request2);
		List<ViewDocumentsDTO> viewDocumentsDTO=new ArrayList<ViewDocumentsDTO>();
		
		for(int i=0;i<requestWiseFileList.size();i++) {
			DateTimeFormatter format=DateTimeFormatter.ofPattern("MMM dd,yyyy");
			LocalDate localDate=requestWiseFileList.get(i).getCreatedDate().toLocalDate();
			String dateText=localDate.format(format);
			String fileContent=String.format("/%s/%s/","resources","docs");
			String path=request.getContextPath()+fileContent+requestWiseFileList.get(i).getFileName();
			ViewDocumentsDTO viewDocuments=new ViewDocumentsDTO();
			viewDocuments.setFileName(requestWiseFileList.get(i).getFileName());
			viewDocuments.setUploader(requestWiseFileList.get(i).getUploader());
			
			viewDocuments.setCreateDate(dateText);
			viewDocuments.setFilePath(path);
			
			viewDocumentsDTO.add(viewDocuments);
		}
//String pathString=session.getServletContext()		
		//
		return viewDocumentsDTO;
	}

@Transactional
public void reqWiseFileforsave(String reqId, CommonsMultipartFile uploadedFile) {
	
	int reqid = Integer.parseInt(reqId);
	
	List<Request> reqList = requestDao.getRequests(reqid);
	Request request1 = reqList.get(0);

	System.out.println("In else part........................");
	
	RequestWiseFile requestWiseFile = new RequestWiseFile();
	requestWiseFile.setRequestId(request1);
	requestWiseFile.setFileName(uploadedFile.getOriginalFilename());
	requestWiseFile.setCreatedDate(LocalDateTime.now());
	requestWiseFile.setUploader(request1.getFirstName()+" "+request1.getLastName());
	
	requestWiseFileDao.requestWiseFileSave(requestWiseFile);
	
}

@Transactional
public void reqWiseFileforsaveadmin(String reqId, CommonsMultipartFile uploadedFile, int userID) {
	
	int reqid = Integer.parseInt(reqId);
	List<User> users = userDao.getUserIDList(userID);
	User user = users.get(0);
	List<Request> reqList = requestDao.getRequests(reqid);
	Request request1 = reqList.get(0);

	System.out.println("In else part........................");
	
	RequestWiseFile requestWiseFile = new RequestWiseFile();
	requestWiseFile.setRequestId(request1);
	requestWiseFile.setFileName(uploadedFile.getOriginalFilename());
	requestWiseFile.setCreatedDate(LocalDateTime.now());
	requestWiseFile.setUploader(user.getFirstName() + " " + user.getLastName());
	requestWiseFile.setAdminId(1);
	requestWiseFile.setPhysicianId(request1.getPhysicianId());
	
	requestWiseFileDao.requestWiseFileSave(requestWiseFile);
	
}


public void delete(int reqId)

{
	List<Request> reqList = requestDao.getRequests(reqId);
}
	
}
