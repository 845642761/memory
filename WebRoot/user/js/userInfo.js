var form=$('#form');

/**
 * 添加验证
 */
var validate=form.validate({
	submitHandler:function(myform){
		myform.submit();
	}
});

/**
 * 日历
 */
$('#date').datetimepicker();

/**
 * 重置
 */
$('.reset').click(function () {
	form[0].reset();
});