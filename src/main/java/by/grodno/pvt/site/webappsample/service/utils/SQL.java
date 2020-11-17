package by.grodno.pvt.site.webappsample.service.utils;

public class SQL {

	public static final String SELECT_ALL = "select * from public.testtable order by id";
	public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
	public static final String INSERT = "INSERT INTO public.testTable "
			+ "(empl_name, empl_last_name, salary, birthdate,  male) VALUES (?,?,?,?,?)";

}
