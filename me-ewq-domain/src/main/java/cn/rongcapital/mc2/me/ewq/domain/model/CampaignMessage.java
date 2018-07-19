package cn.rongcapital.mc2.me.ewq.domain.model;

import org.springframework.data.mongodb.core.mapping.Field;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteEntity;
import cn.rongcapital.mc2.me.ewq.domain.FieldName;

@SuppressWarnings("serial")
public class CampaignMessage extends IgniteEntity {

	@Field(FieldName.FIELD_NODE_ID)
	private String nodeId;

	@Field(FieldName.FIELD_EXPIRE)
	private Long expire;

	@Field(FieldName.FIELD_MESSAGE)
	private String message;

	public CampaignMessage() {}

	public CampaignMessage(String nodeId, long expire, String message) {
		this.nodeId = nodeId;
		this.expire = expire;
		this.message = message;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
