/**
 * 用户帐号是否已存在
 * @author cheng_bo
 * @date 2015年6月1日 11:04:29
 */
function loginIdIsExit(){
	var strLoginId=$('#strLoginId').val();
	if(strLoginId==null || strLoginId==''){
		alert('请输入正确的帐号！');
		return false;
	}
	$.ajax({
		type : 'POST',
		url :'user/loginIdIsExit.do',
		dataType : 'html',
		data : strLoginId,
		success:function(data) { 
			if(data!=null && data=='ok'){
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