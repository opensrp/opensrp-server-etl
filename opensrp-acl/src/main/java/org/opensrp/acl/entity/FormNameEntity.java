package org.opensrp.acl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "form")
public class FormNameEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_id_seq")
	@SequenceGenerator(name = "form_id_seq", sequenceName = "form_id_seq", allocationSize = 1)
	private long id;

	private String formName;

	public FormNameEntity() {

	}

	public long getId() {
		return id;
	}

	public String getFormName() {
		return formName;
	}

	public void setProvider(String formName) {
		this.formName = formName;
	}

	@Override
	public String toString() {
		return "FormEntity [id=" + id + ", formName=" + formName + "]";
	}
}