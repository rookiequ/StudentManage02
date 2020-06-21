<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/6/18
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生详情信息</title>
    <meta name="description" content="rookiequ_AdminLTE2">
    <meta name="keywords" content="rookiequ_AdminLTE2">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                课程管理 <small>课程详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/teacher/main.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/course/get-all-courses-teacher?teacher_id=${teacherAccount.id}">课程列表</a></li>
                <li class="active">学生详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <form action="${pageContext.request.contextPath}/course/get-course-by-id-teacher"
              method="post">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">课程信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">课程编号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="number"
                                   placeholder="课程编号" readonly ="readonly" value="${course.number}">
                        </div>
                        <div class="col-md-2 title">课程名</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="name"
                                   placeholder="课程名" readonly ="readonly" value="${course.name}">
                        </div>
                        <div class="col-md-2 title">课程类型</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="tag"
                                   placeholder="tag" readonly ="readonly" value="${course.tag==1?'必修':'选修'}">
                        </div>
                        <div class="col-md-2 title">学分</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="credit"
                                   placeholder="学分" readonly ="readonly" value="${course.credit}">
                        </div>

                        <div class="col-md-2 title">教师编号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="teacherId"
                                   placeholder="教师编号" readonly ="readonly" value="${course.teacherId}">
                        </div>

                        <div class="col-md-2 title">教师姓名</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="college"
                                   placeholder="教师姓名" readonly ="readonly" value="${course.teacherDO.name}">
                        </div>
                        <div class="col-md-4 data">
                            <input type="hidden" class="form-control" name="id"
                                   placeholder="id" value="${course.id}">
                        </div>
                        <%--<!--
                        <div class="col-md-2 title">教师姓名</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="college"
                                   placeholder="教师姓名" readonly ="readonly" value="${course.teacherDO.name}">
                        </div>

                        <div class="col-md-2 title">电话</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="phone"
                                   placeholder="学生电话" readonly ="readonly" value="${student.phone}">
                        </div>
                        <div class="col-md-2 title">出生日期</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="birthday"
                                   placeholder="出生日期" readonly ="readonly" value="${student.birthday}">
                        </div>
                        <div class="col-md-2 title">入学日期</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="entryTime"
                                   placeholder="入学日期" readonly ="readonly" value="${student.entryTime}">
                        </div>
                        <div class="col-md-2 data">
                            <input type="hidden" class="form-control" name="password"
                                   placeholder="学生密码" readonly ="readonly" value="${student.password}">
                        </div>
                        <div class="col-md-2 data">
                            <input type="hidden" class="form-control" name="id"
                                   placeholder="id" value="${student.id}">
                        </div>
                        --!>--%>
                    </div>
                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">修改</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                <!--工具栏/-->
            </section>
            <!-- 正文区域 /-->
        </form>
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- 底部导航 /-->

</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });
    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
    $(document).ready(function() {
        $('#datepicker-a3').datetimepicker({
            format : "yyyy-mm-dd hh:ii",
            autoclose : true,
            todayBtn : true,
            language : "zh-CN"
        });
    });
    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("order-manage");
        $("#datepicker-a3").datetimepicker({
            format : "yyyy-mm-dd hh:ii",
        });
    });
</script>


</body>

</html>

