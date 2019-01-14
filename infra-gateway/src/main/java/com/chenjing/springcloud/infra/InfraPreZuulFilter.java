package com.chenjing.springcloud.infra;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * description：InfraPreZuulFilter
 *
 * @author：chenjing
 * @version:1.0
 */
@Component
public class InfraPreZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = ctx.getRequest();

        System.out.println(servletRequest.getRequestURL().toString());

        return null;
    }
}
