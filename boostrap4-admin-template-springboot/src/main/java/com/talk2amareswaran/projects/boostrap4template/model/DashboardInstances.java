package com.talk2amareswaran.projects.boostrap4template.model;

import java.util.List;

public class DashboardInstances {

	private String total;
	private String month;
	private String count;
	private List<String> engines;
	private List<Integer> enginesCount;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getEngines() {
		return engines;
	}

	public void setEngines(List<String> engines) {
		this.engines = engines;
	}

	public List<Integer> getEnginesCount() {
		return enginesCount;
	}

	public void setEnginesCount(List<Integer> enginesCount) {
		this.enginesCount = enginesCount;
	}

}
