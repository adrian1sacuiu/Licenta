$(function(){
	$(document).on("ready",function(event){
		$('#edit_user_details').hide();
		$('#user_details').show();
		$('#edit').click(function(){
			$('#user_details').hide();
			$('#edit_user_details').show();
		});
		$('#update').click(function(){
			$('#user_details').show();
			$('#edit_user_details').hide();
		});
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
		}else if(hash == "#auth_request"){
			xhr = $.ajax({
				type : 'GET',
				url : 'views/Login.jsp',
				data : '',
				success : function(data) {
						$info.html(data);
						$('#login_error').html('Please Authenticate in order to proceed!');
						$('#login_error').show();
					}
	            
			});
			history.pushState("", document.title, window.location.pathname);
		}
	});
})
function show_upload(){
	jQuery('#upload_image').html(jQuery('#image').val());
}
function readURL(input) {
//console.log(input);
    if (input[0].files && input[0].files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
        	//alert(e);
            $('#image_value').attr('src', e.target.result);
        }

        reader.readAsDataURL(input[0].files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
});
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
