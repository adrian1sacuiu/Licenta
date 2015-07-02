function getUsersAdmin(){
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
			         
			        ],
			        "order": []
			    } );
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#edit_user').addClass("active");
				$('#my_profile').removeClass("active");
				$('#assets_admin').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#edit_user').addClass("active");
				$('#my_profile').removeClass("active");
				$('#assets_admin').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
				
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
			$('#content').html('<table class="table table-hover" id="users_data"><thead><tr><th></th><th>Name</th><th>Type</th><th>Availability</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
					var avail = data.message[i].isAvailable;
					if(avail == true){
						isAvailable = "The asset is available";
					}else{
						isAvailable = "The asset is not available";
					}
					if(i%2==0){
						a.push([data.message[i].idAsset,data.message[i].name,data.message[i].type,isAvailable]);
					}else{
						a.push([data.message[i].idAsset,data.message[i].name,data.message[i].type,isAvailable]);
					}
				}
				console.log(a);
				$('#users_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "id",  },        
			            { "title": "Name" },
			            { "title": "Type" },
			            { "title": "Availability" }
			         
			        ],"order": []
			        //column(0).order(false);
			    } );
				$('#users_data thead th').eq(0).hide();
				$('#users_data tbody tr').each(function(){
					$("td",this).eq(0).hide();
				});
				$('#content').append('<button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="cursor:pointer">Add New Asset</button>');
				$('.modal-header').html('Add New Asset');
				$('.modal-body').html('<div id="add_new_asset" class="form-group"><form role="form"><label class="col-sm-4 control-label" for="inputName1">Asset Name:</label><div class="col-sm-8"><input id="assetName" type="text" placeholder="Asset Name" value="" class="form-control"></div><br><br><label class="col-sm-4 control-label" for="inputName1">Asset Type:</label><div class="col-sm-8"><input type="text" id="assetType" placeholder="Asset Type" value="" class="form-control"></div><br><br></form></div>');
				$('.modal-footer').html('<button class="btn btn-default" id="saveAsset" onclick="javascript:saveAsset();" type="button">Save</button><button class="btn btn-default" data-dismiss="modal" type="button">Close</button>');
				
				
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#assets_admin').addClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets_admin').addClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
			}
		}
	
	});
	
}

function saveAsset(){
	var name=$('#assetName').val();
	var type=$('#assetType').val();
	if(name == ""){
		alert('Please add name');
	}else if(type == ""){
		alert('Please add type');
	}
	if(name != "" && type != ""){
		xhr = $.ajax({
			type : 'POST',
			url : 'createAsset',
			data : {name:name,type:type},
			success : function(data) {
				alert("Asset saved");
				getAssetsAdmin();
				$('#myModal').modal('hide');
			}
		});
	}
}


function getRequestsAdmin(){
	xhr = $.ajax({
		type : 'GET',
		url : 'requests',
		data : '',
		success : function(data) {
			var a = [];
			$('#content').html('<table class="table table-hover" id="requests_data"><thead><tr><th>ID</th><th>Date</th><th>Status</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
//					var avail = data.message[i].isAvailable;
//					if(avail == true){
//						isAvailable = "The asset is available";
//					}else{
//						isAvailable = "The asset is not available";
//					}
					if(i%2==0){
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}else{
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}
				}
				console.log(a);
				$('#requests_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "ID"},        
			            { "title": "Date" },
			            { "title": "Status" }
			         
			        ],"order": []
			        //column(0).order(false);
			    } );
				//$('#requests_data thead th').eq(0).hide();
				$('#requests_data tbody tr').each(function(){
				//	$("td",this).eq(0).hide();
				});
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').addClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').addClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
			}
		}
	
	});
	
}



function getTransactionsAdmin(){
	xhr = $.ajax({
		type : 'GET',
		url : 'transactions',
		data : '',
		success : function(data) {
			var a = [];
			$('#content').html('<table class="table table-hover" id="transactions_data"><thead><tr><th>ID</th><th>Date</th><th>Status</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
//					var avail = data.message[i].isAvailable;
//					if(avail == true){
//						isAvailable = "The asset is available";
//					}else{
//						isAvailable = "The asset is not available";
//					}
					if(i%2==0){
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}else{
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}
				}
				console.log(a);
				$('#transactions_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "ID"},        
			            { "title": "Date" },
			            { "title": "Status" }
			         
			        ],"order": []
			        //column(0).order(false);
			    } );
				//$('#transactions_data thead th').eq(0).hide();
				$('#transactions_data tbody tr').each(function(){
				//	$("td",this).eq(0).hide();
				});
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').addClass("active");
				$('#complaints').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').removeClass("active");
				$('#transactions').addClass("active");
				$('#complaints').removeClass("active");
			}
		}
	
	});
	
}


function getComplaintsAdmin(){
	xhr = $.ajax({
		type : 'GET',
		url : 'transactions',
		data : '',
		success : function(data) {
			var a = [];
			$('#content').html('<table class="table table-hover" id="complaints_data"><thead><tr><th>ID</th><th>Date</th><th>Status</th></tr></thead><tbody id="asset_info"></tbody></table>');
			if(data.status == "true"){
				
				for(i=0;i<data.message.length;i++){
//					var avail = data.message[i].isAvailable;
//					if(avail == true){
//						isAvailable = "The asset is available";
//					}else{
//						isAvailable = "The asset is not available";
//					}
					if(i%2==0){
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}else{
						a.push([data.message[i].idRequest,data.message[i].date,data.message[i].status]);
					}
				}
				console.log(a);
				$('#complaints_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "ID"},        
			            { "title": "Date" },
			            { "title": "Status" }
			         
			        ],"order": []
			        //column(0).order(false);
			    } );
				//$('#complaints_data thead th').eq(0).hide();
				$('#complaints_data tbody tr').each(function(){
				//	$("td",this).eq(0).hide();
				});
				//$('#asset_info').append('<br><button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="requestAsset()" style="cursor:pointer">Request New Asset</button>');
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').addClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
				
			}else{   
				$('#asset_error').append(data.message[0]);
				$('#assets_admin').removeClass("active");
				$('#edit_user').removeClass("active");
				$('#my_profile').removeClass("active");
				$('#requests').addClass("active");
				$('#transactions').removeClass("active");
				$('#complaints').removeClass("active");
			}
		}
	
	});
	
}