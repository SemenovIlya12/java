import java.util.ArrayList;

public class department {
    private String name;
    private ArrayList<employee> employees = new ArrayList<employee>();
    private employee CEO;

    public department(String name) {
        this.name = name;
    }



    public void SetCEO(employee e) {
        this.CEO = e;
    }

    public employee GetCEO() {
        return this.CEO;
    }

    public ArrayList<employee> GetEmployees() {
        return employees;
    }

    public void AddEmployee(employee e) {
        employees.add(e);
    }

    public void Fire(employee e) {
        employees.remove(e);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
