package com.study.common.base.error.codes;

public class ErrorCodes {


    public static final ErrorCode SYS_ERROR_401 = new ErrorCode(401, "会话失效或没有登录!");
    public static final ErrorCode SYS_ERROR_403 = new ErrorCode(403, "权限不足!");
    public static final ErrorCode SYS_ERROR_404 = new ErrorCode(404, "资源不存在!");
    public static final ErrorCode SYS_ERROR_500 = new ErrorCode(500, "系统异常!");

    /**
     * 操作异常
     */
    public static final ErrorCode OPERATE_SUCCESS = new ErrorCode(200, "操作成功!");
    public static final ErrorCode OPERATE_FAILED = new ErrorCode(300, "操作失败!");
    public static final ErrorCode OPERATE_TIMEOUT = new ErrorCode(408, "操作超时!");


    /**
     * 文件异常10201-10300
     */
    public static final ErrorCode FILE_TYPE_NOT_SUPPORT = new ErrorCode(10201, "文件类型不支持!");
    public static final ErrorCode FILE_UPLOAD_FAILED = new ErrorCode(10202, "文件上传失败!");
    public static final ErrorCode FILE_EXCEED_MAX_SIZE = new ErrorCode(10203, "文件超过最大值({0})!");

    /**
     * 账户异常10301-10400
     */
    public static final ErrorCode ACCOUNT_LOCKED = new ErrorCode(10301, "账户被锁定!");
    public static final ErrorCode ACCOUNT_EXIST = new ErrorCode(10302, "账户已存在!");
    public static final ErrorCode ACCOUNT_NOT_EXIST = new ErrorCode(10303, "账户不存在!");
    public static final ErrorCode ACCOUNT_USERNAME_OR_PASSWORD_ERROR = new ErrorCode(10304, "账户名或者密码错误!");
    public static final ErrorCode ACCOUNT_PASSWORD_ERROR = new ErrorCode(10305, "密码错误!");
    public static final ErrorCode ACCOUNT_OLD_PASSWORD_ERROR = new ErrorCode(10306, "原始密码错误!");
    public static final ErrorCode ACCOUNT_TWO_PASSWORD_NOT_EQUAL = new ErrorCode(10307, "两次密码输入不一致!");
    public static final ErrorCode ACCOUNT_PASSWORD_NOT_CHANGE = new ErrorCode(10308, "原密码未变更!");
    /**
     * 参数异常10001-10100
     */
    public static final ErrorCode ARGS_EXIST = new ErrorCode(10001, "{0} 已存在!");
    public static final ErrorCode ARGS_NOT_EXIST = new ErrorCode(10002, "{0} 不存在!");
    public static final ErrorCode ARGS_NOT_LEGAL = new ErrorCode(10003, "{0} 不合法!");
    public static final ErrorCode ARGS_NAME_EXIST = new ErrorCode(10004, "名称已存在!");
    public static final ErrorCode ARGS_CODE_EXIST = new ErrorCode(10005, "编码已存在!");
    public static final ErrorCode ARGS_NAME_NOT_EMPTY = new ErrorCode(10006, "名称不能为空!");
    public static final ErrorCode ARGS_CODE_NOT_EMPTY = new ErrorCode(10007, "编码不能为空!");
}
