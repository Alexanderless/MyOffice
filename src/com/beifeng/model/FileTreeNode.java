package com.beifeng.model;


public class FileTreeNode {
	 private Integer id;//�ڵ�id
	 private Integer pId;//���ڵ�pId I�����д
	 private String name;//�ڵ�����
	 private Boolean open ;//�Ƿ�չ�����ڵ㣬Ĭ�ϲ�չ��
	 private String file;
	

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FileTreeNode [id=" + id + ", pId=" + pId + ", name=" + name
				+ ", open=" + open + ", file=" + file + "]";
	}



}
