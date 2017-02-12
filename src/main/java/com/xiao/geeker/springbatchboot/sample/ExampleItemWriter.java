package com.xiao.geeker.springbatchboot.sample;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class ExampleItemWriter implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(ExampleItemWriter.class);
	private boolean fail = false;
	
	public void setFail(boolean fail) {
		this.fail = fail;
	}

	/**
	 * @see ItemWriter#write(List)
	 */
	public void write(List<? extends Object> data) throws Exception {
		log.info(data);
		if (fail ) {
			throw new RuntimeException("Planned failure");
		}
	}

}
