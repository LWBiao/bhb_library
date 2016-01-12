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
    <!--索引查询-->
   	<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js" ></script>
  	<script src="<%=basePath %>js/imagesloaded.pkgd.min.js"></script> 
	<script src="<%=basePath %>js/wookmark.js"></script>
    <script src="<%=basePath %>js/openwaterfall.js"></script>
    <script src="<%=basePath %>js/navigation.js"></script>
    <!--查询-->
    <script src="<%=basePath %>js/jquery-ui.js"></script>
    <!--公共-->
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
                	<!-- <form id="keywordForm" method="post"> -->
                        <input name="keyword" type="text" list="bookkeywords" id="autocomplete" class="bo_search" placeholder="我要查找..">
                        <img id="opensearch" src="<%=basePath %>images/b_search.png">
                    <!-- </form> -->
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
                <!-- <li name="type-cy">穿越</li> -->
            </ol>
		</div>
        <!--一级列表结束-->
        <!--二级列表-->
        <div class="two_list"  id="two_list">
            <!--  <div class="filter_ol_son" style="display:none;">
                <h4 class="son_sort">穿越 :</h4>
                <ol class="filters filter_son_ol">
                    <li name="type-id-zgddxs">中国当代小说</li>
                </ol>
            </div> -->
        </div>  
        <!--二级列表结束-->
        
        <div class="filter_window bigsort">  
            <ol class="filters"  id="pub_list">
                <li class="fil_title">出版：</li>
                <li class="" name="pub-all">全部</li>
<!--                 <li class="now_onactive" name="pub-all">全部</li> -->
                <!--   <li name="pub-">北京出版社</li> -->
            </ol>
        </div>
        
      <!--   <div class="filter_window bigsort">     
           <ol class="filters" id="star_list">
                <li class="fil_title">星级(待定)：</li>
                <li name="star-all" class="">全部</li>
                <li name="star-5">5星</li>
                <li name="star-4">4星</li>
                <li name="star-3">3星</li>
                <li name="star-2">2星</li>
                <li name="star-1">1星</li>
            </ol>
        </div> -->
        
        <div class="filter_window bigsort">  
            <ol class="filters" id="length_list">
                <li class="fil_title">篇幅(待定)：</li>
                <li name="length-all" class="">全部</li>
                <li name="length-long">长篇小说</li>
                <!-- <li name="length-middle">中篇小说</li> -->
                <li name="length-short">短篇小说</li>
            </ol>
        </div>
        
        <div class="filter_window bigsort">  
            <ol class="filters" id="bookCard_list">
                <li class="fil_title">书卡(待定)：</li>
                <li name="bookCard-all" class="">全部</li>
                <li name="bookCard-free">免费</li>
				<li name="bookCard-one">1张</li>
                <li name="bookCard-two">2张</li>
                <!-- <li name="bookCard-three">3张</li> -->
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
	        <%-- <li>
	          	<img src="<%=basePath %>images/00.jpg">
                <p>
                    <hgroup>
                        <h4><i>原创书库原创书库</i></h4>
                        <h3>【雅媛会】×《时尚COSMO》</h3>
                    </hgroup>
                    
                    <div><a href="">从电视剧到电影，人气演员海清成功塑造了不少荧幕女性形象。在诸多角色中，"好媳妇儿"的演绎深入人心，因而常被称为"中国好媳妇"，在近日的一组街拍大片中，一身EP雅莹的格纹造型，诉说着复古格调。</a></div>
                </p>
	        </li> --%>
	        
	        <!-- End of grid blocks -->
	      </ul>
          <!--<div id="page"></div>-->
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
	
    <!--以下为页面附加内容-->
    <!--右侧栏-->
    <div id="right_aside">
    	<dl>
        	<dt></dt>
        	<dd>书城客户端</dd>
        </dl>
    	
        <dl>
        	<dt class="aside_dt01"></dt>
        	<dd>我的书篮</dd>
        </dl>
        
        <dl>
        	<dt class="aside_dt02"></dt>
        	<dd>签到积分</dd>
        </dl>
        
        <dl>
        	<dt class="aside_dt03"></dt>
        	<dd>客服中心</dd>
        </dl>
        
        <dl>
        	<dt class="aside_dt04"></dt>
        	<dd>投诉中心</dd>
        </dl>
    </div>
    <!--右侧栏结束-->
      
</body>
</html>