package cn.rongcapital.mc2.me.ewq.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewq.domain.model.CampaignMessage;
import cn.rongcapital.mc2.me.ewq.domain.repository.CampaignMessageRepository;

@Service
public class CampaignQueuePullService {

	@Autowired
	private CampaignMessageRepository campaignQueueRepository;

	public List<CampaignMessage> pull(String flowId, String nodeId) {
		return campaignQueueRepository.pull(flowId, nodeId);
	}

}
