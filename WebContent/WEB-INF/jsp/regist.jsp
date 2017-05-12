<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <title>校园二手交易平台-注册</title>
    <style>
        body {
            background: url("${pageContext.request.contextPath}/image/regist-bg.jpg");
            background-repeat: space;
            background-size: 100%;
            background-size: cover;
            background-position: center;
        }

        #registForm {
            border: 1px;
            border-radius: 25px;
            padding: 30px;
            background-color: #E5B15F;
            opacity: 0.9;
        }
    </style>

    <script>
        function permitted() {
            //获得CheckBox的值
            var protocol = $("#protocol").is(':checked');
            //alert(protocol);
            if (protocol) {
                //alert('ok');
                $("#registBtn").removeAttr('disabled');
            } else {
                $("#registBtn").attr("disabled", 'disabled');
            }
        }

        function regist() {
            var pass = $('#exampleInputPassword1').val();
            var repass = $('#exampleInputRepeatPassword1').val();
            if (pass != repass) {
                alert('两个输入密码不一致，请重新输入');
                return;
            }
            $('form').submit();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 150px;">
        <div class="col-md-5 col-md-offset-7" id="registForm">
            <form role="form" action="${pageContext.request.contextPath}/users/regist.action" method="post">

                <div class="form-group">
                    <label for="exampleInputEmail1">Email 地址</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" required>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="exampleInputPassword1">密码</label>
                            <input type="password" name="pwd" class="form-control" id="exampleInputPassword1"
                                   placeholder="Password" required>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="exampleInputRepeatPassword1">确认密码</label>
                            <input type="password" class="form-control" id="exampleInputRepeatPassword1"
                                   placeholder="Repeat password" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="realname">姓名</label>
                            <input name="realName" type="text" class="form-control" id="realname"
                                   placeholder="realname">
                            <span id="realNameinfo" style="color:red;"></span>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="inlineRadio1">性别</label>
                        <div class="radio">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="inlineRadio1" value="男" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
                            </label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="address">地址</label>
                            <input name="address" type="text" class="form-control" id="address" placeholder="address"
                                   required>
                            <span id="addrinfo" style="color:red;"></span>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="phone">电话</label>
                            <input name="phone" type="text" class="form-control" id="phone" placeholder="phone">
                            <span id="phoneinfo" style="color:red;"></span>
                        </div>
                    </div>
                </div>

                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="protocol" onclick="permitted()"> <a
                            href="protocol.html">我已阅读并同意相关协议</a>
                    </label>
                </div>
                <button type="submit" id="registBtn" class="btn btn-default btn-success" disabled="disabled"
                        onclick="regist()">注  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册
                </button>
            </form>
        </div>
    </div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>