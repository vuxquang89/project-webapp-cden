/**
 * 
 */

$(document).ready(function(){
	$("textarea[name='i-comment']").map(function(){
		$(this).keyup(function(){
			var line = Math.ceil($(this).val().length / 42);
			if(line == 0) line = 1;
			$(this).height(line * 24 + 'px');
		});
	});
});