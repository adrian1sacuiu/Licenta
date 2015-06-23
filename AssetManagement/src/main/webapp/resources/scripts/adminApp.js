function getUsers(){
	xhr = $.ajax({
		type : 'GET',
		url : 'users',
		data : '',
		success : function(data) {
			var a = [];
			$('#content').html('<table class="table table-hover" id="users_data"><thead><tr><th></th><th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Role</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
					if(i%2==0){
						
						a.push([data.message[i].idUser,data.message[i].username,data.message[i].firstName,data.message[i].lastName,data.message[i].email,data.message[i].role]);
					}else{
						
						a.push([data.message[i].idUser,data.message[i].username,data.message[i].firstName,data.message[i].lastName,data.message[i].email,data.message[i].role]);
					}
				}
				console.log(a);
				$('#users_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "id","visible": false },        
			            { "title": "Username" },
			            { "title": "First Name" },
			            { "title": "Last Name" },
			            { "title": "Email" },
			            { "title": "Role" }
			         
			        ]
			    } );
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#edit_user').addClass("active");
				$('#my_profile').removeClass("active");
				$('#assets').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets').addClass("active");
				$('#my_profile').removeClass("active");
				
			}
		}
	
	});
	
}


function getAssetsAdmin(){
	
	xhr = $.ajax({
		type : 'GET',
		url : 'assets',
		data : '',
		success : function(data) {
			var a = [];
			$('#content').html('<table class="table table-hover" id="users_data"><thead><tr><th></th><th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Role</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
					if(i%2==0){
						
						a.push([data.message[i].idUser,data.message[i].username,data.message[i].firstName,data.message[i].lastName,data.message[i].email,data.message[i].role]);
					}else{
						
						a.push([data.message[i].idUser,data.message[i].username,data.message[i].firstName,data.message[i].lastName,data.message[i].email,data.message[i].role]);
					}
				}
				console.log(a);
				$('#users_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "id","visible": false },        
			            { "title": "Username" },
			            { "title": "First Name" },
			            { "title": "Last Name" },
			            { "title": "Email" },
			            { "title": "Role" }
			         
			        ]
			    } );
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#edit_user').addClass("active");
				$('#my_profile').removeClass("active");
				$('#assets').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets').addClass("active");
				$('#my_profile').removeClass("active");
				
			}
		}
	
	});
	
}