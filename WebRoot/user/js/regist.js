var form=$('#form');

/**
 * 添加验证
 */
var validate=form.validate({
	submitHandler:function(){
		if(!$('#yhxy').is(':checked')){
			alert("请同意用户协议！");
			return false;
		}
		if(loginIdIsExit()){
			$.ajax({
				type : 'POST',
				url :'/user/save.do',
				data : form.serialize(),
				success:function(data) { 
					if(data.code==0){
						alert('注册成功！');
						window.location.href='login.do';
						return true;
					}else{
						alert(data.info);
						return false;
					}
				},
				error : function() {    
					alert("异常！");  
					return false;
				}    
			});
		}else{
			return false;
		}
	}
});

/**
 * 用户帐号是否已存在
 * @author cheng_bo
 * @date 2015年6月1日 11:04:29
 */
function loginIdIsExit(){
	var strLoginId=$('.userName').val();
	$.ajax({
		type : 'POST',
		url :'/user/loginIdIsExit.do',
		dataType : 'json',
		data : 'strLoginId='+strLoginId,
		success:function(data) {
			if(data.code==0){
				return true;
			}else{
				userName.attr('class','has-error');
				return false;
			}
		},
		error : function() {    
			alert("异常！");
			return false;
		}    
	});
	return true;
}