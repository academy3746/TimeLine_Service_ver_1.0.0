package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // MemoRepository class 는 JpaRepository<> class 를 상속받는다!
    // JpaRepository<Memo, Long>: Memo 클래스에서 Key 값이 Long 타입인 녀석을 가져다가 쓸 것이다!

    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    // findAllByOrderByModifiedAtDesc(): SELECT * FROM MEMOS ORDER BY MODIFIEDAT DESC;
    // + find All ByModifiedAt Between OrderBy ModifiedAt Desc(): Time between yesterday and today
    // 수정한 날짜를 기준으로 내림차순 정렬할 것이다.
    // Spring 은 Framework tool 이기 때문에 유저는 반드시 규정을 준수해야 한다.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    // LocalDateTime: 시작(start)과 끝(end)을 지정해줌으로서 일종의 스코프를 형성

}
