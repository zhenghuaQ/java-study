public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    public Student(){}
    public Student(String id,String name,int age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return id+name+age+address;
    }
}
