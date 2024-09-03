package com.pae.server.concern.domain;

import com.pae.server.common.enums.BaseStatus;
import com.pae.server.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Concern")
@Table(name = "ConcernBoard")
public class ConcernBoard extends Board {
    public ConcernBoard(String title, String content, BaseStatus baseStatus) {
        super(title, content, baseStatus);
    }
    public void update(String title, String content, BaseStatus baseStatus) {
        this.title = title;
        this.content = content;
        this.baseStatus = baseStatus;
    }

}
