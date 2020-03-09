package org.atypical.batch.core.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ComputePiJobConfiguration {
	public static final String JOB_NAME = "computePi";
	public static final String PARAM_COUNT = "count";

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Bean
	Job computePiJob(Step computePiStep) {
		Job job = jobBuilderFactory.get(JOB_NAME).incrementer(new RunIdIncrementer()).flow(computePiStep).end().build();
		return job;
	}

	@Bean
	Step computePiStep(Tasklet computePiTasklet) {
		return stepBuilderFactory.get("computePiStep").allowStartIfComplete(true).tasklet(computePiTasklet).build();
	}

	@Bean
	@StepScope
	Tasklet computePiTasklet(@Value("#{jobParameters['count']}") Long count) {
		return new ComputePiTasklet(count);
	}

	private class ComputePiTasklet implements Tasklet {
		long count;

		public ComputePiTasklet(long count) {
			this.count = count;
		}

		@Override
		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			double pi = computePi(count);
			log.info("Pi = {} with {} count", pi, count);
			return RepeatStatus.FINISHED;
		}

		private double computePi(long count) {
			double pi = 1;

			for (int i = 3; i < count; i += 4) {
				pi = pi - (1 / (double) i) + (1 / (double) (i + 2));
			}
			return pi * 4;
		}
	}

}
