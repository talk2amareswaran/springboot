$(document)
		.ready(
				function() {
					$.ajax({
						url : "/dashboardcount",
						success : function(result) {
							$("#customerCount").html(result.customers);
							$("#projectsCount").html(result.projects);
							$("#vmCount").html(result.virtualMachines);
							$("#instancescount").html(result.activeInstances);
						}
					});

					$
							.ajax({
								url : "/dashboardearnings",
								success : function(result) {
									$("#earningsHTML")
											.html(
													'<strong class="d-block dashtext-3">'
															+ result.total
															+ '</strong><span class="d-block">'
															+ result.month
															+ '</span><small class="d-block"><div>'
															+ result.instanceCount
															+ ' Instances</div></small>');
									var BARCHART1 = $('#salesBarChart1');
									var barChartHome = new Chart(BARCHART1, {
										type : 'bar',
										options : {
											scales : {
												xAxes : [ {
													display : false,
													barPercentage : 0.2
												} ],
												yAxes : [ {
													display : false
												} ],
											},
											legend : {
												display : false
											}
										},
										data : {
											labels : result.instances,
											datasets : [ {
												label : "Earnings in $",
												backgroundColor : [ '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99' ],
												borderColor : [ '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99',
														'#EF8C99', '#EF8C99' ],
												borderWidth : 0.2,
												data : result.instancesAmount
											} ]
										}
									});

								}
							});

					$
							.ajax({
								url : "/dashboardinstances",
								success : function(result) {
									$("#instancesHTML")
											.html(
													'<strong class="d-block dashtext-1">'
															+ result.total
															+ '</strong><span class="d-block">'
															+ result.month
															+ '</span><small class="d-block"><div>'
															+ result.count
															+ ' Instances</div></small>');

									var PIECHARTEXMPLE = $('#visitPieChart');
									var pieChartExample = new Chart(
											PIECHARTEXMPLE,
											{
												type : 'pie',
												options : {
													legend : {
														display : false
													}
												},
												data : {
													labels : result.engines,
													datasets : [ {
														data : result.enginesCount,
														borderWidth : 0,
														backgroundColor : [
																'#723ac3',
																"#864DD9",
																"#9762e6",
																"#a678eb" ],
														hoverBackgroundColor : [
																'#723ac3',
																"#864DD9",
																"#9762e6",
																"#a678eb" ]
													} ]
												}
											});

								}
							});

					$
							.ajax({
								url : "/dashboardmemoryusage",
								success : function(result) {
									$("#memoryusageHTML")
											.html(
													'<strong class="d-block dashtext-2">'
															+ result.total
															+ '</strong><span class="d-block">'
															+ result.month
															+ '</span><small class="d-block"><div>'
															+ result.count
															+ ' Instances</div></small>');

									var BARCHART1 = $('#salesBarChart2');
									var barChartHome = new Chart(BARCHART1, {
										type : 'bar',
										options : {
											scales : {
												xAxes : [ {
													display : false,
													barPercentage : 0.2
												} ],
												yAxes : [ {
													display : false
												} ],
											},
											legend : {
												display : false
											}
										},
										data : {
											labels : result.cpuList,
											datasets : [ {
												label : "Memory Usage in %",
												backgroundColor : [ '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9' ],
												borderColor : [ '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9',
														'#CF53F9', '#CF53F9' ],
												borderWidth : 0.2,
												data : result.cpuPercentage
											} ]
										}
									});

								}
							});

					$.ajax({
						url : "/activeinstances",
						success : function(result) {
							for (var i = 0; i < result.length; i++) {

								var htmlcontent = '<tr><th scope="row">'
										+ result[i].id + '</th><td>'
										+ result[i].instanceName + '</td><td>'
										+ result[i].region + '</td><td>'
										+ result[i].cpuUsage + '</td></tr>';

								$('#tableBodyHTML').append(htmlcontent);
							}
						}
					});

					$("#registerBtn")
							.click(
									function() {

										if ($.trim($("#fullname").val()) == "") {
											alert("Please provide your Fullname");
										} else if ($.trim($("#productsku")
												.val()) == "") {
											alert("Please provide a Product SKU");
										} else {

											var datamodel = {
												fullname : $
														.trim($("#fullname")
																.val()),
												productsku : $.trim($(
														"#productsku").val())
											};
											var requestmodel = JSON
													.stringify(datamodel);

											$
													.ajax({
														type : "POST",
														url : "/products/register",
														headers : {
															"Content-Type" : "application/json"
														},
														data : requestmodel,
														success : function(data) {
															alert("Product is registered successfully");
														},
														error : function(data) {
															alert("Product is not registered successfully");
														}
													});

										}
									});

				});