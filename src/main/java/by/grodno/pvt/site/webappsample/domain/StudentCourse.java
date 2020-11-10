package by.grodno.pvt.site.webappsample.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date year;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@OneToMany(mappedBy = "studentAssigment", cascade = CascadeType.REMOVE)
	private List<GraduationMark> marks;
}
