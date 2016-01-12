// JavaScript Document
/*(function($)*/ $(function(){
	  
		function loadChildrenType(types) {
//			console.debug(types);
			$.ajax({
				url : 'searchChildrenType',
				dataType : 'json',
				data : { types:types + ''},
				success : onLoadChildrenType
			});
		}
		
		function onLoadChildrenType(data) {
			var childrenTypes = JSON.parse(data.childrenTypes);
			var type = JSON.parse(data.type);
//			console.debug(childrenTypes);
			
			var html ='';
			html += '<div name="cTypeList-' + type.id + '-' + type.code + '"';
			html += 'class="filter_ol_son" style="display:none;">';
			html += '<h4 class="son_sort">' + type.name + ':</h4>';
			html += '<ol class="filters filter_son_ol">';
			
			var i=0, length =childrenTypes.length, childrenType;
			for(; i<length; i++){
				childrenType = childrenTypes[i];
				html += '<li name="cType-' + childrenType.id + '-' + childrenType.code + '">';
				html += childrenType.name + '</li>';
			}
			html += '</ol></div>';
			
//			console.debug(html);
			$('#two_list').append(html);
			var divName = 'cTypeList-' + type.id + '-' + type.code;
//			console.debug($(".two_list").children("div[name=" + divName + "]"));
			
			$(".two_list").children("div").eq($(this).index()).slideToggle();
			
/*检索项目被选*/
			
			$(".two_list>div ol li").click(function () {
				$(this).addClass("fil_sonli_active");
					$(".select-no").css("display","none");
					var sContent=$(this).text();
					$(".select-result dl").append("<dd><span><a>"+sContent+"</a><em>×</em></span></dd>");
					$(".select-result dl dd").addClass("selected");
					
					$(this).click(function () {
						$(this).removeClass("fil_sonli_active");
						
						});
					
					
					$(".selected span em").click(function () {
						if($(this).length==1){
						$(".select-no").css("display","inline-block");
						$(this).parent("span").parent(".selected").remove();	
							}else{
						$(".select-no").css("display","none");
						$(this).parent("span").parent(".selected").remove();
						}
					})
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
				data : { a:'a'
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
//			console.debug(types);
			var fatherlist = '#top_fatherlist';
			var html = '';
			var i = 0, length = types.length, type;
			for (; i < length; i++) {
				type = types[i];
//				console.debug(type);
				html += '<li name="type-' + type.id + '-' + type.code + '">' + type.name;
				html += '</li>';
//				console.debug(html);
			}
			$(fatherlist).append(html);
			
			
			/*检索区*/
			/*展开二级索引*/
			$("#top_fatherlist li").click(function () {
				$(".two_list>div").css("display","none");
				$(this).addClass("fil_fatherli_active").siblings().removeClass("fil_fatherli_active");
				/*选择对应的二级类别*/
//				console.debug($($(this)[0]).attr("name"));
//				console.debug($($(this)[0]).attr("name").split("-"));
				var types = $($(this)[0]).attr("name").split("-");
//				console.debug(types);
				
				loadChildrenType(types);
				
				})
				
				
			/*检索区结束*/
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
//			console.debug(publishers);
			
			 //<li name="pub-">北京出版社</li>
			var pubList = '#pub_list';
			var html = '';
			var i = 0, length = publishers.length, publisher;
			for (; i < length; i++) {
				publisher = publishers[i];
				html += '<li name="pub-' + publisher.id + '-' + publisher.code + '">' + publisher.name;
				html += '</li>';
//				console.debug(html);
			}
			$(pubList).append(html);
		}
		
		
		loadType();
		loadPublisher();
		

	      // Setup filter buttons when jQuery is available
	      var $filters = $('.filters li');

	      /**
	       * When a filter is clicked, toggle it's active state and refresh.
	       */
	      function onClickFilter(e) {
	        var $item = $(e.currentTarget),
	            activeFilters = [],
	            filterType = $item.data('filter');
	        console.debug($item);

	        if (filterType === 'all') {
	          $filters.removeClass('active');
	        } else {
	          $item.toggleClass('active');

	          // Collect active filter strings
	          $filters.filter('.active').each(function() {
	            activeFilters.push($(this).data('filter'));
	          });
	        }

//	        wookmark.filter(activeFilters, 'or');
	      }

	      // Capture filter click events.
	      $('.filters').on('click.wookmark-filter', 'li', onClickFilter);
	    })/*(jQuery)*/;