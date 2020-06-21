package com.yctu.student.constant;

/**
 * @ClassName ResultCode
 * @Description 业务返回值
 * @Author qlq
 * @Date 2020-06-16 21:56
 */
public class ResultCode {


    /** 成功*/
    public static final int SUCCESS = 1;
    public static final String MSG_SUCCESS = "success";



    //业务中细分的code 1000-1999

    /** 参数错误 */
    public static final int PARAMETER_INVALID = 1000;
    public static final String MSG_PARAMETER_INVALID = "parameter_invalid";

    /** 没有此账号 */
    public static final int NO_SUCH_ACCOUNT = 1001;
    public static final String MSG_NO_SUCH_ACCOUNT = "no_such_account";

    /** 没有此学生 */
    public static final int NO_SUCH_STUDENT = 1002;
    public static final String MSG_NO_SUCH_STUDENT = "no_such_student";

    /** 该学生信息已存在 */
    public static final int STUDENT_ALREADY_EXIST = 1003;
    public static final String MSG_STUDENT_ALREADY_EXIST = "student_already_exist";


    /** 没有该老师信息 */
    public static final int NO_SUCH_TEACHER = 1004;
    public static final String MSG_NO_SUCH_TEACHER= "no_such_teacher";

    /** 老师信息已存在 */
    public static final int TEACHER_ALREADY_EXIST = 1005;
    public static final String MSG_TEACHER_ALREADY_EXIST= "teacher_already_exist";



    /** 没有此管理员 */
    public static final int NO_SUCH_ADMIN = 1006;
    public static final String  MSG_NO_SUCH_ADMIN = "no_such_admin";

    /** 课程已经存在 */
    public static final int COURSE_ALREADY_EXIST = 1007;
    public static final String  MSG_COURSE_ALREADY_EXIST = "course_already_exist";

    /** 没有此课程 */
    public static final int NO_SUCH_COURSE = 1008;
    public static final String MSG_NO_SUCH_COURSE = "no_such_course";

    /** 存在学生选择了该课程 */
    public static final int EXIST_STUDENT_SELECT_COURSE = 1009;
    public static final String  MSG_EXIST_STUDENT_SELECT_COURSE = "exist_student_select_this_course";

    /** 该学生没有选择改课程 */
    public static final int STUDENT_NOT_SELECT_COURSE = 1010;
    public static final String  MSG_STUDENT_NOT_SELECT_COURSE = "student_not_select_this_course";

    /** 该学生存在已选的课程 */
    public static final int STUDENT_EXIST_SELECTED_COURSE = 1011;
    public static final String MSG_STUDENT_EXIST_SELECTED_COURSE = "student_exist_selected_course";

    /** 该学生已经选过该课程了 */
    public static final int STUDENT_ALREADY_SELECT_THIS_COURSE = 1012;
    public static final String MSG_STUDENT_ALREADY_SELECT_THIS_COURSE = "student_already_select_this_course";

    /** 密码错误 */
    public static final int PASSWORD_ERROR = 1013;
    public static final String MSG_PASSWORD_ERROR = "password_error";

    /** 没有选择用户类型 */
    public static final int MUST_INPUT_ACCOUNT_PASSWORD_USERTYPE = 1014;
    public static final String  MSG_MUST_INPUT_ACCOUNT_PASSWORD_USERTYPE = "account_password_type_not_null";

    /** 该老师存在已经发布的课程 */
    public static final  int EXIST_PUBLISHED_COURSE = 1015;
    public static final String MSG_EXIST_PUBLISHED_COURSE = "exist_already_published_courses";

    /** 两次密码输入不相同 */
    public static final int TWO_PASSWORD_NOT_MATCH = 1016;
    public static final String MSG_TWO_PASSWORD_NOT_MATCH = "two_password_not_match";

    //一些可能共性的异常 9000-9999

    /** 系统异常 */
    public static final int ERROR_SYSTEM_EXCEPTION = 9000;
    public static final String MSG_ERROR_SYSTEM_EXCEPTION = "error_system_exception";


}
