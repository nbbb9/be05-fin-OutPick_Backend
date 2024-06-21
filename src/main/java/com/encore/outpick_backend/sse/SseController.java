package com.encore.outpick_backend.sse;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Slf4j
@RestController
@Tag(name = "SSE", description = "Client에게 직접 connection 요청과 이벤트 요청을 받고 통신 객체인 SeeEmitter를 생성")
public class SseController {
    
    private final SseEmitters sseEmitters;

    public SseController(SseEmitters sseEmitters){
        this.sseEmitters = sseEmitters;
    }

    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect(@RequestParam int shop_id) {
        SseEmitter emitter = new SseEmitter(3600 * 1000L);

        sseEmitters.add(shop_id,emitter);// add 메서드 실행
        log.info("shop_id : {} " , shop_id);

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
    }//proposal_solution end

    public ResponseEntity<String> product_discount(int shop_id, int product_id){
        log.info("product_discount Start");
        sseEmitters.product_discount(shop_id, product_id);
        return ResponseEntity.ok().build();
    }//product_discount end

    public ResponseEntity<String> stock_request_approval(int shop_id, int stock_request_id){
        log.info("stock_request_approval Start");
        sseEmitters.stock_request_approval(shop_id, stock_request_id);
        return ResponseEntity.ok().build();
    }//stock_request_approval end

    public ResponseEntity<String> stock_request_feedback(int shop_id, int stock_request_id){
        log.info("stock_request_feedback Start");
        sseEmitters.stock_request_feedback(shop_id, stock_request_id);
        return ResponseEntity.ok().build();
    }//stock_request_approval end
}