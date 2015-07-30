var form=$('#form');

/**
 * 添加验证
 */
var validate=form.validate({
	submitHandler:function(){
		form.submit();
	}
});


$('#date').datetimepicker();
