package com.xiao.geeker.springbatchboot.sample;

import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;

/**
 * Workaround for BATCH-1692, BATCH-1693.
 * 
 * @author Dave Syer
 * 
 */
public class RemoteStep implements Step {

	private Step step;

	private String name;

	private int startLimit = Integer.MAX_VALUE;

	private boolean allowStartIfComplete = false;

	/**
	 * Set the name property.
	 *
	 * @param name {@link org.springframework.batch.core.Step#getName()}
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getStartLimit() {
		return this.startLimit;
	}

	/**
	 * Public setter for the startLimit.
	 * 
	 * @param startLimit the startLimit to set
	 */
	public void setStartLimit(int startLimit) {
		this.startLimit = startLimit;
	}

	public boolean isAllowStartIfComplete() {
		return this.allowStartIfComplete;
	}

	/**
	 * Public setter for flag that determines whether the step should start
	 * again if it is already complete. Defaults to false.
	 * 
	 * @param allowStartIfComplete the value of the flag to set
	 */
	public void setAllowStartIfComplete(boolean allowStartIfComplete) {
		this.allowStartIfComplete = allowStartIfComplete;
	}

	/**
	 * @param delegate the delegate to set
	 */
	public void setStep(Step delegate) {
		this.step = delegate;
	}

	public void execute(StepExecution stepExecution) throws JobInterruptedException {
		step.execute(stepExecution);
	}

}
