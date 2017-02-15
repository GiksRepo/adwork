$(document).ready(function(){

		$('#country').on('change',function(){
			var countryId=$(this).val();
			if(countryId)
				{
				 $.ajax({
			            type:'POST',
			            url:'getStates',
			            data:{'countryId':countryId},
			            success:function(data){
			            	$.each(data, function (key, value) {
			            		$('#state').append( '<option value="'+key+'">'+value+'</option>');
			            	})
			            }
			        });
				}
		});
});