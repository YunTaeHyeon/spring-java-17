package com.example.demo.singleton;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 컨테이너 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new
                AnnotationConfigApplicationContext(AppConfig.class);

        //AnnotationConfigApplicationContext에 파라미터로 넘긴 값은 스프링 빈이 됨.
        //AppConfig도 스프링 빈이 됨
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70
        //class hello.core.AppConfig 원래라면 이랬을텐데 위처럼 됨
        //AppConfig 클래스 상속받은 임의의 다른 클래스 생성 후 그 클래스 스프링 빈으로

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //getBean의 name에 MemberService등 이름 틀리면 오류 나옴
        //싱글톤은 무상태로 설계해야 함에 주의(지역변수 스레드로컬, 파라미터 등 사용)

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
