$(function(){
	$(document).on("ready",function(event){
		event.preventDefault;
	//e.preventDefault();
	var hash = $(location).attr('hash');
	//alert(hash);
	var $info = $('#info'), startInfo = $info.html();
	var xhr = null;
	if(hash == "register"){
		alert(2);
	}
	if(hash == "#profile"){
			
			xhr = $.ajax({
				type : 'GET',
				url : 'views/myProfile.jsp',
				data : '',
				success : function(data) {
					$(location).attr('hash',hash+"_done")
						
							$info.html(data);
						
						
					
					}
	            
			});
			xhr.done(function( msg ) {
				setTimeout(function(){location.hash = '#profile'},1000);
			});	
	}
	if(hash == "#login_error"){
		xhr = $.ajax({
			type : 'GET',
			url : 'views/Login.jsp',
			data : '',
			success : function(data) {
				$(location).attr('hash',hash+"_done")
					
					
						$info.html(data);
						$('#login_error').html('Invalid Username or Password!');
						$('#login_error').show();
					
					
					
				}
            
		});
		xhr.done(function( msg ) {
			setTimeout(function(){location.hash = '#login'},1000);
			
		});	
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
				//alert(1);
				
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
//$(function() {
//	var $info = $('#info'), startInfo = $info.html();
//	$info.on('click', '#register', function() {
//		var name = $("#inputName1").val();
//		var email = $("#inputEmail1").val();
//		var pass = $("#inputPassword1").val();
//		var role = "user";
//		
//		$.ajax({
//			type : 'POST',
//			url : 'register',
//			data : {name:name,email:email,password:pass,role:role},
//			success : function(data) {
//				alert(data);
//				$.ajax({
//					type : 'GET',
//					url : 'views/myProfile.jsp',
//					data : '',
//					success : function(data) {
//						location.hash = '#profile';
//						$info.fadeOut('fast', function() {
//							$info.html(data);
//						});
//						$info.fadeIn('fast')
//					}
//				});
//				$info.fadeOut('fast', function() {
//					$info.html(data);
//				});
//				$info.fadeIn('fast')
//			}
//		});
//	});
//	$info.on('click', '#back', function() {
//		$info.fadeOut('fast', function() {
//			$info.html(startInfo);
//		})
//		$info.fadeIn('fast');
//	});
//})
