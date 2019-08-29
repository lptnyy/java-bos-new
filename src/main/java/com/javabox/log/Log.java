package com.javabox.log;

/**
 * 统一日志处理
 */
public interface Log {
    void info(String message);
    void info(Exception e);
    void debug(String message);
    void debug(Exception e);
    void warr(String message);
    void warr(Exception e);
    void error(String message);
    void error(Exception e);
}
