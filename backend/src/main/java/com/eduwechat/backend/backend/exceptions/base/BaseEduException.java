package com.eduwechat.backend.backend.exceptions.base;

/**
 * 所有异常基类
 */
public class BaseEduException extends Exception {
    public BaseEduException() {
    }

    public BaseEduException(String message) {
        super(message);
    }


    /**
     * 获取栈追踪
     * @return String StackTrace
     */
    public String getExceptionDetail() {
        StringBuilder stringBuffer = new StringBuilder(this.toString() + "\n");
        StackTraceElement[] messages = this.getStackTrace();

        for (StackTraceElement message : messages) {
            stringBuffer.append("\t").append(message.toString()).append("\n");
        }

        return stringBuffer.toString();
    }
}
