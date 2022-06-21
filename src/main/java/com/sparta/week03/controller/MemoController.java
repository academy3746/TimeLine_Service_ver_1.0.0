package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class MemoController {
    // Final: It is essential type

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        LocalDateTime start = LocalDateTime.of
                (LocalDate.now().minusDays(1), LocalTime.of(0,0,0));
        // Yesterday: Before 24 Hour

        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));
        // Today: Current Time

        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo();
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

}
