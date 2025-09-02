package com.sutherland.lms.controller;

import com.sutherland.lms.entity.PublicHoliday;
import com.sutherland.lms.service.PublicHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
@CrossOrigin(origins = "http://localhost:3002") // allow requests from frontend
public class PublicHolidayController {

    @Autowired
    private PublicHolidayService holidayService;

    // Add holiday
    @PostMapping("/addholidaydetails")
    public ResponseEntity<PublicHoliday> addHoliday(@RequestBody PublicHoliday holiday) {
        PublicHoliday savedHoliday = holidayService.addHoliday(holiday);
        return ResponseEntity.ok(savedHoliday);
    }

    // View all holidays
    @GetMapping("/viewholidaylist")
    public ResponseEntity<List<PublicHoliday>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }
}
