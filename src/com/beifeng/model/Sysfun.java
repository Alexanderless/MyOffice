package com.beifeng.model;

public class Sysfun {
	private Integer nodeId;
	private String displayName;
	private String nodeURL;
	private Integer displayOrder;
	private Integer parentNodeId;

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getNodeURL() {
		return nodeURL;
	}

	public void setNodeURL(String nodeURL) {
		this.nodeURL = nodeURL;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Integer getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	@Override
	public String toString() {
		return "Sysfun [nodeId=" + nodeId + ", displayName=" + displayName
				+ ", nodeURL=" + nodeURL + ", displayOrder=" + displayOrder
				+ ", parentNodeId=" + parentNodeId + "]";
	}

}
