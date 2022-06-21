package com.sparta.week03.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
// Entity 가 자동으로 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)
// 생성시간을 자동으로 update!
@Getter
// Getter 가 빠지면 타임스탬프는 절대! 작동하지 않는다.
// 특히 이 위에 3개 영역은 반드시 기억해둘 것!

public abstract class TimeStamped {

    @CreatedDate
    private LocalDateTime createAt;
    // 생성시간

    @LastModifiedDate
    private LocalDateTime modifiedAt;
    // 수정시간

}
