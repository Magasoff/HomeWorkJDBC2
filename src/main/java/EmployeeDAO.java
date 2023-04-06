import java.util.List;

public interface EmployeeDAO {

    Integer add(Employee employee);

    Employee getBuyId(int Id);

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(Employee employee);
}