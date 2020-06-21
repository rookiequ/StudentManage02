package com.yctu.student.constant;

/**
 * @ClassName ControllerPath
 * @Description controller方法请求路径
 * @Author qlq
 * @Date 2020-06-17 13:17
 */
public class ControllerPath {


    /** 获取所有学生信息请求 */
    public static final String GET_ALL_STUDENT = "student/get-all-students";

    /** 获取所有老师信息请求 */
    public static final String GET_ALL_TEACHER = "teacher/get-all-teachers";

    /** 管理员获取所有课程信息请求 */
    public static final String GET_ALL_COURSE = "course/admin-get-all-courses";

    /**获取老师用户所有的课程**/
    public static final String TEACHER_GET_ALL_COURSE = "course/get-all-course-by-teacher";

    /** 学生获取已经选课程列表的请求 */
    public static final String GET_SELECTED_COURSE = "course/student-get-selected-courses";

    /**获取老师用户所有的课程**/
    public static final String GET_ALL_COURSE_SECOND = "course/get-all-courses-teacher";

    /** 跳转到管理员修改密码页面 */
    public static final String ADMIN_MODIFY_PASSWORD_PAGE = "admin/modify-password-page";

    /** 跳转到老师修改密码页面 */
    public static final String TEACHER_MODIFY_PASSWORD_PAGE = "teacher/modify-password-page";

    /** 跳转到学生修改密码页面 */
    public static final String STUDENT_MODIFY_PASSWORD_PAGE = "student/modify-password-page";

    /** 跳转到学生选课页面 */
    public static final String STUDENT_GET_ALL_COURSE_PAGE = "course/student-get-all-courses";
}
