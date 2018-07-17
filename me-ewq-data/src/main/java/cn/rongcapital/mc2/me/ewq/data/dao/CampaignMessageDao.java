package cn.rongcapital.mc2.me.ewq.data.dao;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewq.domain.FieldName;
import cn.rongcapital.mc2.me.ewq.domain.model.CampaignMessage;
import cn.rongcapital.mc2.me.ewq.domain.repository.CampaignMessageRepository;

@Service
public class CampaignMessageDao implements CampaignMessageRepository {

	private final Lock lock = new ReentrantLock();

	@Autowired
	private MongoTemplate mongoTemplate;

	public void push(String flowId, CampaignMessage message) {
		String collectionName = String.format("campaign_queue_%s", flowId);
		lock.lock();
		try {
			boolean exists = mongoTemplate.collectionExists(collectionName);
			if (!exists) {
				mongoTemplate.createCollection(collectionName);
			}
		} finally {
			lock.unlock();
		}
		mongoTemplate.save(message, collectionName);
	}

	public List<CampaignMessage> pull(String flowId, String nodeId) {
		String collectionName = String.format("campaign_queue_%s", flowId);
		Query query = new Query(Criteria.where(FieldName.FIELD_NODE_ID).is(nodeId).and(FieldName.FIELD_EXPIRE).lte(System.currentTimeMillis()));
		return mongoTemplate.findAllAndRemove(query, CampaignMessage.class, collectionName);
	}

}
