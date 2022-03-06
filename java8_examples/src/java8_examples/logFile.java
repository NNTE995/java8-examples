package java8_examples;

import java.time.LocalTime;

public class logFile {
	private int visitId;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public logFile(int visitId, LocalTime startTime, LocalTime endTime) {
		this.visitId = visitId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public logFile() {
	}
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "logFile [visitId=" + visitId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}