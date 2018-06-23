# 프로젝트를 위한 준비

## Bean 테스트하기
스프링부트가 정상적으로 작동 한다면 간단한 MVC 컨트롤러를 빈으로 추가해서 정상적으로 동작하는지 살펴 보자 
- SampleController 생성
    - @RestController 어노테이션을 이용해서 스프링의 빈으로 등록되도록 한다.
    - 기존 스프링에는 <component-scan> 등 추가작업이 필요했지만 부트는 자동으로 처리가 된다.
    - 단 기본 패키지가 아닌 패키지에서 사용할 경우에는 @ComponentScan 어노테이션을 사용해야 한다.


## Lombok 라이브러리?
- Getter/Setter 를 자동으로 추가된 상태로 컴파일해주는 라이브러리
- 다양한 어노테이션 지원
    - @Data
        - getter setter equals hashCode toString defaultConstructor 
        - 위의 메서드들이 자동으로 생성된다.
    - @Getter/Setter
    - @ToString
    - @Cleanup 
        - 자동으로 close() 메소드를 호출하는 역할
- 단 ORM 관점에서 봤을 때 ToString 은 조심해야 한다.
    - 부모 객체 자식 객체 사이에서 toString으로 StackOverflow 가 발생할 수 있기 때문

## Tomcat 
스프링 부트는 내장된 톰캣을 이용하기 때문에 별도의 서버 세팅을 하지 않고도 프로젝트를 바로 진행할 수 있다.

## Test
또한 스프링부트는 테스트 환경을 미리 갖추고 있다는 점이다. 
- 테스트클래스에 @WebMvcTest 어노테이션을 추가해서 특정 컨트롤러를 지정해준다.
    - @Controller , @Component  , @ControllerAdvice 등
- org.springframework.test.web.servlet.MockMvc 객체를 사용해야 한다.
    - perform()


