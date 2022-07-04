package com.farawaybr.gatewayapi.service;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@Retention(RUNTIME)
@Target({ TYPE,  METHOD })
@InterceptorBinding
public @interface OptionalEmpty404NotFoundJoinPointCut {

}
