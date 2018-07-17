package cn.rongcapital.mc2.me.ewq.domain.repository;

import java.util.List;

import cn.rongcapital.mc2.me.ewq.domain.model.CampaignMessage;

public interface CampaignMessageRepository {

	void push(String flowId, CampaignMessage message);

	List<CampaignMessage> pull(String flowId, String nodeId);

}
