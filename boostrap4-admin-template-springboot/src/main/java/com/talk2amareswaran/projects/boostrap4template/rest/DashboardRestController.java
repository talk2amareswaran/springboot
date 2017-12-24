package com.talk2amareswaran.projects.boostrap4template.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.projects.boostrap4template.model.DashboardActiveInstances;
import com.talk2amareswaran.projects.boostrap4template.model.DashboardCount;
import com.talk2amareswaran.projects.boostrap4template.model.DashboardEarnings;
import com.talk2amareswaran.projects.boostrap4template.model.DashboardInstances;
import com.talk2amareswaran.projects.boostrap4template.model.DashboardMemoryUsage;
import com.talk2amareswaran.projects.boostrap4template.model.Product;

@RestController
public class DashboardRestController {

	@RequestMapping(value = "/dashboardcount", method = RequestMethod.GET)
	public DashboardCount dashboardCount() {
		DashboardCount dashboardCount = new DashboardCount();
		dashboardCount.setActiveInstances("90");
		dashboardCount.setCustomers("145");
		dashboardCount.setProjects("81");
		dashboardCount.setVirtualMachines("121");
		return dashboardCount;
	}

	@RequestMapping(value = "/dashboardearnings", method = RequestMethod.GET)
	public DashboardEarnings dashboardEarnings() {
		DashboardEarnings dashboardEarnings = new DashboardEarnings();
		dashboardEarnings.setInstanceCount("10");
		dashboardEarnings.setMonth("Dec 2017");
		dashboardEarnings.setTotal("$735");
		List<String> instancesList = new ArrayList<>();
		instancesList.add("cloud-asia-instance-active");
		instancesList.add("pacific-flex-cloud");
		instancesList.add("randy-iron-man-cloud");
		instancesList.add("fierce-river-71956");
		instancesList.add("container-fluid-45566");
		instancesList.add("engine-heroku-8906");
		instancesList.add("mike-543-cloud-repo");
		instancesList.add("james-fire-flex-1232");
		instancesList.add("cloud-pacific-repo");
		instancesList.add("sandy-us-ea-asia-cloud");
		dashboardEarnings.setInstances(instancesList);
		List<Integer> instancesAmount = new ArrayList<>();
		instancesAmount.add(89);
		instancesAmount.add(67);
		instancesAmount.add(100);
		instancesAmount.add(45);
		instancesAmount.add(35);
		instancesAmount.add(90);
		instancesAmount.add(55);
		instancesAmount.add(71);
		instancesAmount.add(95);
		instancesAmount.add(88);
		dashboardEarnings.setInstancesAmount(instancesAmount);
		return dashboardEarnings;
	}

	@RequestMapping(value = "/dashboardinstances", method = RequestMethod.GET)
	public DashboardInstances dashboardinstances() {
		DashboardInstances dashboardInstances = new DashboardInstances();
		dashboardInstances.setCount("+23");
		dashboardInstances.setMonth("Dec 2017");
		dashboardInstances.setTotal("67");
		List<String> engineslist = new ArrayList<>();
		engineslist.add("App Engine");
		engineslist.add("Container Engine");
		engineslist.add("Compute Engine");
		engineslist.add("Default Engine");
		dashboardInstances.setEngines(engineslist);

		List<Integer> enginesCount = new ArrayList<>();
		enginesCount.add(20);
		enginesCount.add(10);
		enginesCount.add(30);
		enginesCount.add(7);
		dashboardInstances.setEnginesCount(enginesCount);
		return dashboardInstances;
	}

	@RequestMapping(value = "/dashboardmemoryusage", method = RequestMethod.GET)
	public DashboardMemoryUsage dashboardMemoryUsage() {
		DashboardMemoryUsage dashboardMemoryUsage = new DashboardMemoryUsage();
		dashboardMemoryUsage.setCount("+21%");
		dashboardMemoryUsage.setMonth("Dec 2017");
		dashboardMemoryUsage.setTotal("80%");

		List<String> cpulist = new ArrayList<>();
		cpulist.add("Asia Pacific CPU-9876");
		cpulist.add("US Region - Street CPU-0910");
		cpulist.add("Randy-Region-CPU78344");
		cpulist.add("My System - Region - ASIA-09123");
		cpulist.add("UK-REGION- CPU-9102");
		cpulist.add("West - indies - Region-9089");
		cpulist.add("Mike-CPU-processor-4012");
		cpulist.add("Lwarance-Delaware-Region- 45654");
		cpulist.add("Cloud-CPU-102");
		cpulist.add("Sand-Region-Arab-CPU-90120");
		dashboardMemoryUsage.setCpuList(cpulist);

		List<Integer> cpuPercentage = new ArrayList<>();
		cpuPercentage.add(88);
		cpuPercentage.add(95);
		cpuPercentage.add(55);
		cpuPercentage.add(90);
		cpuPercentage.add(35);
		cpuPercentage.add(45);
		cpuPercentage.add(100);
		cpuPercentage.add(67);
		cpuPercentage.add(89);
		cpuPercentage.add(71);

		dashboardMemoryUsage.setCpuPercentage(cpuPercentage);

		return dashboardMemoryUsage;
	}

	@RequestMapping(value = "/activeinstances", method = RequestMethod.GET)
	public List<DashboardActiveInstances> activeinstances() {
		List<DashboardActiveInstances> activeInstancesList = new ArrayList<>();

		DashboardActiveInstances dashboardActiveInstances1 = new DashboardActiveInstances();
		dashboardActiveInstances1.setId("1");
		dashboardActiveInstances1.setInstanceName("cloud-asia-instance-active");
		dashboardActiveInstances1.setRegion("North-east-pacific");
		dashboardActiveInstances1.setCpuUsage("80%");
		activeInstancesList.add(dashboardActiveInstances1);

		DashboardActiveInstances dashboardActiveInstances2 = new DashboardActiveInstances();
		dashboardActiveInstances2.setId("2");
		dashboardActiveInstances2.setInstanceName("pacific-flex-cloud");
		dashboardActiveInstances2.setRegion("Asia-Pacific");
		dashboardActiveInstances2.setCpuUsage("68%");
		activeInstancesList.add(dashboardActiveInstances2);

		DashboardActiveInstances dashboardActiveInstance3 = new DashboardActiveInstances();
		dashboardActiveInstance3.setId("3");
		dashboardActiveInstance3.setInstanceName("randy-iron-man-cloud");
		dashboardActiveInstance3.setRegion("US-south-A");
		dashboardActiveInstance3.setCpuUsage("51%");
		activeInstancesList.add(dashboardActiveInstance3);

		return activeInstancesList;
	}

	private List<Product> productList = new ArrayList<>();

	@RequestMapping(value = "/products/register", method = RequestMethod.POST)
	public String registerProduct(@RequestBody Product product) {
		productList.add(product);
		return "Product is registered successfully";
	}
}
