package com.solera.example.defectexample.model;
import java.util.Date;
import javax.persistence.*;



@Entity
@Table(name = "Defect")
public class DefectModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private Integer status;
	private String comments;
	private Date createdDate;
	private Date repairedDate;
	
	private Long inspectionID;
	private Long partID;
	
	public DefectModel() {
		
	}

	public DefectModel(Long id, Long inspectionID, Long partID, int status, String comments, Date createdDate,
			Date repairedDate) {
		this.id = id;
		this.inspectionID = inspectionID;
		this.partID = partID;
		this.status = status;
		this.comments = comments;
		this.createdDate = createdDate;
		this.repairedDate = repairedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInspectionID() {
		return inspectionID;
	}

	public void setInspectionID(Long inspectionID) {
		this.inspectionID = inspectionID;
	}

	public Long getPartID() {
		return partID;
	}

	public void setPartID(Long partID) {
		this.partID = partID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComment() {
		return comments;
	}

	public void setComment(String comments) {
		this.comments = comments;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getRepairedDate() {
		return repairedDate;
	}

	public void setRepairedDate(Date repairedDate) {
		this.repairedDate = repairedDate;
	}

	@Override
	public String toString() {
		return "DefectModel [id=" + id + ", inspectionID=" + inspectionID + ", partID=" + partID + ", status=" + status
				+ ", comments=" + comments + ", createdDate=" + createdDate + ", repairedDate=" + repairedDate + "]";
	}
	
	
}
