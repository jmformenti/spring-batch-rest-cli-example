package org.atypical.batchrest.api.listener;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.chrisgleissner.springbatchrest.util.core.JobBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobRegisterListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private List<Job> jobs;

	@Autowired
	private JobBuilder jobBuilder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		for (Job job : jobs) {
			jobBuilder.registerJob(job);
			log.info("Registered '{}' job", job.getName());
		}
	}

}
