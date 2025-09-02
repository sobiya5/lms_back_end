package com.sutherland.lms.repo;

import com.sutherland.lms.entity.PublicHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, Integer> {
}
