package com.sutherland.lms.controller;

import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins = "http://localhost:3002") // allow requests from frontend
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveService;

    @PostMapping("/applyleaverequest")
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest request,
                                                   @RequestParam String empId,
                                                   @RequestParam String managerId) {
        return ResponseEntity.ok(leaveService.applyLeave(request, empId, managerId));
    }

    @PutMapping("/verifyleaverequest/{id}")
    public ResponseEntity<LeaveRequest> verifyLeave(@PathVariable Long id,
                                                    @RequestParam boolean approved,
                                                    @RequestParam(required = false) String remarks) {
        return ResponseEntity.ok(leaveService.verifyLeave(id, approved, remarks));
    }

    @PutMapping("/cancelleave/{id}")
    public ResponseEntity<LeaveRequest> cancelLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.cancelLeave(id));
    }

    @PutMapping("/withdrawleave/{id}")
    public ResponseEntity<LeaveRequest> withdrawLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.withdrawLeave(id));
    }

    @GetMapping("/checkleaverequeststatus/{id}")
    public ResponseEntity<LeaveRequest> checkStatus(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.checkStatus(id));
    }

    @GetMapping("/viewleavehistory/{empId}")
    public ResponseEntity<List<LeaveRequest>> viewLeaveHistory(@PathVariable String empId) {
        return ResponseEntity.ok(leaveService.viewLeaveHistory(empId));
    }
}
