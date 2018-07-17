package cn.rongcapital.mc2.me.ewq.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewq.domain.model.CampaignMessage;
import cn.rongcapital.mc2.me.ewq.domain.repository.CampaignMessageRepository;

@Service
public class CampaignQueuePushService {

	@Autowired
	private CampaignMessageRepository campaignQueueRepository;

	public void push(String flowId, String nodeId, long expire, String message) {
		CampaignMessage campaignMessage = new CampaignMessage(nodeId, expire, message);
		campaignQueueRepository.push(flowId, campaignMessage);
	}

}
