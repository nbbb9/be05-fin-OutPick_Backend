package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Store.domain.StoreAddStockRequestDTO;
import com.encore.outpick_backend.Store.domain.StoreFeedbackDTO;
import com.encore.outpick_backend.Store.domain.StoreStockRequestDTO;
import com.encore.outpick_backend.Store.service.StoreStockRequestService;
import com.encore.outpick_backend.sse.SSEOfficeEmitters;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "재고요청서_매장프로그램", description = "매장 재고요청서와 관련된 API")
@RequestMapping("/store/stockrequest")
public class StoreStockRequestController {

    @Autowired
    private StoreStockRequestService storeStockRequestService;

    @Autowired
    private SSEOfficeEmitters sseOfficeEmitters;

    @Operation(summary = "재고요청서 작성")
    @PostMapping("/add")
    public void create_stockRequest (@RequestBody StoreAddStockRequestDTO storeAddStockRequestDTO){
        log.info("재고요청서 작성 Controller");

        int shopID = storeAddStockRequestDTO.getShop_id();

        int employeeID = storeStockRequestService.find_employee_id(shopID);

        sseOfficeEmitters.add_stock_request(shopID, employeeID);

        storeStockRequestService.create_stockRequest(storeAddStockRequestDTO);
    }//create_stockRequest end

    @Operation(summary = "재고요청서 작성 페이지 이동시 상품 정보를 모두 불러옴")
    @GetMapping("/productlist")
    public ResponseEntity<List<ProductDTO>> read_stockRequest_product(){
        log.info("read_stockRequest_product Controller");

        return new ResponseEntity<>(storeStockRequestService.read_stockRequest_product(), HttpStatus.OK);
    }//read_stockRequest_product end

    @Operation(summary = "재고요청서 리스트 조회")
    @GetMapping("/list/{shopid}")
    public ResponseEntity<List<StoreStockRequestDTO>> read_stockRequest_list(@PathVariable("shopid") int shopid){
        log.info("read_stockRequest_list Controller");

        return new ResponseEntity<>(storeStockRequestService.read_stockRequest_list(shopid), HttpStatus.OK);
    }//read_stockRequest_list end

    @Operation(summary = "피드백 상세")
    @GetMapping("/feedback/{formid}")
    public ResponseEntity<StoreFeedbackDTO> read_feedback(@PathVariable("formid") int formid){
        log.info("read_feedback Controller");

        return new ResponseEntity<>(storeStockRequestService.read_feedback(formid), HttpStatus.OK);
    }//read_feedback end

}