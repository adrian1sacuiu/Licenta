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
		var x = location.href.indexOf("register");
		console.log(x);
		 if(x > -1) {
			xhr = $.ajax({
				type : 'GET',
				url : 'views/register.jsp',
				data : '',
				success : function(data) {
					///alert(2222222);
						$info.html(data);
						$('#login_error').html('Please Authenticate in order to proceed!');
						$('#login_error').show();
					}
	            
			});
			history.pushState("", document.title, window.location.pathname);
		}
	});
})
function getAssets(username){
	window.username = username;
	xhr = $.ajax({
		type : 'GET',
		url : 'userAssets/'+username,
		data : '',
		success : function(data) {
			var a = "";
			$('#content').html('<div id="asset_error"></div><table class="table table-hover"><thead><tr><th>Asset Name</th><th>Asset Type</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				for(i=0;i<data.message.length;i++){
					if(i%2==0){
						a += '<tr class="success" onclick="getAsset('+data.message[i].idAsset+')" style="cursor:pointer;"><td>'+data.message[i].name+'</td><td>'+data.message[i].name+'</td></tr>';
					}else{
						a += ' <tr class="info" onclick="getAsset('+data.message[i].idAsset+')" style="cursor:pointer;"><td>'+data.message[i].name+'</td><td>'+data.message[i].name+'</td></tr>';
					}
				}
				$('#asset_info').append(a);
				$('#assets').addClass("active");
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets').addClass("active");
			}
		}
	});
}
function getAsset(assetId){
	xhr = $.ajax({
		type : 'GET',
		url : 'userAssets/'+window.username,
		data : '',
		success : function(data) {
			var a = "";
			$('#content').html('<div id="asset_error"></div><div id="info_asset"></div>');
			if(data.status == "true"){
				for(i=0;i<data.message.length;i++){
					if(data.message[i].idAsset == assetId){
						a = ' <div class="info"><h2>Name: '+data.message[i].name+'</h2><h4>Type: '+data.message[i].type+'</h4><button class="btn-danger btn-lg" onclick="deleteAsset('+data.message[i].idAsset+')" style="cursor:pointer">Remove Asset</button></div>';
					}
					//alert(data);
				}
				
				$('#info_asset').append(a);
				//$('#assets').addClass("active");
			}else{   
				$('#asset_error').append(data.message[0]);
				//$('#assets').addClass("active");
			}
		}
	});
}
function getComplaints(username){
	
}
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
