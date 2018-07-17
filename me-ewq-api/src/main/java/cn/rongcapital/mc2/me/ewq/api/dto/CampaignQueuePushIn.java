package cn.rongcapital.mc2.me.ewq.api.dto;

public class CampaignQueuePushIn {

	private String flowId;

	private String nodeId;

	private long expire;

	private String message;

	public CampaignQueuePushIn() {}

	public CampaignQueuePushIn(String flowId, String nodeId, long expire, String message) {
		this.flowId = flowId;
		this.nodeId = nodeId;
		this.expire = expire;
		this.message = message;
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

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
