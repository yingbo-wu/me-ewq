package cn.rongcapital.mc2.me.ewq.app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteServiceDeployment;
import cn.rongcapital.mc2.me.ewq.api.CampaignQueueApi;

@Component
public class Launch implements ApplicationListener<ApplicationReadyEvent> {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		IgniteServiceDeployment.deploy(CampaignQueueApi.class);
	}

}
