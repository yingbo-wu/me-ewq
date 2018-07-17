package cn.rongcapital.mc2.me.ewq.api;

import java.util.List;

import org.apache.ignite.services.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.ewq.api.dto.CampaignQueuePullIn;
import cn.rongcapital.mc2.me.ewq.api.dto.CampaignQueuePushIn;

public interface CampaignQueueApi extends Service {

	ApiResult<Void> push(CampaignQueuePushIn in);

	ApiResult<List<String>> pull(CampaignQueuePullIn in);

}
