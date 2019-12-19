package com.bailiban.day3.spring_annotation.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 配置多例bean
public class User {
}
