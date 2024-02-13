package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {//추상 클래스 : 공유하는 클래스

    @CreatedDate
    @Column(updatable = false)//추가0 수정 x
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false) //추가x, 수정 0
    private LocalDateTime modifiedAt;

}
