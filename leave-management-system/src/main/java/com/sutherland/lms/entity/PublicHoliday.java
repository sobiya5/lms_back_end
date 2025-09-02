package com.sutherland.lms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "public_holidays")
public class PublicHoliday {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_seq")
	@SequenceGenerator(name = "holiday_seq", sequenceName = "HOLIDAY_SEQ", allocationSize = 1)
	

    private int id;

    @Column(name = "holiday_date")  // avoid using reserved word DATE
    private LocalDate date;

    @Column(name = "holiday_details")
    private String holidayDetails;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getHolidayDetails() {
        return holidayDetails;
    }
    public void setHolidayDetails(String holidayDetails) {
        this.holidayDetails = holidayDetails;
    }
}
