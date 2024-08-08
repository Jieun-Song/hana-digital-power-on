package com.brms.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String mId;
    private String mPw;
    private String mName;

    public Member(String mId, String mPw, String mName) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
    }
}
