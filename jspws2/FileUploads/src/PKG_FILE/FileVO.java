package PKG_FILE;

public class FileVO {
	private String idx;
	private String name;
	private String orgFileName;
	private String newFileName;
	private String filesize;
	
	
	public FileVO() {
		super();
	}
	
	public FileVO(String idx, String name, String orgFileName, String newFileName, String filesize) {
		super();
		this.idx = idx;
		this.name = name;
		this.orgFileName = orgFileName;
		this.newFileName = newFileName;
		this.filesize = filesize;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	
	
}
