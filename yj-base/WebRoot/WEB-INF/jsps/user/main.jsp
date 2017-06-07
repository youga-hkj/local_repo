<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>login success</title>
	<style>
		#title{
			text-align:right;
			width: auto;
		
		}

        #container{
        	margin:0 auto;
            background: #dddddd;
            width: 500px;
            height: 250px;
        }
        path{

            fill: none;
            stroke: steelblue;
            stroke-width: 2px;
        }
    </style>
    
    
  </head>
  
  <body>
  	<p id = "title"><%=(String)session.getAttribute("user") %> 欢迎使用户外空气质量检测系统 !</p>
    <hr/>
    
    <div id="container"></div>
	<script type="text/javascript" src="js/d3.v3.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
        var width= 500,
                height = 250,
                margin = { left:50, top:30, right:20, bottom:20,};
        g_width = width - margin.left-margin.right,
                g_height = height - margin.top - margin.bottom;
        //SVG
        var svg=d3.select("#container")
                .append("svg")
                //width,height
                .attr("width",width)
                .attr("height",height)

        var g = d3.select("svg")
                .append("g")
                .attr("transform","translate("+ margin.left+","+margin.top+")")
		var data = ${requestScope.user_data}
        var scale_x = d3.scale.linear()
                .domain([0,data.length-1])//输入的范围
                .range([0,g_width])//输出的范围
        var scale_y = d3.scale.linear()
                .domain([0,d3.max(data)])
                .range([g_height,0])


        var line_generator=d3.svg.line()
                .x(function(d,i){return scale_x(i);})//0,1,2,3,
                .y(function(d){return scale_y(d);})//1,3,5

                .interpolate("cardinal")//折线变曲线

        d3.select("g")
                .append("path")
                .attr("d",line_generator(data))//d="M1,0L20,40L40,60L100,100L0,200",d-path data

        var x_axis = d3.svg.axis().scale(scale_x),
                y_axis = d3.svg.axis().scale(scale_y).orient("left");

        g.append("g")
                .call(x_axis)
                .attr("transform","translate(0,"+g_height+")")
                .append("text")
                .text("time")

        g.append("g")
                .call(y_axis)
                .append("text")
                .text("℃")
    </script>
   </body>
</html>
