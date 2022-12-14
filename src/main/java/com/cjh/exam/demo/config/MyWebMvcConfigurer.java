package com.cjh.exam.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cjh.exam.demo.interceptor.BeforeActionInterceptor;
import com.cjh.exam.demo.interceptor.NeedLoginInterceptor;
import com.cjh.exam.demo.service.ArticleService;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{

	private BeforeActionInterceptor beforeActionInterceptor;
	private NeedLoginInterceptor needLoginInterceptor;
	
	@Autowired
	public MyWebMvcConfigurer(BeforeActionInterceptor beforeActionInterceptor,NeedLoginInterceptor needLoginInterceptor) {
		this.beforeActionInterceptor = beforeActionInterceptor;
		this.needLoginInterceptor=needLoginInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**").excludePathPatterns("/error");
	
		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/write").addPathPatterns("/usr/article/doAdd").addPathPatterns("/usr/article/doDelete").addPathPatterns("/usr/article/modify").addPathPatterns("/usr/article/doModify");
	}

	
	
}
