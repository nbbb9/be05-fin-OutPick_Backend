package com.encore.outpick_backend.sse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Tag(name = "SseEmitters" , description = "emitter객체 리스트와 이벤트를 등록하는 곳")
public class SseEmitters {
    
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add(SseEmitter emitter){
        this.emitters.add(emitter);

        log.info("new emitter added : {}", emitter);
        log.info("emitter list size : {}", emitters.size());

        emitter.onCompletion(() -> {
            log.info("onCompletion Callback");
            this.emitters.remove(emitter);
        });

        emitter.onTimeout(() ->{
            log.info("onTimeout callback");
            emitter.complete();
        });

        return emitter;

    }

    //건의문 해결방안 작성시 매장에 알림
    public void proposal_solution(int shop_id, int proposal_id){
        String message = "매장 ID : " + shop_id + "건의문 ID : " + proposal_id;
        emitters.forEach(emitter -> {
            try{
                emitter.send(SseEmitter.event()
                        .name("proposal_solution")
                        .data(message));
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        });
    }

}
