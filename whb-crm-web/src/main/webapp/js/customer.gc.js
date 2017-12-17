$(function(){
	loadCustomerGc();
});



/**
 * 显示用户构成柱状图
 */
function loadCustomerGc(){
	$.ajax({
		type:"get",
		url:ctx+"/report/queryCustomersGc",
		dataType:"json",
		success:function(data){
			if(data.code==200){
				var level=data.level;
				var count=data.count;
                myChartGC(level,count);
			}else{
				alert("暂无数据");
			}
		}
	});
}
var myChartGC = function (level,count) {
	var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title : {
            text : '客户构成分析'
        },
        tooltip : {},
        legend : {
            data : [ '数量' ]
        },
        xAxis : {
            data : level
        },
        yAxis : {},
        series : [ {
            name : '数量',
            type : 'bar',
            data : count
        } ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}