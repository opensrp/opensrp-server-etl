package org.opensrp.etl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "encc")
public class ENCCEntity {
	
	private static final ENCCEntity INSTANCE = new ENCCEntity();
	
	private ENCCEntity() {
		
	}
	
	public static ENCCEntity getInstance() {
		return INSTANCE;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encc_id_seq")
	@SequenceGenerator(name = "encc_id_seq", sequenceName = "encc_id_seq", allocationSize = 1)
	private int id;
	
	private String FWENCDATE;
	
	private String FWENCSTS;
	
	private String FWENCBFINTN;
	
	private String FWENCPRLCTL;
	
	private String FWENCDRYWM;
	
	private String FWENCHDCOV;
	
	private String FWENCBTHD;
	
	private String FWENCUMBS;
	
	private String FWENCDSFVRCLD;
	
	private String FWENCTEMP;
	
	private String FWENCDSFOULUMBS;
	
	private String FWENCDSLIMBLUE;
	
	private String FWENCDSSKNYLW;
	
	private String FWENCDSLETH;
	
	private String FWENCDSDIFBRTH;
	
	private String FWENCDSCONVL;
	
	private String FWENCDELCOMP;
	
	private String encc_current_formStatus;
	
	private String REFERENCE_DATE;
	
	private String START_DATE;
	
	private String END_DATE;
	
	private long clientVersion;
	
	private String received_time;
	
	private long timeStamp;
	
	private String enccName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private ChildEntity child;
	
}
