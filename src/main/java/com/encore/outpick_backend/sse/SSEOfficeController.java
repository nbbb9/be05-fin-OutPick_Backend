package com.encore.outpick_backend.sse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Slf4j
@RestController
@Tag(name = "SSEOffice", description = "Client에게 직접 connection 요청과 이벤트 요청을 받고 통신 객체인 SeeEmitter를 생성")
public class SSEOfficeController {

    private final SSEOfficeEmitters sseOfficeEmitters;

    public SSEOfficeController(SSEOfficeEmitters sseOfficeEmitters){
        this.sseOfficeEmitters = sseOfficeEmitters;
    }

    @GetMapping(value = "/connect/officesse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect(@RequestParam int employee_id) {
        SseEmitter emitter = new SseEmitter(3600 * 1000L);

        sseOfficeEmitters.add(employee_id,emitter);// add 메서드 실행
        log.info("employee_id : {} " , employee_id);

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

    public ResponseEntity<String> add_stock_request(int shop_id, int employee_id){
        log.info("add_stock_request Start");
        sseOfficeEmitters.add_stock_request(shop_id, employee_id);
        return ResponseEntity.ok().build();
    }//proposal_solution end

    public ResponseEntity<String> add_proposal(int shop_id, int employee_id){
        log.info("add_proposal Start");
        sseOfficeEmitters.add_proposal(shop_id, employee_id);
        return ResponseEntity.ok().build();
    }//proposal_solution end

}
