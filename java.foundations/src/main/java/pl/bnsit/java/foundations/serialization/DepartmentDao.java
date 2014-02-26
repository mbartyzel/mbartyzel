package pl.bnsit.java.foundations.serialization;

public interface DepartmentDao {

	public abstract Long saveDepartment(Department department);

	public abstract Department loadDepartment(Long id);

}