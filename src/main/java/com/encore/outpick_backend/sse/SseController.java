package com.encore.outpick_backend.sse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@RestController
@Tag(name = "SSE", description = "Client에게 직접 connection 요청과 이벤트 요청을 받고 통신 객체인 SeeEmitter를 생성")
public class SseController {
    
    private final SseEmitters sseEmitters;

    public SseController(SseEmitters sseEmitters){
        this.sseEmitters = sseEmitters;
    }

    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect() {
        SseEmitter emitter = new SseEmitter(60 * 1000L);

        sseEmitters.add(emitter);   // add 메서드 실행

        try {
            emitter.send(SseEmitter.event()
                    .name("connect")
                    .data("connected!")
            );
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }
        return ResponseEntity.ok(emitter);
    }

    public ResponseEntity<String> proposal_solution(int shop_id, int proposal_id){
        log.info("proposal_solution Start");
        sseEmitters.proposal_solution(shop_id, proposal_id);
        return ResponseEntity.ok().build();
    }

}