$(function (){
	/**
	 * @Description: 重置默认提示信息
	 * @author: cheng_bo
	 * @date: 2015年7月21日 15:41:30
	 */
	$.extend($.validator.messages,{
		required: "必填字段",
		remote: "请修正该字段",
		email: "请输入正确格式的电子邮件",
		url: "请输入合法的网址",
		date: "请输入合法的日期",
		dateISO: "请输入合法的日期 (ISO).",
		number: "请输入合法的数字",
		digits: "只能输入整数",
		creditcard: "请输入合法的信用卡号",
		equalTo: "请再次输入相同的值",
		maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
		minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
		rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: $.validator.format("请输入一个最大为 {0} 的值"),
		min: $.validator.format("请输入一个最小为 {0} 的值") 
	});
	
	/**
	 * @Description: 自定义方法：userName（验证用户名）
	 * @author: cheng_bo
	 * @date: 2015年7月21日 15:48:05
	 */
	var userName = function (value, element) {
        return this.optional(element) || /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(value);
    };
    $.validator.addMethod("userName", userName, jQuery.validator.format("请输入有效的登录帐号！"));
    
    $.validator.setDefaults({
        errorPlacement: function (error, element) {
        },
        errorClass: 'has-error'
    });
});