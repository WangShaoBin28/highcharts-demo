<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8"><link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="./highcharts/highcharts.js"></script>
        <script src="./highcharts/modules/exporting.js"></script>
		<script src="./jquery/1.11.3/jquery.min.js"></script>
        <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>

    </head>
    <body>
        <div id="container" style="min-width:400px;height:400px"></div>
        <script>
            // JS 代码 
				Highcharts.chart('container', {
		chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie' ,
			events: {
                load: function () {
                    var chart = this;
                    loadJsonInfo(chart);
                    //定时器 10秒刷新一次
                    setInterval(function () {
                        loadJsonInfo(chart);
                    }, 10000);
                }
            }
		},
		title: {
				text: '2018年1月浏览器市场份额'
		},
		tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		},credits: {//去掉右下角标识
                    text: ''
                },
		plotOptions: {
				pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						dataLabels: {
								enabled: true,
								format: '<b>{point.name}</b>: {point.percentage:.1f} %',
								style: {
										color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
								}
						}
				}
		},
		series: [{
				name: 'Brands',
				colorByPoint: true

		}]
});
            function loadJsonInfo(chart) {
                var series = chart.series;
                while (series.length > 0) {//移除原始数据
                    series[0].remove(false);
                }
                $.ajax({
                    url: 'showJson',
                    success: function (data) {
                        chart.addSeries({
                            data:data
                        });
                    }
                });
            }
	</script>
    </body>
</html>