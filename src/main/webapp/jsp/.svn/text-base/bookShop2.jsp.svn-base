<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
	<title>书城--会员中心_个人中心</title>
	<link href="<%=basePath %>css/bookshop.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath %>css/jquery-ui.css" rel="stylesheet">
    <link href="<%=basePath %>css/page.css" rel="stylesheet">
    
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js" ></script>
  	<script src="<%=basePath %>js/imagesloaded.pkgd.min.js"></script>
	<script src="<%=basePath %>js/wookmark.js"></script>
    <script src="<%=basePath %>js/openwaterfall.js"></script>
	<!--<script src="js/jquery-1.js"></script>-->
    <script src="<%=basePath %>js/jquery-ui.js"></script>
    <script src="<%=basePath %>js/common.js"></script>
        
</head>
<body>

	<!-- 导航开始 -->
	<header id="header">
		<nav class="link">
			<h2 class="none">网站导航</h2>
			<ul class="nav_ul01">
				<li class="active"><a href="index.html">首页</a></li>
				<li><a href="#"> 我要读</a></li>
				<li><a href="#">发表作品 </a></li>
			</ul>
            
            <div class="logo"><img src="<%=basePath %>images/logo.jpg"></div>
            
      		<ul class="nav_ul02">
				<li><a href="login.html">登录注册</a></li>
                <li><a href="#">阅读指南</a></li>
                <li><a href="#">读者圈</a></li>
			</ul>
            
            <ul class="nav_ul03">
				<li class="user"><em></em>广州阿飞</li>
                <li class="search">
                	<form action="searchBook" method="post">
                	<!-- look for the file named common.js to find autocomplete function details -->
                        <input name="" type="text" list="bookkeywords" id="autocomplete" class="bo_search" placeholder="我要查找..">
                        <img id="opensearch" src="<%=basePath %>images/b_search.png">
                    </form>
                </li>
			</ul>
		</nav>
        
	</header>
	<!-- 导航结束 -->
	<div class="clear"></div>
     <!--检索栏-->
    <div class="htmleaf-container">
    	<!--一级列表-->
    	<div class="filter_window filter_wd_header">
            <ol class="no-filters" id="top_fatherlist">
                <li>穿越</li>
                <li>文学</li>
            </ol>
		</div>
        <!--一级列表结束-->
        <!--二级列表-->
        <div class="two_list">
            <div class="filter_ol_son" style="display:none;">
                <h4 class="son_sort">穿越 :</h4>
                <ol class="filters filter_son_ol">
                    <li data-filter="d1">中国当代小说</li>
                    <li data-filter="">推理</li>
                </ol>
            </div>
            
            <div class="filter_ol_son" style="display:none;">
                <h4 class="son_sort">武侠 :</h4>
                <ol class="filter_son_ol">
                    <li>中国当代小说</li>
                    <li>网络小说</li>
                    <li>港澳台小说</li>
                    <li>中国古典小说</li>
                </ol>
            </div>
        </div>  
        <!--二级列表结束-->
        
        
        <div class="filter_window">  
            <ol class="filters" id="select2">
                <li class="fil_title">篇幅：</li>
                <li data-filter="all" class="now_onactive">全部</li>
                <li data-filter="long">长篇小说</li>
				<li data-filter="minlong">中篇小说</li>
                <li data-filter="short">短篇小说</li>
                <li data-filter="others">其他小说</li>
            </ol>
        </div>
        
        <div class="filter_window">     
            <ol class="filters" id="select3">
                <li class="fil_title">地区：</li>
                <li data-filter="all" class="now_onactive">全部</li>
                <li data-filter="beijing">北京</li>
                <li data-filter="tianjin">天津</li>
                <li data-filter="sichuan">四川</li>
            </ol>
        </div>
        
        <div class="filter_window">  
            <ol class="filters" id="select4">
                <li class="fil_title">时间：</li>
                <li data-filter="all" class="now_onactive">全部</li>
                <li data-filter="now">2015</li>
                <li data-filter="now-1">2014</li>
                <li data-filter="now-2">2013</li>
                <li data-filter="now-3">2012</li>
                <li data-filter="now-4">2011</li>
                <li data-filter="now-5">2010</li>
                <li data-filter="year00">00年代</li>
                <li data-filter="year90">90年代</li>
                <li data-filter="year80">80年代</li>
                <li data-filter="year70">70年代</li>
                <li data-filter="earlier">更早</li>
            </ol>
        </div>
        
        <div class="filter_window">  
            <ol class="filters" id="select5">
                <li class="fil_title">状态：</li>
                <li data-filter="all" class="now_onactive">全部</li>
                <li data-filter="hot">热门</li>
                <li data-filter="recommend">推荐</li>
                <li data-filter="newest">最新</li>
                <li data-filter="comments">最多评论</li>
                <li data-filter="mostpop">最受欢迎</li>
                <li data-filter="update">最近更新</li>
                <li data-filter="original">读者原创</li>
            </ol>
        </div>
        
        <div class="filter_window">  
            <ol class="filters" id="select6">
                <li class="fil_title">排序：</li>
                <li data-filter="all" class="now_onactive">全部</li>
                <li data-filter="loan">已借出</li>
                <li data-filter="have">未借出</li>
                <li data-filter="stock">库存</li>
            </ol>
    	</div> 
        
        <!--被筛选出的清单-->
        <div class="select-result">
            <dl>
                <dt>已选：</dt>
                <dd class="select-no">您暂时没有选择过滤条件</dd>   
            </dl>
        </div>
        <!--被筛选出的清单结束-->   
    </div>
    
    <!--检索栏结束-->
    
    <!-- 主体内容开始 -->
   	<div role="main">
	      <ul id="container" class="tiles-wrap animated">
	      
	        <!-- End of grid blocks -->
	      </ul>
   <!--        <div id="page"></div> -->
      </div>
    
	</div>
    <!-- 主体内容结束 -->

	<!-- 清除浮动 -->
	<div class="clear"></div>
	<!-- 清除结束 -->
	<!-- foot开始 -->
	<footer id="footer">
		<div class="foot_content">
			<a href="">集团网站</a> | <a href="">关注我们</a> |<a href="">网站地图</a>  | <a href="">使用条款</a> | Copyright 2015 版权归广州蓝道华荣信息科技有限公司所有 粤ICP备05038405号
		</div>
	</footer>
	<!-- foot结束 -->

</body>
</html>