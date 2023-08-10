package com.neibus.model.member;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlockedMember {

    public enum Status {
        BLOCKED, ACTIVATED
    }

    private Integer id;
    private Integer memberIdx;
    private Status status;
    private LocalDateTime blockedAt;
    private LocalDateTime createdAt;
    private LocalDateTime restoredAt;

    public BlockedMember(int memberIdx) {
        this.memberIdx = memberIdx;
        this.status = Status.BLOCKED;
        this.blockedAt = LocalDateTime.now();
    }
}
