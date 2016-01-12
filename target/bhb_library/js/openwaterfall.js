// JavaScript Document
/*(function($)*/ $(function(){
	     
	
	
	      var handler = null, 
			page = 1, 
			isLoading = false, 
			container = '#container',
			wookmark = undefined, options = {
			offset : 2, // Optional, the distance between grid items
			itemWidth : 210
			// 	Optional, the width of a grid item
		}
	      
	      function onScroll(event) {
	  		// Only check when we're not still waiting for data.
	  		if (!isLoading) {
	  			// Check if we're within 100 pixels of the bottom edge of the broser
	  			// window.
	  			var closeToBottom = ($(window).scrollTop() + $(window).height() > $(
	  					document).height() - 200);
	  			if (closeToBottom) {
	  				loadData();
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
		 * Loads data from the API.
		 */
		function loadData(params) {
//			console.debug(params);
			if(typeof(params) == "undefined"){
				params = [];
			}
			// $loaderCircle.show();
			$.ajax({
				url : 'searchBook',
				data : {
					page : page,
					conditions  : params+''
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
			isLoading = false;
			// $loaderCircle.hide();
			// Increment page index for future calls.
			page++;
			// Create HTML for the images.
			var html = '';
			var i = 0, length = books.length, image;
			for (; i < length; i++) {
				image = books[i];
//				console.debug(image);
				html += '<li>';
				// Image tag (preview in Wookmark are 200px wide, so we calculate
				// the height based on that).
				//此处后台并没有传图片宽高，看有无必要，待后期优化
				html += '<img src="' + image.cover + '" width="200" height="'
						+ Math.round(image.height / image.width * 200) + '">';
				// Image title.
				html += '<p><hgroup>';
				html += '<h4><i>' + image.typeName + '</i></h4>';
				html += '<h3>' + image.bookName + '</h3></hgroup>';
				html += '<div><a href="' + '#' + '">' + image.introduction + '</a></div></p>';
				html += '</li>';
				
				if(i == 0){
//					console.debug(html);
				}
			}
			// Add image HTML to the page.
			$(container).append(html);
			// Apply layout.
			applyLayout();
		}
		
		// Capture scroll event.
		$(document).bind('scroll', onScroll);
		// Load first data from the API.
		loadData();
		
		
	
	    })/*(jQuery)*/;