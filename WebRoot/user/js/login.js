/**
 * 登录
 * @author: cheng_bo
 * @date: 2015年7月28日 14:20:07
 */
var form=$('#form');

/**
 * 添加验证
 */
var validate=form.validate({
	submitHandler:function(){
		$.ajax({
			type : 'POST',
			url :'/user/ssoLogin.do',
			data : form.serialize(),
			success:function(data) { 
				if(data.code==0){
					window.location.href='/system/main.do';
				}else if(data.code==1){
					window.location.href='/user/editUserInfo.do';
				}else{
					alert(data.info);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {    
				alert("异常！");  
				return;
			}    
		});
	}
});