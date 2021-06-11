package com.realcoderz.business.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class StoredFile {
	
	private String fileTitle;
	
	CommonsMultipartFile file;
	
	

	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
	

}
