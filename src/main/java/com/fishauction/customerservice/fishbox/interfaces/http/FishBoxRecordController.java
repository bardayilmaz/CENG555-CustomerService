package com.fishauction.customerservice.fishbox.interfaces.http;

import com.fishauction.customerservice.fishbox.application.FishBoxRecordService;
import com.fishauction.customerservice.fishbox.domain.model.http.response.FishBoxRecordResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fish-box-records")
@AllArgsConstructor
public class FishBoxRecordController {

    private final FishBoxRecordService fishBoxRecordService;

    @GetMapping("/daily-report")
    public List<FishBoxRecordResponse> getDailyReportAfterAuction() {
        return fishBoxRecordService.getDailyReportAfterAuction();
    }
}
