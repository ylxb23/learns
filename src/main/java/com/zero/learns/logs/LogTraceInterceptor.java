package com.zero.learns.logs;

import com.github.f4b6a3.ulid.UlidCreator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zero
 * @since 2025/2/13 14:49
 */
public class LogTraceInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(LogTraceInterceptor.class);
    private final static String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tid;
        if(StringUtils.isNotBlank(request.getHeader(TRACE_ID))) {
            tid = request.getHeader(TRACE_ID);
        } else {
            tid = UlidCreator.getUlid().toLowerCase();
        }
        MDC.put(TRACE_ID, tid);
        logger.debug("intercept TRACE_ID: {}", tid);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        logger.debug("remove TRACE_ID: {}", MDC.get(TRACE_ID));
        MDC.remove(TRACE_ID);
    }
}
