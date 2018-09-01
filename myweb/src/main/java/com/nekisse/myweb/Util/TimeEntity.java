package com.nekisse.myweb.Util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class TimeEntity {

    @CreatedDate
    private LocalDate createDate;

    @LastModifiedDate
    private LocalDate updateDate;

    @Override
    public String toString() {
        return "TimeSuperEntity{" +
                "createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }


}
