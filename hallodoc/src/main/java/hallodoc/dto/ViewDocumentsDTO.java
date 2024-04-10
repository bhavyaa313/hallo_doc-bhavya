package hallodoc.dto;

public class ViewDocumentsDTO {

	private String fileName;
	private String filePath;
	private String createDate;
	private String uploader;
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
	public ViewDocumentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewDocumentsDTO(String fileName, String filePath, String createDate, String uploader) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.createDate = createDate;
		this.uploader = uploader;
	}
	
	
	
	
}
