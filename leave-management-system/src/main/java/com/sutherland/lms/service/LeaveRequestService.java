package com.sutherland.lms.service;

import com.sutherland.lms.entity.LeaveRequest;
import java.util.List;

public interface LeaveRequestService {
    LeaveRequest applyLeave(LeaveRequest request, String empId, String managerId);
    LeaveRequest verifyLeave(Long requestId, boolean approved, String remarks);
    LeaveRequest cancelLeave(Long requestId);
    LeaveRequest withdrawLeave(Long requestId);
    LeaveRequest checkStatus(Long requestId);
    List<LeaveRequest> viewLeaveHistory(String empId);
}