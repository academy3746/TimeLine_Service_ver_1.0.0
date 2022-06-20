package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
// Hey, Java! This page is service tab!
@RequiredArgsConstructor
// Final 로 선언하는 게 맞다!

public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    // It must have updated on DB Server!
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                // SELECT * FROM MEMOS WHERE ID LIKE 'ID';
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다!")
        );
        memo.update(requestDto);
        return memo.getId();
    }

}
