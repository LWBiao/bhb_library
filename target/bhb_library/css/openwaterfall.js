// JavaScript Document

	    (function($) {
	      // Instantiate wookmark after all images have been loaded
	      var wookmark;
	      imagesLoaded('#container', function() {
	        wookmark = new Wookmark('#container', {
	          fillEmptySpace: true // Optional, fill the bottom of each column with widths of flexible height
	        });
	      });

	      // Setup filter buttons when jQuery is available
	      var $filters = $('#filters li');

	      /**
	       * When a filter is clicked, toggle it's active state and refresh.
	       */
	      function onClickFilter(e) {
	        var $item = $(e.currentTarget),
	            activeFilters = [],
	            filterType = $item.data('filter');

	        if (filterType === 'all') {
	          $filters.removeClass('active');
	        } else {
	          $item.toggleClass('active');

	          // Collect active filter strings
	          $filters.filter('.active').each(function() {
	            activeFilters.push($(this).data('filter'));
	          });
	        }

	        wookmark.filter(activeFilters, 'or');
	      }

	      // Capture filter click events.
	      $('#filters').on('click.wookmark-filter', 'li', onClickFilter);
	    })(jQuery);