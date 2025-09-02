package com.sutherland.lms.service;

import com.sutherland.lms.entity.PublicHoliday;
import com.sutherland.lms.repo.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicHolidayServiceImpl implements PublicHolidayService {

    @Autowired
    private PublicHolidayRepository holidayRepo;

    @Override
    public PublicHoliday addHoliday(PublicHoliday holiday) {
        return holidayRepo.save(holiday);
    }

    @Override
    public List<PublicHoliday> getAllHolidays() {
        return holidayRepo.findAll();
    }
}
