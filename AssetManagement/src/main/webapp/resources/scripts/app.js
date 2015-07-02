$(function(){
	$(document).on("ready",function(event){
		//alert(1);
		
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
	$('#my_profile').addClass("active");
	$('#asset_confirm_del').hide();
	$('#asset_error').hide();
	
})

function requestAsset(){
	
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
						a = ' <div class="info"><h2>Name: '+data.message[i].name+'</h2><h4>Type: '+data.message[i].type+'</h4><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="createComplaintAsset('+data.message[i].idAsset+')" style="cursor:pointer">Complaint</button><button class="btn-danger btn-lg" data-toggle="modal" data-target="#myModal" onclick="deleteAsset('+data.message[i].idAsset+')" style="cursor:pointer">Remove Asset</button></div>';
					}
				}
				
				$('#info_asset').append(a);
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#asset_error').show();
			}
		}
	});
}
function createRequestAsset(){
	xhr = $.ajax({
		type : 'POST',
		//url : window.username+'/createComplaint?idAsset='+assetId,
		url: 'availableAssets',
		data : '',
		success : function(data) {
			a=[];
			$('#content').html('<table class="table table-hover" id="assets_data"><thead><tr><th></th><th>Name</th><th>Type</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
					if(i%2==0){
						//a += '<tr class="success" onclick="getAsset('+data.message[i].username+')" style="cursor:pointer;"><td>'+data.message[i].firstName+'</td><td>'+data.message[i].lastName+'</td></tr>';
						a.push([data.message[i].idAsset,data.message[i].name,data.message[i].type]);
					}else{
						//a += ' <tr class="info" onclick="getAsset('+data.message[i].idAsset+')" style="cursor:pointer;"><td>'+data.message[i].name+'</td><td>'+data.message[i].name+'</td></tr>';
						a.push([data.message[i].idAsset,data.message[i].name,data.message[i].type]);
					}
				}
				//$('#content').append('<button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="javascript:createRequestAsset();" style="cursor:pointer">New Request</button>');
				console.log(a);
				$('#assets_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "idAsset"},        
			            { "title": "Name" },
			            { "title": "Type" }
			         
			        ],
			        "order": []
			    } );
				$('#assets_data thead th').eq(0).hide();
				$('#assets_data tbody tr').each(function(){
					$("td",this).eq(0).hide();
				});
				
				$('#assets_data tbody').on('click', 'tr', function () {
				    var id = $("td",this).eq(0).text();
				 
				    getAsset(id);
				   	
				} );
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#assets').addClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets').addClass("active");
				$('#my_profile').removeClass("active");
				
			}
		}
	});
}
function createComplaintAsset(assetId){
	xhr = $.ajax({
		type : 'POST',
		url : window.username+'/createComplaint?idAsset='+assetId,
		//url: 'availableAssets',
		data : '',
		success : function(data) {
			var a = "";
			$('#content').html('<div id="asset_error"></div><div id="info_asset"></div><div id="form_complaint"><select id="availableAssets"></select> <label>Error Description</label><textarea></textarea></div>');
			if(data.status == "true"){
				getAssets(window.username);
				$('#info_asset').append(a);
				$('#asset_confirm_del').show();
				$('#asset_confirm_del').text(data.message);
				$('#asset_error').hide();
				setTimeout(function() {$('#myModal').modal('hide');}, 3000);
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#asset_error').show();
				setTimeout(function() {$('#myModal').modal('hide');}, 3000);
			}
		}
	});
}
function deleteAsset(assetId){
	xhr = $.ajax({
				type : 'POST',
				url : window.username+'/removeAsset?idAsset='+assetId,
				data : '',
				success : function(data) {
					var a = "";
					$('#content').html('<div id="asset_error"></div><div id="info_asset"></div>');
					if(data.status == "true"){
						getAssets(window.username);
						$('#info_asset').append(a);
						$('#asset_confirm_del').show();
						$('#asset_confirm_del').text(data.message);
						$('#asset_error').hide();
						setTimeout(function() {$('#myModal').modal('hide');}, 3000);
					}else{   
						$('#asset_error').append(data.message[0]);
						$('#asset_error').show();
						setTimeout(function() {$('#myModal').modal('hide');}, 3000);
					}
				}
			});
}
function getComplaints(username){
	
}
function getMyProfile(){
	location.href="/AssetManagement"
	$('#my_profile').addClass("active");
	$('#assets').removeClass("active");
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
