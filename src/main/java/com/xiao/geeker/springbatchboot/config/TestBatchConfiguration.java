package com.xiao.geeker.springbatchboot.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(modular = true)
public class TestBatchConfiguration {

	@Autowired

	private JobBuilderFactory jobBuilderFactory;



	@Autowired

	private StepBuilderFactory stepBuilderFactory;



	@Bean
	public Job job() {

		return jobBuilderFactory.get("job").start(step()).build();

	}



	@Bean

	public Step step() {

		return stepBuilderFactory.get("step").chunk(1).reader(reader()).writer(writer()).build();

	}



	@Bean

	public ItemReader<String> reader() {

		return new ListItemReader<String>(Arrays.asList("1", "2", "3"));

	}



	@Bean
	public ItemWriter<? super Object> writer() {

		return new ItemWriter<Object>() {

			public void write(List<? extends Object> items) throws Exception {

				System.out.println(items);

			}

		};

	}
}
