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

/**
 * 用户帐号是否已存在
 * @author cheng_bo
 * @date 2015年6月1日 11:04:29
 */
function loginIdIsExit(){
	if(!validation('strLoginId')){
		return false;
	}
	var strLoginId=document.getElementById('strLoginId').value;
	$.ajax({
		type : 'POST',
		url :'/user/loginIdIsExit.do',
		dataType : 'html',
		data : 'strLoginId='+strLoginId,
		success:function(data) { 
			if(data!=null && data=='ok'){
				return true;
			}else{
				var errorTip=document.getElementById('strLoginIdTip');
				errorTip.innerHTML=data;
				errorTip.style.display='block';
				return false;
			}
		},
		error : function() {    
			alert("异常！");  
			return false;
		}    
	});
}

/**
 * ajax提交
 * @author cheng_bo
 * @date 2015年6月4日 21:14:10
 */
function ajaxSubmit(){
	if(!validation('strLoginId')){
		return false;
	}
	if(!validation('password')){
		return false;
	}
	$.ajax({
		type : 'POST',
		url :'/user/add.do',
		data : $('#form').serialize(),
		success:function(data) { 
			if(data!=null && data=='ok'){
				alert('注册成功！');
				window.location.href='login.do';
				return true;
			}else{
				alert(data);
				return false;
			}
		},
		error : function() {    
			alert("异常！");  
			return false;
		}    
	});
}