package com.beifeng.model;

public class FileTypeInfo {
	private Integer fileTypeId;
	private String fileTypeName;
	private String fileTypeImage;
	private String fileTypeSuffix;
	public Integer getFileTypeId() {
		return fileTypeId;
	}
	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}
	public String getFileTypeName() {
		return fileTypeName;
	}
	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	public String getFileTypeImage() {
		return fileTypeImage;
	}
	public void setFileTypeImage(String fileTypeImage) {
		this.fileTypeImage = fileTypeImage;
	}
	public String getFileTypeSuffix() {
		return fileTypeSuffix;
	}
	public void setFileTypeSuffix(String fileTypeSuffix) {
		this.fileTypeSuffix = fileTypeSuffix;
	}
	@Override
	public String toString() {
		return "FileTypeInfo [fileTypeId=" + fileTypeId + ", fileTypeName="
				+ fileTypeName + ", fileTypeImage=" + fileTypeImage
				+ ", fileTypeSuffix=" + fileTypeSuffix + "]";
	}
	
}
