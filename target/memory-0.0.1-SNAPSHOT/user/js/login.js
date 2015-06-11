/**
 * 登录
 * @author cheng_bo
 * @date 
 */
function login(){
	if(!validation('strLoginId')){
		return false;
	}
	if(!validation('password')){
		return false;
	}
	$.ajax({
		type : 'POST',
		url :'/user/ssoLogin.do',
		data : $('#form').serialize(),
		success:function(data) { 
			if(data!=null){
				if(data=='ok'){
					window.location.href='/system/main.do';
				}else if(data=='addInfo'){
					window.location.href='/user/addUserInfo.do';
				}else{
					alert(data);
				}
			}
		},
		error : function() {    
			alert("异常！");  
			return false;
		}    
	});
}

/**
* 验证参数
*/
function validation(id){
	if(id==null || id==''){
		return false;
	}
	var obj=document.getElementById(id);
	var msg='';
	var errorTip=document.getElementById(id+'Tip');
	if(errorTip.hasAttribute('msg')){
		msg=errorTip.getAttribute('msg');
	}
	if(obj.value==null || obj.value==''){
		errorTip.style.display='block';
		return false;
	}
	errorTip.innerHTML=msg;
	errorTip.style.display='none';
	return true;
}