package cn.rongcapital.mc2.me.ewq.api.dto;

public class CampaignQueuePullIn {

	private String flowId;

	private String nodeId;

	public CampaignQueuePullIn() {}

	public CampaignQueuePullIn(String flowId, String nodeId) {
		this.flowId = flowId;
		this.nodeId = nodeId;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

}
