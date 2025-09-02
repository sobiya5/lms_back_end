package com.sutherland.lms.service;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.repo.EmployeeRepository;
import com.sutherland.lms.repo.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRepo;

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public LeaveRequest applyLeave(LeaveRequest request, String empId, String managerId) {
        // validate employee
        Employee emp = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // ✅ no need to fetch manager entity, just store managerId
        request.setEmployee(emp);
        request.setManagerId(managerId);

        return leaveRepo.save(request);
    }

    @Override
    public LeaveRequest verifyLeave(Long requestId, boolean approved, String remarks) {
        LeaveRequest req = leaveRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        if (approved) {
            req.setLeaveStatus(LeaveStatus.APPROVED);
        } else {
            req.setLeaveStatus(LeaveStatus.REJECTED);
            req.setRemarks(remarks == null ? "Reason required" : remarks);
        }
        return leaveRepo.save(req);
    }

    @Override
    public LeaveRequest cancelLeave(Long requestId) {
        LeaveRequest req = leaveRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        req.setLeaveStatus(LeaveStatus.CANCELLED);
        return leaveRepo.save(req);
    }

    @Override
    public LeaveRequest withdrawLeave(Long requestId) {
        LeaveRequest req = leaveRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        req.setLeaveStatus(LeaveStatus.WITHDRAWN);
        return leaveRepo.save(req);
    }

    @Override
    public LeaveRequest checkStatus(Long requestId) {
        return leaveRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
    }

    @Override
    public List<LeaveRequest> viewLeaveHistory(String empId) {
        return leaveRepo.findByEmployeeEmpId(empId);
    }
}