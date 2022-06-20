package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public class MemoRequestDto {
    // Final: It is essential type

    private final String username;
    private final String contents;
}
