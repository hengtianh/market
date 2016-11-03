/**
 * 表单验证的js文件
 */

//验证email是否有效
$('#email').blur(function(){
	var emailVal = $(this).val();
	$.ajax({
		url:'exist.action',
		data:"email="+emailVal,
		type:'get',
		contentType:'application/json',
		success:function(data){
			if(data!=''&&data==emailVal){
				$('#emailinfo').text('该邮箱已被注册，请更换后重试');
				$('#subbtn').attr('disabled','disabled');
			}else{
				$('#emailinfo').text('');
				$('#subbtn').removeAttr('disabled');
			}
		}
	});
	if(email.length<5){
		return false;
	}else{
		return true;
	}
});

//验证两次输入的密码是否一致
$('#password1').blur(function(){
	var password = $('#password').val();
	var password1 = $(this).val();
	if(password!=password1){
		$('#pwd1info').text('两次输入密码不一致，请重试');
		$('#subbtn').attr('disabled','disabled');
	}else{
		$('#pwd1info').text('');
		$('#subbtn').removeAttr('disabled');
	}
});


//验证realName不能为空
$('#realname').blur(function(){
	var realName = $(this).val();
	if(realName.length<1) {
		$('#realNameinfo').text('真实姓名不能为空');
		$('#subbtn').attr('disabled','disabled');
	}else{
		$('#realNameinfo').text('');
		$('#subbtn').removeAttr('disabled');
	}
});

//验证电话不能为空
$('#phone').blur(function(){
	var phone = $(this).val().length;
	if(phone!=11){
		$('#phoneinfo').text('电话号码格式错误');
		$('#subbtn').attr('disabled','disabled');
	}else{
		$('#phoneinfo').text('');
		$('#subbtn').removeAttr('disabled');
	}
});

//验证地址不能为空
$('#address').blur(function(){
	var address = $(this).val().length;
	if(address<1){
		$('#addrinfo').text('个人地址不能为空');
		$('#subbtn').attr('disabled','disabled');
	}else{
		$('#addrinfo').text('');
		$('#subbtn').removeAttr('disabled');
	}
});

//提交注册表单
$('#subbtn').click(function(){
	var a = false;
	var b = false;
	var c = false;
	var d = false;
	var e = false;
	if($('#email').val().length>0){
		a = true;
	}
	if($('#password').val().length>0){
		b = true;
	}
	if($('#realname').val().length>0){
		c = true;
	}
	if($('#phone').val().length>0){
		d = true;
	}
	if($('#address').val().length>0){
		e = true;
	}
	if(a&&b&&c&&d&&e){
		$(this).submit();
	}else{
		alert('请将注册信息填写完整');
		return false;
	}
});

//登录提交表单
$('#login').click(function(){
	var a = false;
	var b = false;
	var name = $('#loginEmail1').val();
	var pwd = $('#loginPassword1').val();
	if(name==''){
		$('#loginnameinfo').text('请填写用户名');
		a = false;
	}
	if(name!=''){
		$('#loginnameinfo').text('');
		a = true;
	}
	if(pwd==''){
		$('#loginpwdinfo').text('请填写密码');
		b = false;
	}
	if(pwd!=''){
		$('#loginpwdinfo').text('');
		b = true;
	}
	if(!(a&&b)){
		return false;
	}else{
		$('#loginForm').submit();
//		$.ajax({
//			url:'login.action',
//			data:'email='+name+'&pwd='+pwd+'&time='+new Date(),
//			type:'GET',
//			success:function(data){
//				$('#loginnameinfo').text(data);
//				//alert(data);
//			}
//		});
	}
});


