package cn.rongcapital.mc2.me.ewq.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ignite.resources.SpringResource;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteService;
import cn.rongcapital.mc2.me.ewq.api.CampaignQueueApi;
import cn.rongcapital.mc2.me.ewq.api.dto.CampaignQueuePullIn;
import cn.rongcapital.mc2.me.ewq.api.dto.CampaignQueuePushIn;
import cn.rongcapital.mc2.me.ewq.domain.model.CampaignMessage;
import cn.rongcapital.mc2.me.ewq.domain.service.CampaignQueuePullService;
import cn.rongcapital.mc2.me.ewq.domain.service.CampaignQueuePushService;

@Service
public class CampaignQueueService extends IgniteService implements CampaignQueueApi {

	private static final long serialVersionUID = 4043457595345010412L;

	@SpringResource(resourceName = "campaignQueuePushService")
	private transient CampaignQueuePushService campaignQueuePushService;

	@SpringResource(resourceName = "campaignQueuePullService")
	private transient CampaignQueuePullService campaignQueuePullService;

	@Override
	public ApiResult<Void> push(CampaignQueuePushIn in) {
		String flowId = in.getFlowId();
		String nodeId = in.getNodeId();
		long expire = in.getExpire();
		String message = in.getMessage();
		campaignQueuePushService.push(flowId, nodeId, expire, message);
		return ApiResult.success();
	}

	@Override
	public ApiResult<List<String>> pull(CampaignQueuePullIn in) {
		String flowId = in.getFlowId();
		String nodeId = in.getNodeId();
		List<CampaignMessage> messages = campaignQueuePullService.pull(flowId, nodeId);
		List<String> list = messages.stream().map(msg -> msg.getMessage()).collect(Collectors.toList());
		return ApiResult.success(list);
	}

}
