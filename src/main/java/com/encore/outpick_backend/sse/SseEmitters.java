package com.encore.outpick_backend.sse;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private final Map<Integer, SseEmitter> emitters_2 = new HashMap<Integer, SseEmitter>();

    public SseEmitter add(int shop_id,SseEmitter emitter){
        this.emitters.add(emitter);
        this.emitters_2.put(shop_id, emitter);

        log.info("new emitter added : {}", emitter);
        log.info("emitter list size : {}", emitters.size());

        log.info("emitter_2 map size : {}", emitters_2.size());

        if(!emitters_2.containsKey(shop_id)){
            emitters_2.remove(shop_id);
            emitters_2.put(shop_id, emitter);
            log.info("기존꺼 삭제, 새로 추가  : {}", emitter);
        }

        emitter.onCompletion(() -> {
            log.info("onCompletion Callback");
            this.emitters.remove(emitter);
            int id = findKeyByValue(emitters_2, emitter);
            this.emitters_2.remove(id);
        });

        emitter.onTimeout(() ->{
            log.info("onTimeout callback");
            emitter.complete();
        });

        return emitter;

    }

    // value를 통한 key찾기
    public static <K, V> K findKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // 값이 없을 경우 null 반환
    }

    //건의문 해결방안 작성시 매장에 알림
    public void proposal_solution(int shop_id, int proposal_id){
        
        SseDTO dto = new SseDTO();
        dto.setShop_id(shop_id);
        dto.setProposal_id(proposal_id);

        log.info("emitter 검증 전");

//        emitters.removeIf(emitter -> {
//            try {
//                emitter.send(SseEmitter.event());
//                return false; // 보내기 성공했으므로 유효한 SseEmitter
//            } catch (IllegalStateException e) {
//                return true; // 보내기 실패했으므로 유효하지 않은 SseEmitter
//            } catch (IOException e) {
//                return true;
//            }
//        });

        log.info("emitter 검증 후");

//        emitters.forEach(emitter -> {
//            try{
//                emitter.send(SseEmitter.event()
//                        .name("proposal_solution")
//                        .data(dto));
//            }catch(IOException e){
//                emitter.complete();
//                log.error("error");
//            }
//        });

        SseEmitter sse = emitters_2.get(shop_id);
        try {
            sse.send(SseEmitter.event()
                    .name("proposal_solution")
                    .data(dto));
            log.info("emitter 이벤트 보내는 중");
        }catch (IOException e){
            log.error("error");
        }

        log.info("emitter 이벤트 보내기 끝");
    }

}
