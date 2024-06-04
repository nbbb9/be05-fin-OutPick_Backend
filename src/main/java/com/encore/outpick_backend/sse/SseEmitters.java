package com.encore.outpick_backend.sse;

import java.io.IOException;
import java.lang.IllegalStateException;
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
        
        SseDTO dto = new SseDTO();
        dto.setShop_id(shop_id);
        dto.setProposal_id(proposal_id);

        log.info("emitter 검증 전");

        emitters.removeIf(emitter -> {
            try {
                emitter.send(SseEmitter.event());
                return false; // 보내기 성공했으므로 유효한 SseEmitter
            } catch (IllegalStateException e) {
                return true; // 보내기 실패했으므로 유효하지 않은 SseEmitter
            } catch (IOException e) {
                return true;
            }
        });

        log.info("emitter 검증 후");

        emitters.forEach(emitter -> {
            try{
                emitter.send(SseEmitter.event()
                        .name("proposal_solution")
                        .data(dto));
            }catch(IOException e){
                emitter.complete();
                log.error("error");
            }
        });

        log.info("emitter 이벤트 보내기 끝");
    }

}
