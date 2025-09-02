package com.sutherland.lms.service;

import com.sutherland.lms.entity.PublicHoliday;
import java.util.List;

public interface PublicHolidayService {
    PublicHoliday addHoliday(PublicHoliday holiday);
    List<PublicHoliday> getAllHolidays();
}
