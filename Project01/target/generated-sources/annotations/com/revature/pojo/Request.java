package com.revature.pojo;

public class Request {

		int requestId;
		int employeeId;
		String reason;
		int spentAmount;
		int requestedAmount;
		String vendor;
		int bankNumber;
		int routingNumber;
		String createdOn;
		String createdBy;
		String modifiedBy;
		int isAproved;
		public int getRequestId() {
			return requestId;
		}
		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public int getSpentAmount() {
			return spentAmount;
		}
		public void setSpentAmount(int spentAmount) {
			this.spentAmount = spentAmount;
		}
		public int getRequestedAmount() {
			return requestedAmount;
		}
		public void setRequestedAmount(int requestedAmount) {
			this.requestedAmount = requestedAmount;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public int getBankNumber() {
			return bankNumber;
		}
		public void setBankNumber(int bankNumber) {
			this.bankNumber = bankNumber;
		}
		public int getRoutingNumber() {
			return routingNumber;
		}
		public void setRoutingNumber(int routingNumber) {
			this.routingNumber = routingNumber;
		}
		public String getCreatedOn() {
			return createdOn;
		}
		public void setCreatedOn(String createdOn) {
			this.createdOn = createdOn;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public int getIsAproved() {
			return isAproved;
		}
		public void setIsAproved(int isAproved) {
			this.isAproved = isAproved;
		}
		
		
}
