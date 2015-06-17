$(function(){
	$(document).on("ready",function(event){
		event.preventDefault;
		var hash = $(location).attr('hash');
		var $info = $('#info'), startInfo = $info.html();
		var xhr = null;
		if(hash == "#login_error"){
			xhr = $.ajax({
				type : 'GET',
				url : 'views/Login.jsp',
				data : '',
				success : function(data) {
							$info.html(data);
							$('#login_error').html('Invalid Username or Password!');
							$('#login_error').show();
						
						
						
					}
	            
			});
			history.pushState("", document.title, window.location.pathname);
		}
	});
})
$(function() {
	var $info = $('#info'), startInfo = $info.html();
	$info.on('click', '#button1', function() {
		$.ajax({
			type : 'GET',
			url : 'views/Login.jsp',
			data : '',
			success : function(data) {
					$info.html(data);
			}
		});
	});
	$info.on('click', '#back', function() {
		$info.fadeOut('fast', function() {
			$info.html(startInfo);
		})
		$info.fadeIn('fast');
	});
})

$(function() {
	var $info = $('#info'), startInfo = $info.html();
	$info.on('click', '#button2', function() {
		$.ajax({
			type : 'GET',
			url : 'register',
			data : '',
			success : function(data) {
				
					$info.html(data);
				
			}
		});
	});
	$info.on('click', '#back', function() {
		
			$info.html(startInfo);
		
	});
})
