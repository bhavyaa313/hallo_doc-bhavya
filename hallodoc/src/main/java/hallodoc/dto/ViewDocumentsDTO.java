package hallodoc.dto;

import javax.management.loading.PrivateClassLoader;

public class ViewDocumentsDTO {
	private int id;
	private String fileName;
	private String filePath;
	private String createDate;
	private String uploader;
	private int fileId;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public ViewDocumentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewDocumentsDTO(int id, String fileName, String filePath, String createDate, String uploader, int fileId) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.createDate = createDate;
		this.uploader = uploader;
		this.fileId = fileId;
	}

	
	
	
}
