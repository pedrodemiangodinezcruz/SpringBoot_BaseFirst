package com.solera.example.defectexample.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Inspection")
public class InspectionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private Long vehicleId;
	private Long driverId;
	private String comments;
	private Date createdDate;
	public InspectionModel() {
		
	}
	public InspectionModel(Long id, Long vehicleId, Long driverId, String comments, Date createdDate) {
		this.id = id;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.comments = comments;
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreateDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "InspectionModel [id=" + id + ", vehicleId=" + vehicleId + ", driverId=" + driverId + ", comments="
				+ comments + ", createdDate=" + createdDate + "]";
	}
	
}
