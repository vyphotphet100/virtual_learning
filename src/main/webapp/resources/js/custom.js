/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Header Search
5. Init Home Slider
6. Initialize Milestones


******************************/

$(document).ready(function()
{
	"use strict";

	/* 

	1. Vars and Inits

	*/

	var header = $('.header');
	var menuActive = false;
	var menu = $('.menu');
	var burger = $('.hamburger');
	var ctrl = new ScrollMagic.Controller();

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	initMenu();
	initHeaderSearch();
	initHomeSlider();
	initMilestones();

	/* 

	2. Set Header

	*/

	function setHeader()
	{
		if($(window).scrollTop() > 100)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}

	/* 

	3. Init Menu

	*/

	function initMenu()
	{
		if($('.menu').length)
		{
			var menu = $('.menu');
			if($('.hamburger').length)
			{
				burger.on('click', function()
				{
					if(menuActive)
					{
						closeMenu();
					}
					else
					{
						openMenu();

						$(document).one('click', function cls(e)
						{
							if($(e.target).hasClass('menu_mm'))
							{
								$(document).one('click', cls);
							}
							else
							{
								closeMenu();
							}
						});
					}
				});
			}
		}
	}

	function openMenu()
	{
		menu.addClass('active');
		menuActive = true;
	}

	function closeMenu()
	{
		menu.removeClass('active');
		menuActive = false;
	}

	/* 

	4. Init Header Search

	*/

	function initHeaderSearch()
	{
		if($('.search_button').length)
		{
			$('.search_button').on('click', function()
			{
				if($('.header_search_container').length)
				{
					$('.header_search_container').toggleClass('active');
				}
			});
		}
	}

	/* 

	5. Init Home Slider

	*/

	function initHomeSlider()
	{
		if($('.home_slider').length)
		{
			var homeSlider = $('.home_slider');
			homeSlider.owlCarousel(
			{
				items:1,
				loop:true,
				autoplay:true,
				nav:false,
				dots:false,
				smartSpeed:1200
			});

			if($('.home_slider_prev').length)
			{
				var prev = $('.home_slider_prev');
				prev.on('click', function()
				{
					homeSlider.trigger('prev.owl.carousel');
				});
			}

			if($('.home_slider_next').length)
			{
				var next = $('.home_slider_next');
				next.on('click', function()
				{
					homeSlider.trigger('next.owl.carousel');
				});
			}
		}
	}

	/* 

	6. Initialize Milestones

	*/

	function initMilestones()
	{
		if($('.milestone_counter').length)
		{
			var milestoneItems = $('.milestone_counter');

	    	milestoneItems.each(function(i)
	    	{
	    		var ele = $(this);
	    		var endValue = ele.data('end-value');
	    		var eleValue = ele.text();

	    		/* Use data-sign-before and data-sign-after to add signs
	    		infront or behind the counter number */
	    		var signBefore = "";
	    		var signAfter = "";

	    		if(ele.attr('data-sign-before'))
	    		{
	    			signBefore = ele.attr('data-sign-before');
	    		}

	    		if(ele.attr('data-sign-after'))
	    		{
	    			signAfter = ele.attr('data-sign-after');
	    		}

	    		var milestoneScene = new ScrollMagic.Scene({
		    		triggerElement: this,
		    		triggerHook: 'onEnter',
		    		reverse:false
		    	})
		    	.on('start', function()
		    	{
		    		var counter = {value:eleValue};
		    		var counterTween = TweenMax.to(counter, 4,
		    		{
		    			value: endValue,
		    			roundProps:"value", 
						ease: Circ.easeOut, 
						onUpdate:function()
						{
							document.getElementsByClassName('milestone_counter')[i].innerHTML = signBefore + counter.value + signAfter;
						}
		    		});
		    	})
			    .addTo(ctrl);
	    	});
		}
	}

});

/*******************************
 Start question
*********************************/
// (function($) {
// 	"use strict";
//
// 	var data = [{
// 	  "question": "q1q1q1q1q1q1q1",
// 	  "options": ["aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc", "1111111111"],
// 	  "answer": "3"
// 	}, {
// 	  "question": "q2q2q2q2q2q2q2",
// 	  "options": ["2222222222", "bbbbbbbbbb", "cccccccccc", "dddddddddd"],
// 	  "answer": "0"
// 	}, {
// 	  "question": "q3q3q3q3q3q3q3",
// 	  "options": ["aaaaaaaaaa", "3333333333", "cccccccccc", "dddddddddd"],
// 	  "answer": "1"
// 	}, {
// 	  "question": "q4q4q4q4q4q4q4",
// 	  "options": ["aaaaaaaaaa", "bbbbbbbbbb", "4444444444", "dddddddddd"],
// 	  "answer": "2"
// 	}, {
// 	  "question": "q5q5q5q5q5q5q5",
// 	  "options": ["aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc", "1111111111"],
// 	  "answer": "3"
//
// 	}];
//
// 	var $form = $("#q_a"),
// 	  $answers = $("#answers"),
// 	  $result = $("#result"),
// 	  $checkResult = $("#checkResult"),
// 	  $showResult = $("#showResult"),
// 	  $reset = $("#resetResult"),
// 	  reset = true,
// 	  $group, $item;
//
// 	// Tạo bảng trắc nghiệm
// 	$.each(data, function(index, value) {
//
// 	  $group = $("<ul>", {
// 		"id": "q" + index,
// 		"class": "question"
// 	  }).appendTo($answers);
//
// 	  // Nội dung câu hỏi
// 	  $group.before('<p class="qContent">' + value.question + '</p>');
//
// 	  // Tạo danh sách các lựa chọn
// 	  $item = [];
// 	  $.each(value.options, function(sub_index, sub_value) {
// 		$item[sub_index] = '<li><input  id="q' + index + 'a' + sub_index + '" class="items" type="radio" name="answer' + index + '" value="' + sub_index + '"><label for="q' + index + 'a' + sub_index + '">' + sub_value + '</label></li>';
// 	  });
// 	  $group.html($item.join(""));
//
// 	});
//
// 	// Hiển thị kết quả
// 	$form.on("submit", function(e) {
// 	  e.preventDefault();
// 	  // Kiểm tra các đáp án đã chọn
// 	  $.each($(this).serializeArray(), function(index, value) {
//
// 		var check = value.name.match(/\d/)[0],
// 		  $q = $("#q" + check);
//
// 		$q.removeClass("wrong correct");
// 		if (data[check].answer !== value.value) {
// 		  $q.addClass("wrong");
// 		} else {
// 		  $q.addClass("correct");
// 		}
//
// 	  });
//
// 	  // Hiển thị các thông số đánh giá kết quả
// 	  var wrong = $(".wrong").length,
// 		correct = $(".correct").length,
// 		empty = $(".question:not(.wrong):not(.correct)").length-1;
//
// 	  $result.html(wrong + ' wrong<br>' + correct + ' correct<br>' + empty + ' unfinished');
//
// 	  $checkResult.hide();
//
// 	  if (!(wrong === 0 && empty === 0)) { // Nếu đúng hết thì không hiện nút Xem đáp án và nút Làm lại
// 		$showResult.show();
//
// 		if (reset) { // Cho phép làm lại 1 lần
// 		  $reset.show();
// 		}
// 	  }
//
// 	  $form.find(":radio").prop("disabled", true);
//
// 	});
//
// 	// Làm lại (giữ lại câu đúng)
// 	$reset.on("click", function(e) {
// 	  e.preventDefault();
//
// 	  if (reset) { // Cho phép làm lại 1 lần
// 		reset = false;
// 		$result.empty();
// 		$showResult.hide();
// 		$reset.hide();
// 		$checkResult.show();
// 		$form.find("ul:not(.correct)").find(":radio").prop("disabled", false);
// 		$form.find(".wrong").removeClass("wrong");
// 	  }
//
// 	});
//
// 	// Xem đáp án
// 	$showResult.on("click", function(e) {
// 	  e.preventDefault();
//
// 	  // Đánh dấu các đáp án
// 	  $.each(data, function(index, value) {
// 		$("#q" + index + "a" + value.answer).addClass("key");
// 	  });
//
// 	  $reset.hide();
// 	  $showResult.hide();
//
// 	});
//
// })(jQuery);
/*******************************
 End question
*********************************/
/********************************
 Start Add lesstion teacher
 *********************************/
 (function($){
    const fileUploader = document.getElementById('file-uploader');
    const feedback = document.getElementById('feedback');
    const progress = document.getElementById('progress');
    
    const reader = new FileReader();
    
    fileUploader.addEventListener('change', (event) => {
    const files = event.target.files;
    const file = files[0];
    reader.readAsDataURL(file);
    console.log('files', files);
    
    reader.addEventListener('progress', (event) => {
        if (event.loaded && event.total) {
        const percent = (event.loaded / event.total) * 100;
        progress.value = percent;
        document.getElementById('progress-label').innerHTML = Math.round(percent) + '%';
        
        if (percent === 100) {
            let msg = `<span style="color:#14BDEE;"> <u><strong>${files.length}</b></u> File has been uploaded successfully.</span>`;
            feedback.innerHTML = msg;
        }
        }
    });
    });
})(jQuery);
/********************************
 End Add lesstion teacher
 *********************************/