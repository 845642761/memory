/**
 * 用户帐号是否已存在
 * @author cheng_bo
 * @date 2015年6月1日 11:04:29
 */
function loginIdIsExit(){
	var strLoginIdTip=$('#strLoginIdTip');
	strLoginIdTip.css("display","none");
	var strLoginId=$('#strLoginId').val();
	if(strLoginId==null || strLoginId==''){
		strLoginIdTip.html(strLoginIdTip.attr('msg'));
		strLoginIdTip.css("display","block");
		return false;
	}
	$.ajax({
		type : 'POST',
		url :'/user/loginIdIsExit.do',
		dataType : 'html',
		data : 'strLoginId='+strLoginId,
		success:function(data) { 
			if(data!=null && data=='ok'){
				return true;
			}else{
				$('#strLoginIdTip').html(data);
				$('#strLoginIdTip').css("display","block");
				return false;
			}
		},
		error : function() {    
			alert("异常！");  
			return false;
		}    
	});
}