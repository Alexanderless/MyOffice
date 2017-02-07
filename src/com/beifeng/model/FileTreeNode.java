package com.beifeng.model;


public class FileTreeNode {
	 private Integer id;//节点id
	 private Integer pId;//父节点pId I必须大写
	 private String name;//节点名称
	 private Boolean open ;//是否展开树节点，默认不展开
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
