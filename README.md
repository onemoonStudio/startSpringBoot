# startSpringBoot

## reference book
[스타트 스프링 부트](http://www.namgarambooks.co.kr/entry/8-%EC%8A%A4%ED%83%80%ED%8A%B8-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8)

## _record
- 진행하면서 정리한 마크다운이 포함되어 있습니다.
- 1회독 이후 2회독 부터 정리하면서 작성할 예정입니다.

## for_record

### ch2 JPA
- entity , entity manager , 영속 컨테스트 (persistence context)
- 스프링 부트의 장점 > 라이브러리 버전에 신경 쓸 필요가 없다.
- 실행이 안된다 -> Data source 설정
- Repository -> CrudRepository -> PagingAndSortingRepository

## ch3 단순 게시물 처리 
1. 쿼리 메소드
1. @Query 를 이용한 JPQL
1. 페이징과 정렬
1. Querydsl 을 이용한 동적 쿼리 

- 조금 더 복잡한 쿼리를 다루기 위해서는 JPA를 대상으로 하는 아래와 같은 개념을 숙지할 필요가 있다.
    - Named Query 
    - JPQL(Java Persistence Query Language )
    - Query dsl
- 위와같은 번거로운 과정을 쿼리메소드로 그나마 줄여줄 수 있다.
- 쿼리라는 용어는 select 에만 해당이 되는 것을 기억하자
    - find...By
    - read...By
    - query...By
    - get...By
    - count...By
- 쿼리메소드
    - find(Repository)Bt(Column_Name)
    - return : Collection<T>
    - [Define Query Methods Docs](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details)
- 페이징 처리 정렬
    - pageable interface
        - PageRequest Class 를 사용하자 
    - sort interface
    - Page<T> 를 잘 활용하자
        - 페이지네이션에 필요한 정보들을 한번에 얻을 수 있다.
- @Query 이용하기
    - 어노테이션 안에 쿼리를 작성하는 것 
        - JPQL 
        - 혹은 순수 데이터 베이스에 맞는 SQL 
    - 실행계획을 잘 알아야 한다.
    - 장점
        - 네이티브 SQL에 대한 작업이 이루어지므로 쿼리 튜닝에 대한 작업이 이루어 질 수 있다.
        - 필요한 칼럼만 추출이 가능하다.
- Querydsl ( Domain Specific Language )
    - QDomain

## ch4 JPA 연관관계 & Thymeleaf
- Optional<T>
- @OneToOne , @OneToMany , @ManyToOne , @ManyToMany
- Repository 작성
- JoinTable , JoinColumn
- 등록과 cascade , 영속성 전이
- 첨부파일 수정과 @Modifying , @Transactional
    - Transactional 은 기본적으로 rollback 처리를 한다 이를 없애려면 commit 
- mappedBy
- 지연 로딩 , 즉시 로딩
- 인덱스 처리 
 
