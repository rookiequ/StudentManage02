<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/6/18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 页面头部 -->
<header class="main-header">
    <!-- Logo -->
    <a href="all-admin-index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>教师</b></span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>教师</b>后台管理</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

                <li class="dropdown user user-menu"><a href="#"
                                                       class="dropdown-toggle" data-toggle="dropdown"> <img
                        src="${pageContext.request.contextPath}/img/user1.jpg"
                        class="user-image" alt="User Image"> <span class="hidden-xs">${teacherAccount.name}
							<%--<security:authentication property="principal.username"></security:authentication>--%>
					</span></a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header"><img
                                src="${pageContext.request.contextPath}/img/user1.jpg"
                                class="img-circle" alt="User Image"></li>

                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="${pageContext.request.contextPath}/teacher/modify-password-page" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/user/logout"
                                   class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
<!-- 页面头部 /-->
© 2020 GitHub, Inc.
