$(window).on('load', function(){



	"use strict";



	$(window).on('scroll', function() {

		if($(this).scrollTop() > 450) {

			$('.navbar-fixed-top').addClass('opaque');

		} else {

			$('.navbar-fixed-top').removeClass('opaque');

		}

	});

 


	});  
