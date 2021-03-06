<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/6/16
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>学生管理系统 | 登录</title>


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">


        <a href="#"><b>学生</b>信息管理系统</a>


    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录系统</p>

        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="账号" id="account" name="account" value="">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码" id="password" name="password" value="">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <%--<div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label><input type="checkbox"> 记住 下次自动登录</label>
                    </div>
                </div>--%>


                <!-- /.col -->
                <div class="col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" onclick="return checkLogin()">登录</button>
                </div>
                <div class="col-xs-6">
                    <button type="reset" class="btn btn-primary btn-block btn-flat">重写</button>
                </div>
                <!-- /.col -->
            </div>
            <br>
            <div class="row">
                <label class="radio-inline text-center">
                    <input type="radio" name="userType" id="optionsRadios1" value="admin" checked> 管理员
                </label>
                <label class="radio-inline">
                    <input type="radio" name="userType" id="optionsRadios2"  value="teacher"> 老师
                </label>
                <label class="radio-inline">
                    <input type="radio" name="userType" id="optionsRadios3"  value="student"> 学生
                </label>
            </div>

        </form>




        <%--<div class="social-auth-links text-center">
            <p>- 或者 -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-qq"></i> 腾讯QQ用户登录</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 微信用户登录</a>
        </div>--%>
        <!-- /.social-auth-links -->

        <%--<a href="#">忘记密码</a><br>
        <a href="all-admin-register.html" class="text-center">新用户注册</a>--%>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->

<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript">
    if (${result.code==1000}){
        alert("账号或密码错误！");
    }else if (${result.code==1014}) {
        alert("账号，密码和用户类型不能为空！");
    }
</script>
<script>



    $(function(){
        $(".close").click(function(){
            $("#result").alert();
        });
    });



    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>

</html>
