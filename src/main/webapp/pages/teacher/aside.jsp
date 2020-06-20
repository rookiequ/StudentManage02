
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/6/18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user1.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${teacherAccount.name}</p>
                <%--<p><security:authentication property="principal.username"></security:authentication></p>--%>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/pages/teacher/main.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview"><a href="${pageContext.request.contextPath}/course/get-all-course-by-teacher?teacher_id=${teacherAccount.id}"> <i class="fa fa-pie-chart"></i>
                <span>管理学生</span>
            </a></li>

            <li class="treeview"><a href="${pageContext.request.contextPath}/course/get-all-courses-teacher?teacher_id=${teacherAccount.id}"> <i class="fa fa-laptop"></i>
                <span>管理课程</span>
            </a></li>


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>