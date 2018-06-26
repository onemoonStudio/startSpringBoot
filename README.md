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
    