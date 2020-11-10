package by.grodno.pvt.site.webappsample.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class GraduationMark {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(nullable = false)
	private MarkType type;

	@Column(nullable = false)
	private Integer mark;

	@ManyToOne
	@JoinColumn(name = "assigment_id")
	private StudentCourse studentAssigment;
}
