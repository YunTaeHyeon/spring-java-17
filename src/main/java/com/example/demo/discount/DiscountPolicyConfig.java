package com.example.demo.discount;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountPolicyConfig {

    @Bean
    public DiscountPolicy rateDiscountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy(){
        return new FixDiscountPolicy();
    }
}

//이런식으로 특정 패키지에 모은 다음에 별도의 설정 정보로 만들기도 가능
