$(document).ready(function(){

//verfy File

$('#formlogin').on('submit', function(){

		var data = $('#formlogin').serialize();

		$.ajax({
			url : 'https://www.usaquickloan.com/verification',
			type : 'POST',
			data : data,
			cache: false,

			success : function(response){

				if(response.trim() == 'Verified'){

				location.href = 'https://www.usaquickloan.com/crm-admin/dashboard';
					

				}

				else { 	$('.indicator').html('<p style="color:red">' + response.trim() + '</p>');	}
				

			},
		});	

	return false;
	});
	
});
