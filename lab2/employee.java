public class employee {
    private String name;
    private department dep;

    public employee(String name, department dep) {
        this.name = name;
        this.dep = dep;
        dep.AddEmployee(this);
    }

    public department GetDepartment() {
        return this.dep;
    }

    public String GetName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.dep.GetCEO() == this) {
            return this.name + " is CEO of " + this.dep;
        } else return this.name + " is working in " + this.dep + " with CEO " + this.dep.GetCEO().GetName();
    }
}
