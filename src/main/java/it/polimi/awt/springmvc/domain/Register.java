package it.polimi.awt.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("register_by_metering_point_name")
public class Register implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column("metering_point_id")
	private String meteringPointId;
	@PrimaryKeyColumn
    private Date timestamp;
	@PrimaryKeyColumn(name = "metering_point_name", type=PrimaryKeyType.PARTITIONED)
    private String meteringPointName;
    private float value;
    private String status;
    private String unit;
    @Column("trasformer_ratio")
    private Float transformerRatio;
    
    public Register() {
    	
    }
    
    public Register(String meteringPointName,Date timestamp) {
    	this.meteringPointName = meteringPointName;
    	this.timestamp=timestamp;
    }
    public Register(String meteringPointId, String meteringPointName, float value, String status, Date timestamp,
			String unit, Float transformerRatio) {
		super();
			
		this.meteringPointId = meteringPointId;
		this.meteringPointName = meteringPointName;
		
		//4 decimals
		this.value = (Math.round(value * 10000)/10000.0f) * transformerRatio;
		
		this.status = status;
		this.timestamp = timestamp;
		this.unit = unit;
		this.transformerRatio = transformerRatio;
	}
    
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
        //4 decimals
		this.value =Math.round(value * 10000)/10000.0f;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMeteringPointId() {
		return meteringPointId;
	}
	public void setMeteringPointId(String meteringPointId) {
		this.meteringPointId = meteringPointId;
	}
	public String getMeteringPointName() {
		return meteringPointName;
	}
	public void setMeteringPointName(String meteringPointName) {
		this.meteringPointName = meteringPointName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getTransformerRatio() {
		return transformerRatio;
	}
	public void setTransformerRatio(Float transformerRatio) {
		this.transformerRatio = transformerRatio;
	}
    
    
}
