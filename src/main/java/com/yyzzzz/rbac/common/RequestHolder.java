package com.yyzzzz.rbac.common;

import com.yyzzzz.rbac.entity.SysUserEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yyzzzz
 * @Date 2020/4/26 22:01
 */
public class RequestHolder {

    private static final ThreadLocal<SysUserEntity> userHolder = new ThreadLocal<>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();

    public static void add(SysUserEntity user) {
        userHolder.set(user);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static SysUserEntity getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }


}
