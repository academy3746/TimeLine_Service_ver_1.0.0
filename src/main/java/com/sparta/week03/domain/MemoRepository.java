package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // MemoRepository class 는 JpaRepository<> class 를 상속받는다!
    // JpaRepository<Memo, Long>: Memo 클래스에서 Key 값이 Long 타입인 녀석을 가져다가 쓸 것이다!

    List<Memo> findAllByOrderByModifiedAtDesc();
    // findAllByOrderByModifiedAtDesc(): SELECT * FROM MEMOS ORDER BY MODIFIEDAT DESC;
    // 수정한 날짜를 기준으로 내림차순 정렬할 것이다.
    // Spring 은 Framework tool 이기 때문에 유저는 반드시 규정을 준수해야 한다.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

}
