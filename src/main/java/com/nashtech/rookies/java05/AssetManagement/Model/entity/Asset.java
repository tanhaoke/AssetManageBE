package com.nashtech.rookies.java05.AssetManagement.Model.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="asset")
@Entity
public class Asset {
	
	@Id
	private String AssetId;
	
	private String name;
	
	private String specification;
	
	@Temporal(TemporalType.DATE)
    @Column(nullable = false)
	private Date installedDate;
	
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "asset",cascade = CascadeType.ALL)
	private Set<Assignment> assignment;
}