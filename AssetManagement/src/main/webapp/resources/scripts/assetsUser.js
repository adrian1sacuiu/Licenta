function getAssets(username,msg){
	window.username = username;
	xhr = $.ajax({
		type : 'GET',
		url : 'userAssets/'+username,
		data : '',
		success : function(data) {
			var a = [];
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
				console.log(a);
				$('#assets_data').dataTable( {
			        "data": a,
			        "columns": [
			            { "title": "idAsset"},        
			            { "title": "Name" },
			            { "title": "Type" }
			         
			        ]
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
