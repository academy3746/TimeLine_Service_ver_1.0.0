package com.sparta.week03.domain;

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

public abstract class TimeStamped {

    @CreatedDate
    private LocalDateTime createAt;
    // 생성시간

    @LastModifiedDate
    private LocalDateTime modifiedAt;
    // 수정시간

}
