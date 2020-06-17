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

    //一些可能共性的异常 9000-9999

    /** 系统异常 */
    public static final int ERROR_SYSTEM_EXCEPTION = 9000;
    public static final String MSG_ERROR_SYSTEM_EXCEPTION = "error_system_exception";



}
