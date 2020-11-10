package by.grodno.pvt.site.webappsample.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private User teacher;

	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<StudentCourse> studentCourses;

	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<Schedule> schedule;
}
