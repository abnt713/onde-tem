package org.ondetem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

@Entity
@Indexed
@AnalyzerDef(name = "customanalyzer",
tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
filters = {
  @TokenFilterDef(factory = LowerCaseFilterFactory.class),
  @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
    @Parameter(name = "language", value = "Portuguese")
  })
})
public class Marker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private double latitude, longitude;
	
	@Field
	@Analyzer(definition="customanalyzer")
	private String label;
	
	public Marker() {
		this(0,0, "");
	}
	public Marker(double latitude, double longitude, String label) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.label = label;
	}
	public Marker(Marker marker) {
		this(marker.getLatitude(), marker.getLongitude(), marker.getLabel());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
