package com.brms.book;

import com.brms.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String bNum;
    private String bTitle;
    private boolean bCanRental;
    private Member bMember;

    public Book(String bNum, String bTitle, boolean bCanRental, Member bMember) {
        this.bNum = bNum;
        this.bTitle = bTitle;
        this.bCanRental = bCanRental;
        this.bMember = bMember;
    }
}
