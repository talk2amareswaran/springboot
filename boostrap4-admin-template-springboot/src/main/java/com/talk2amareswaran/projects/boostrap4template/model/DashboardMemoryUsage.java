package com.talk2amareswaran.projects.boostrap4template.model;

import java.util.List;

public class DashboardMemoryUsage {

	private String total;
	private String month;
	private String count;
	private List<String> cpuList;
	private List<Integer> cpuPercentage;

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

	public List<String> getCpuList() {
		return cpuList;
	}

	public void setCpuList(List<String> cpuList) {
		this.cpuList = cpuList;
	}

	public List<Integer> getCpuPercentage() {
		return cpuPercentage;
	}

	public void setCpuPercentage(List<Integer> cpuPercentage) {
		this.cpuPercentage = cpuPercentage;
	}
}
