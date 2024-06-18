package com.encore.outpick_backend.sse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Tag(name = "SSEOfficeEmitters" , description = "본사 프로그램 emitter객체 리스트와 이벤트를 등록하는 곳")
public class SSEOfficeEmitters {

    private final Map<Integer, SseEmitter> emitters_office = new HashMap<Integer, SseEmitter>();

    public SseEmitter add(int employee_id,SseEmitter emitter){
        this.emitters_office.put(employee_id, emitter);
        log.info("new emitter added : {}", emitter);
        log.info("emitters map size : {}", emitters_office.size());
        if(!emitters_office.containsKey(employee_id)){
            emitters_office.remove(employee_id);
            emitters_office.put(employee_id, emitter);
            log.info("기존꺼 삭제, 새로 추가  : {}", emitter);
        }
        emitter.onCompletion(() -> {
            log.info("onCompletion Callback");
            int id = findKeyByValue(emitters_office, emitter);
            this.emitters_office.remove(id);
        });
        emitter.onTimeout(() ->{
            log.info("onTimeout callback");
            emitter.complete();
        });
        return emitter;
    }//add end

    // value를 통한 key찾기
    public static <K, V> K findKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // 값이 없을 경우 null 반환
    }//findKeyByValue end

}
