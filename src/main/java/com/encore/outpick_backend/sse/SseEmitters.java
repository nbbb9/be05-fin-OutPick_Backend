package com.encore.outpick_backend.sse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Tag(name = "SseEmitters" , description = "emitter객체 리스트와 이벤트를 등록하는 곳")
public class SseEmitters {

    private final Map<Integer, SseEmitter> emitters = new HashMap<Integer, SseEmitter>();

    public SseEmitter add(int shop_id,SseEmitter emitter){
        this.emitters.put(shop_id, emitter);
        log.info("new emitter added : {}", emitter);
        log.info("emitters map size : {}", emitters.size());
        if(!emitters.containsKey(shop_id)){
            emitters.remove(shop_id);
            emitters.put(shop_id, emitter);
            log.info("기존꺼 삭제, 새로 추가  : {}", emitter);
        }
        emitter.onCompletion(() -> {
            log.info("onCompletion Callback");
            int id = findKeyByValue(emitters, emitter);
            this.emitters.remove(id);
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

    //건의문 해결방안 작성시 매장에 알림
    public void proposal_solution(int shop_id, int proposal_id){
        
        ProposalSolutionSSEDTO dto = new ProposalSolutionSSEDTO();
        dto.setShop_id(shop_id);
        dto.setProposal_id(proposal_id);

        SseEmitter sse = emitters.get(shop_id);
        try {
            sse.send(SseEmitter.event()
                    .name("proposal_solution")
                    .data(dto));
            log.info("emitter 이벤트 보내는 중");
        }catch (NullPointerException e) {
            log.error("sse 객체가 없습니다.");
        }catch (IOException e){
            log.error("error");
        }

        log.info("emitter 이벤트 보내기 끝");
    }//proposal_solution end

    //할인율 알림
    public void product_discount(int shop_id, int product_id){
        ProductDiscountSSEDTO dto = new ProductDiscountSSEDTO();
        dto.setShop_id(shop_id);
        dto.setProduct_id(product_id);

        SseEmitter sse = emitters.get(shop_id);
        try {
            sse.send(SseEmitter.event()
                    .name("product_discount")
                    .data(dto));
            log.info("할인율 emitter 이벤트 보내는 중");
        }catch (NullPointerException e) {
            log.error("sse 객체가 없습니다.");
        }catch (IOException e){
            log.error("error");
        }

        log.info("할인율 emitter 이벤트 보내기 끝");
    }//product_discount end

    //재고요청서 승인 알림
    public void stock_request_approval(int shop_id, int stock_request_id){
        StockRequestApprovalSSEDTO dto = new StockRequestApprovalSSEDTO();
        dto.setShop_id(shop_id);
        dto.setStock_request_id(stock_request_id);

        SseEmitter sse = emitters.get(shop_id);
        try {
            sse.send(SseEmitter.event()
                    .name("stock_request_approval")
                    .data(dto));
            log.info("재고요청서 승인 emitter 이벤트 보내는 중");
        }catch (NullPointerException e) {
            log.error("sse 객체가 없습니다.");
        }catch (IOException e){
            log.error("error");
        }

        log.info("재고요청서 승인 emitter 이벤트 보내기 끝");
    }//stock_request_approval end

    //재고요청서 피드백 알림
    public void stock_request_feedback(int shop_id, int stock_request_id){
        StockRequestFeedbackSSEDTO dto = new StockRequestFeedbackSSEDTO();
        dto.setShop_id(shop_id);
        dto.setStock_request_id(stock_request_id);

        SseEmitter sse = emitters.get(shop_id);
        try {
            sse.send(SseEmitter.event()
                    .name("stock_request_feedback")
                    .data(dto));
            log.info("재고요청서 피드백 emitter 이벤트 보내는 중");
        }catch (NullPointerException e) {
            log.error("sse 객체가 없습니다.");
        }catch (IOException e){
            log.error("error");
        }

        log.info("재고요청서 피드백 emitter 이벤트 보내기 끝");
    }//stock_request_approval end

}
