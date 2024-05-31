package com.encore.outpick_backend.sse;

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

        log.info("new emitter added : ", emitter);
        log.info("emitter list size : ", emitters.size());

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

}
