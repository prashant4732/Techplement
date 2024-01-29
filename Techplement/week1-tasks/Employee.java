
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Employee {

	private int id;
	private String name;
	private String job;
	private double salary;

	public Employee() {

	}

	public Employee(int id, String name, String job, double salary) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

	private List<Employee> employees = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);

	public void addEmployee() {

		System.out.println("Enter the Employee ID :");

		int id = sc.nextInt();
		System.out.println("Enter the Employee Name :");

		String name = sc.next();
		System.out.println("Enter the Employee Job :");

		String job = sc.next();
		System.out.println("Enter the Employee Salary");

		double salary = sc.nextDouble();

		sc.nextLine();

		Employee employee = new Employee(id, name, job, salary);
		employees.add(employee);

		System.out.println("Employee Added Successfully!");
	}

	public void viewEmployee() {
		if (employees.isEmpty()) {
			System.out.println("No Employee Found.");
		} else {
			System.out.println("Employee List:");
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	public void updateEmployee(int employeeID) {

		Iterator<Employee> iterator = employees.iterator();

		Scanner sc = new Scanner(System.in);

		boolean found = false;

		while (iterator.hasNext()) {
			Employee employee = iterator.next();

			if (employee.id == employeeID) {

				System.out.print("Enter updated Employee Name: ");
				String updatedName = sc.nextLine();

				System.out.print("Enter updated Employee Job: ");
				String updatedJob = sc.nextLine();

				System.out.println("Enter updated Employee Salary: ");
				double updatedSalary = sc.nextDouble();

				employee.name = updatedName;
				employee.job = updatedJob;
				employee.salary = updatedSalary;

				System.out.println("Employee with ID " + employeeID + " updated.");
				found = true;
				break;

			}
		}
		if (!found) {
			System.out.println("Employee with ID " + employeeID + " not found.");
		}
	}

	public void deleteEmployee(int employeeId) {
		Iterator<Employee> iterator = employees.iterator();
		boolean found = false;

		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == employeeId) {
				iterator.remove();
				System.out.println("Employee with ID " + employeeId + " deleted.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Employee with ID " + employeeId + " not found.");
		}
	}

	public void searchEmployee() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter search criteria (ID, Name, Job): ");
		String searchCriteria = sc.nextLine().toLowerCase();
		boolean found = false;

		for (Employee employee : employees) {
			if (String.valueOf(employee.getId()).equals(searchCriteria)
					|| employee.getName().toLowerCase().contains(searchCriteria.toLowerCase())
					|| employee.getJob().toLowerCase().contains(searchCriteria.toLowerCase())
					|| String.valueOf(getSalary()).equals(searchCriteria)) {
				// Print details of the matched employee
				System.out.println("Employee ID: " + employee.getId());
				System.out.println("Employee Name: " + employee.getName());
				System.out.println("Employee Job: " + employee.getJob());
				System.out.println("Employee Salary: " + employee.getSalary());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No matching employees found for criteria: " + searchCriteria);
		}
	}

	public void start() {

		Employee employee = new Employee();

		while (true) {
			System.out.println("\nEmployee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				employee.addEmployee();
				break;
			case 2:
				employee.viewEmployee();
				break;
			case 3:
				employee.updateEmployee(sc.nextInt());
				break;
			case 4:
				employee.deleteEmployee(sc.nextInt());
				break;
			case 5:
				employee.searchEmployee();
			case 6:
				System.out.println("Exiting the program. Goodbye!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void main(String[] args) {

		Employee e1 = new Employee();
		e1.start();
	}
}
