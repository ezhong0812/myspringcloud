package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;


/**
 * Created by Jason on 18/4/17.
 */
public class TestFilter extends ZuulFilter {
    @Value("${server.port}")
    private String port;
    private final Logger logger = LoggerFactory.getLogger(TestFilter.class);
    @Override
    public String filterType() {
        return "pre";

    }

    @Override
    public int filterOrder() {
//        return 0;
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        logger.info("--->>> TokenFilter {},{}, {}, {}",
                request.getMethod(),
                request.getRequestURL().toString(),
                context.getRouteHost(),
                context.get(SERVICE_ID_KEY));
        return null;
    }
}
