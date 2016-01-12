$(function() {
	$("#opensearch").click(function() {
		$("#autocomplete").animate({
			width : 'toggle'
		});
	})

	/* 自动补全代码区 */
	$("#autocomplete").accordion();

	$("#autocomplete").autocomplete({
		source : function(request, response) {
//			console.debug(request.term);
			$.ajax({
				url : "searchPrompt",
				data : {
					keyword : request.term
				},
				dataType : "json",
				success : function(data) {
					response($.map(data, function(item) {
//						console.debug(item);
						return item;

					}));
				}
			});
		},
		autoFocus : true,
		minLength : 0, // 输入搜索的最少字数
		position : {
			my : "left top",
			at : "left -5px"
		},
		focus : function() {
			$("#autocomplete").click(function() {
				$("#ui-id-1").show();
			})
		}
	});
	/* 搜索框结束 */

	/* 登录注册窗口切换 */
	$(".log").click(function() {
		$(".log").addClass("l_r_active");
		$(".login_page").css("display", "block");
		$(".register_page").css("display", "none");
		$(".reg").removeClass("l_r_active");
	});

	$(".reg").click(function() {
		$(".reg").addClass("l_r_active");
		$(".login_page").css("display", "none");
		$(".register_page").css("display", "block");
		$(".log").removeClass("l_r_active");
	});

	/* 礼品分类部分列表伸缩效果 */
	$(".fa_list>li>a").click(function() {
		$(this).next(".son_list").slideToggle("slow");
	})
	/* 礼品分类部分列表伸缩效果结束 */

	/* 兑换数量加减部分 */
	$(".add1").click(
			function() {
				$(".add_min input:text").val(
						parseInt($(".add_min input:text").val()) + 1);
			});

	$(".min1").click(
			function() {
				if ($(".add_min input:text").val() == 1) {
					$(".add_min input:text").val("1");
				} else {
					$(".add_min input:text").val(
							parseInt($(".add_min input:text").val()) - 1);
				}
			});
	/* 兑换数量加减部分结束 */

	/* 个人中心-编辑头像--展开系统头像 */
	$(".more_sort").click(function() {
		$(".choose_sty_ul").slideToggle("slow");
	})

	/* 个人中心左list */
	$(".acc_list li").click(function() {
		$(".acc_list li em").remove();
		$(".acc_list li").children("a").attr("class", "");
		$(".acc_right>div").css("display", "none");
		$(this).append("<em></em>");
		$(this).children("a").addClass("targ_active");
		$(".acc_right>div").eq($(this).index()).css("display", "block");
	});
});
