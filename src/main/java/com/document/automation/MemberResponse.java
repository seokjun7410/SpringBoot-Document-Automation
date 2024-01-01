package com.document.automation;


public record MemberResponse(
        Long id,
        String email,
        String pw,
        String name
){
    public static MemberResponse of(Member member) {
        return new MemberResponse(
                member.getId().getValue(),
                member.getEmail(),
                member.getPw(),
                member.getName());
    }
}
