package pl.bnsit.java.foundations.serialization;


public class Runner {

	public static void main(String[] args) {
		Department department = new Department("R&D", "Generalnie dobrze sie bawimy!");
		department.addEmployee(new Employee(1L, "Andrzej", 25));
		department.addEmployee(new Employee(2L, "Peter", 26));
		department.addEmployee(new Employee(3L, "Bziku", 27));
		department.addEmployee(new Employee(4L, "Wasyl", 28));
		department.addEmployee(new Employee(5L, "Kleofas", 30));

		System.out.println( "Zapis do pliku" );
	}
	
	public static void procesuj( Department department, DepartmentDao dao ) {
	}
}
