// JavaScript Document
/*(function($)*/$(function() {

	var handler = null, startPage = 0, pageSize = 10, isLoading = false, container = '#container', wookmark = undefined, options = {
		offset : 2, // Optional, the distance between grid items
		itemWidth : 210
	// Optional, the width of a grid item
	}
	var conditionData = [];
	var loadDataType = "all";
	var keyData;
	var pageCount; // 总页数
	var sign = 10;

	$('#autocomplete').keydown(function(e) {
		if (e.keyCode == 13) {
			startPage = 0;
			loadDataType = "key";
			// $('#keywordForm').submit(); // 处理事件
			keyData = $('#autocomplete').attr('value');
			console.debug(keyData);
			if("" == keyData || typeof(keyData) == "undefined"){
				loadAllData();
			}else{
				loadKeyData(keyData);
			}
		}
	});

	function scrollDown(event) {
		var closeToBottom = ($(window).scrollTop() + $(window).height() > $(
				document).height() - 200);
		if (closeToBottom && startPage < pageCount) {

			console.debug("onScroll");
			startPage++;
			if (loadDataType == 'all') {
				// alert("all-scroll");
				loadAllData();
			} else if (loadDataType == 'key') {

				// alert("key-scroll");
				loadKeyData(keyData);
			} else if (loadDataType == 'condition') {
				// alert("condition-scroll");
				if(conditionData.length>0){
					loadConditionData(conditionData);
				}else{
					loadAllData();
				}

			}
		}
	}

	function onScroll(event) {

		window.onscroll = window.onresize = function() {
			var scrtop = document.documentElement.scrollTop
					|| document.body.scrollTop;
			var height = document.documentElement.clientHeight
					|| document.body.clientHeight;

			if (scrtop > sign) {
				sign = scrtop;
				scrollDown();
				// document.title = "向下" + scrtop;
			}
			if (scrtop < sign) {
				sign = scrtop;
				// document.title = "向上" + scrtop;
			}
		}
	}

	/**
	 * Refreshes the layout after all images have loaded
	 */
	function applyLayout() {
		imagesLoaded(container, function() {
			if (wookmark === undefined) {
				wookmark = new Wookmark(container);
			} else {
				wookmark.initItems();
				wookmark.layout(true);
			}
		});
	}

	/**
	 * Loads All data from the API.
	 */
	function loadAllData() {
		console.debug("loadAll");
		$.ajax({
			url : 'searchAllBook',
			data : {
				start : startPage,
				pageSize : pageSize
			}, // Page parameter to make sure we load new data
			dataType : 'json',
			success : onLoadData
		});
	}
	/**
	 * Loads Key data from the API.
	 */
	function loadKeyData(keyword) {
		$.ajax({
			url : 'searchBookByKey',
			data : {
				start : startPage,
				pageSize : pageSize,
				keyword : keyword
			}, // Page parameter to make sure we load new data
			dataType : 'json',
			success : onLoadData
		});
	}

	/**
	 * Receives data from the API, creates HTML for images and updates the
	 * layout
	 */
	function onLoadData(data) {
		var books = JSON.parse(data.books);
		console.debug(loadDataType);
		console.debug(books);
		pageCount = JSON.parse(data.pageCount);
//		console.debug(pageCount);
		isLoading = false;
		var html = '';
		var i = 0, length = books.length, image;
		for (; i < length; i++) {
			image = books[i];
			// console.debug(image);
			html += '<li>';
			// Image tag (preview in Wookmark are 200px wide, so we calculate
			// the height based on that).
			// 此处后台并没有传图片宽高，看有无必要，待后期优化
			html += '<img src="' + image.cover + '" width="200" height="'
					+ Math.round(image.height / image.width * 200) + '">';
			// Image title.
			html += '<p><hgroup>';
			html += '<h4><i>' + image.typeName + '</i></h4>';
			html += '<h3>' + image.bookName + '</h3></hgroup>';
			html += '<div><a href="' + '#' + '">' + image.introduction
					+ '</a></div></p>';
			html += '</li>';

			if (i == 0) {
				// console.debug(html);
			}
		}
		// Add image HTML to the page.
//		console.debug(startPage);
		if (!(startPage > 0)) {
			$(container).empty();
		}
		$(container).append(html);
		// Apply layout.
		applyLayout();
	}

	// Capture scroll event.
	$(document).bind('scroll', onScroll);
	// Load first data from the API.
	loadAllData();

	/**
	 * Loads condition data from the API.
	 */
	function loadConditionData(conditions) {
		startPage = 0;
		$.ajax({
			url : 'searchBookByCondition',
			data : {
				start : startPage,
				pageSize : pageSize,
				conditions : conditions + ''
			}, // Page parameter to make sure we load new data
			dataType : 'json',
			success : onLoadData
		});
	}

	function delStr(str, arr) {
		var n = -1;
		for (var i = 0, len = arr.length; i < len; i++) {
			if (str == arr[i]) {
				n = i;
				break;
			}
		}
		n > -1 && arr.splice(n, 1);
	}
	;

	function trim(str) {
		return str.replace(/^\s+|\s+$/g, '')
	}
	;

	function prev(elem) {
		do {
			elem = elem.previousSibling;
		} while (elem && elem.nodeType != 1);
		return elem;
	}

	function loadChildrenType(types) {
		// console.debug(types);
		$.ajax({
			url : 'searchChildrenType',
			dataType : 'json',
			data : {
				types : types + ''
			},
			success : onLoadChildrenType
		});
	}

	function onLoadChildrenType(data) {
		var childrenTypes = JSON.parse(data.childrenTypes);
		var type = JSON.parse(data.type);
		// console.debug(childrenTypes);

		var html = '';
		html += '<div name="cTypeList-' + type.id + '-' + type.code + '"';
		html += 'class="filter_ol_son" style="display:none;">';
		html += '<h4 class="son_sort">' + type.name + ':</h4>';
		html += '<ol class="filters filter_son_ol">';
		
		html += '<li name="cType-all">全部</li>'

		var i = 0, length = childrenTypes.length, childrenType;
		for (; i < length; i++) {
			childrenType = childrenTypes[i];
			html += '<li name="cType-' + childrenType.id + '-'
					+ childrenType.code + '">';
			html += childrenType.name + '</li>';
		}
		html += '</ol></div>';

		// console.debug(html);
		$('#two_list').append(html);
		var divName = 'cTypeList-' + type.id + '-' + type.code;
		// console.debug($(".two_list").children("div[name=" + divName + "]"));

		$(".two_list").children("div").eq($(this).index()).slideToggle();

		/* 检索--被选项目 */
		/* 类别1 */

		$(".two_list>div ol li").click(
				function() {
					loadDataType = "condition";
					var sName = $(this).attr("name");
					var sContent = $(this).text();
					console.debug(sContent);
					delStr(sName, conditionData);

					if ($(this).hasClass("fil_sonli_active")) {
						$(this).removeClass("fil_sonli_active");
						for (var j = 0; j < $(".selected").length; j++) {
							var gg = $(".selected").eq(j).find("a").text();
							var yy = $(".selected").eq(j);
							if (sContent == gg) {
								yy.remove();
							}
							if (conditionData.length == 0) {
								$(".select-no").css("display", "inline-block");
							}
						}
					} else {
						$(this).addClass("fil_sonli_active");
						$(".select-result dl").append(
								"<dd class=\"selected\"><span><a name=" + sName
										+ ">" + sContent
										+ "</a><em>×</em></span></dd>");
						conditionData.push(trim(sName));
						$(".select-no").css("display", "none");
					}

					/* 检索--已选项目 */
					var aLi = $(".two_list>div ol li");
					var aDt = $(".select-result dl dt");
					var aDd = aDt.next();
					var html = aDd.find("a").text();
					$(".selected span em").click(function() {

						var oA = $(this).prev().html()
						var oAName = $(this).prev().attr("name");
						$(this).parent("span").parent(".selected").remove();

						for (var k = 0; k < aLi.length; k++) {
							if (oA == aLi.eq(k).text()) {
								aLi.eq(k).removeClass("fil_sonli_active");
							}
						}
						for (var x = 0; x < conditionData.length; x++) {
							console.debug(conditionData[x]);
							if (conditionData[x] == oAName) {
								// alert(conditionData[x]);
								conditionData.splice(x, 1);
								break;
							}
						}
						if(conditionData.length>0){
							loadConditionData(conditionData);
						}else{
							loadAllData();
						}
					})
					console.debug(conditionData);
					if(conditionData.length>0){
						loadConditionData(conditionData);
					}else{
						loadAllData();
					}
				});
	}
	
	/**
	 * Loads type from the API.
	 */
	function loadType() {
		isLoading = true;
		// $loaderCircle.show();
		$.ajax({
			url : 'searchType',
			dataType : 'json',
			data : {
				a : 'a'
			}, // Page parameter to make sure we load new data
			success : onLoadType
		});
	}

	/**
	 * Receives data from the API, creates HTML for images and updates the
	 * layout
	 */
	function onLoadType(data) {
		var types = JSON.parse(data.types);
		// console.debug(types);
		var fatherlist = '#top_fatherlist';
		var html = '';
		var i = 0, length = types.length, type;
		for (; i < length; i++) {
			type = types[i];
			// console.debug(type);
			html += '<li name="type-' + type.id + '-' + type.code + '">'
					+ type.name;
			html += '</li>';
			// console.debug(html);
		}
		$(fatherlist).append(html);

		/* 检索区 */
		/* 展开二级索引 */
		$("#top_fatherlist li").click(
				function() {
					$(".two_list>div").css("display", "none");
					$(this).addClass("fil_fatherli_active").siblings()
							.removeClass("fil_fatherli_active");
					/* 选择对应的二级类别 */
					// console.debug($($(this)[0]).attr("name"));
					// console.debug($($(this)[0]).attr("name").split("-"));
					var types = $($(this)[0]).attr("name").split("-");
					// console.debug(types);

					loadChildrenType(types);

				})

		/* 检索区结束 */
	}

	function loadPublisher() {
		$.ajax({
			url : 'searchPublisher',
			dataType : 'json',
			success : onLoadPublisher
		});
	}

	function onLoadPublisher(data) {
		var publishers = JSON.parse(data.publishers);
		// console.debug(publishers);

		// <li name="pub-">北京出版社</li>
		var pubList = '#pub_list';
		var html = '';
		// ////////////////////////////////////////////////TODO
		//
		// var i = 0, length = publishers.length, publisher;
		var i = 0, length = 21, publisher;
		for (; i < length; i++) {
			publisher = publishers[i];
			html += '<li name="pub-' + publisher.id + '-' + publisher.code
					+ '">' + publisher.name;
			html += '</li>';
			// console.debug(html);
		}
		$(pubList).append(html);

		/* 类别2 */
		$(".bigsort ol li").click(
				function() {
					loadDataType = "condition";
					var sName = $(this).attr("name");
					var sContent = $(this).text();
					console.debug(sContent);
					delStr(sName, conditionData);

					if ($(this).hasClass("now_onactive")) {
						$(this).removeClass("now_onactive");
						for (var j = 0; j < $(".selected").length; j++) {
							var gg = $(".selected").eq(j).find("a").text();
							var yy = $(".selected").eq(j);
							if (sContent == gg) {
								yy.remove();
							}
							if (conditionData.length == 0) {
								$(".select-no").css("display", "inline-block");
							}
						}
					} else {
						$(this).addClass("now_onactive");
						$(".select-result dl").append(
								"<dd class=\"selected\"><span><a name=" + sName
										+ ">" + sContent
										+ "</a><em>×</em></span></dd>");
						conditionData.push(trim(sName));
						$(".select-no").css("display", "none");
					}

					/* 检索--已选项目 */
					var aLi = $(".bigsort ol li");
					var aDt = $(".select-result dl dt");
					var aDd = aDt.next();
					var html = aDd.find("a").text();
					$(".selected span em").click(function() {
						var oA = $(this).prev().html();
						var oAName = $(this).prev().attr("name");
						$(this).parent("span").parent(".selected").remove();

						for (var k = 0; k < aLi.length; k++) {
							if (oA == aLi.eq(k).text()) {
								aLi.eq(k).removeClass("now_onactive");
							}
						}
						for (var x = 0; x < conditionData.length; x++) {
							console.debug(conditionData[x]);
							if (conditionData[x] == oAName) {
								// alert(conditionData[x]);
								conditionData.splice(x, 1);
								break;
							}
						}
						if(conditionData.length>0){
							loadConditionData(conditionData);
						}else{
							loadAllData();
						}
					})

					console.debug(conditionData);
					if(conditionData.length>0){
						loadConditionData(conditionData);
					}else{
						loadAllData();
					}
				});

	}

	loadType();
	loadPublisher();

})/* (jQuery) */;

