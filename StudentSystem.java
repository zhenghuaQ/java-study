import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //先写打印菜单
        loop:while (true) {
            System.out.println("-------欢迎来到系统-------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" ->deleteStudent(list);
                case "3" ->updateStudent(list);
                case "4" ->searchStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }
    public static void addStudent(ArrayList<Student> list){//over
        Student stu=new Student();
        System.out.println("输入学生信息");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id：");
        String id= sc.next();
        System.out.println("请输入学生名字：");
        String setname=sc.next();
        System.out.println("请输入学生年龄：");
        int age=sc.nextInt();
        System.out.println("请输入学生地址：");
        String address= sc.next();
        stu.setId(id);
        stu.setName(setname);
        stu.setAge(age);
        stu.setAddress(address);
        list.add(stu);
        //id唯一怎么实现
        for (int i = 0; i < list.size(); i++) {
            for(int j=0;j<list.size();j++){
                if(i!=j){
                    if(list.get(i).getId().equals(list.get(j).getId())){
                        System.out.println("请不要输入相同id的学生");
                        list.remove(j);
                    }
                }
            }
        }
//        System.out.println(list);
    }
    public static void deleteStudent(ArrayList<Student> list){//over
        System.out.println("删除学生");
        //先创建空对象
        Student stu=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入想要删除的学生id：");
        String putid= sc.next();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(putid)){
                list.remove(i);
            }else{
                System.out.println("此学生id不存在");
                //怎么返回到初始菜单
//                return ;
            }
        }
        System.out.println(list);
    }
    public static void updateStudent(ArrayList<Student> list){
        System.out.println("修改学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入想要修改的学生ID");
        String searchId= sc.next();
        int index=getIndex(list,searchId);
        Student stu=list.get(index);
        System.out.println("请输入新的名字：");
        String newName= sc.next();
        stu.setName(newName);
        System.out.println("请输入新的年龄：");
        int newAge= sc.nextInt();
        stu.setAge(newAge);
        System.out.println("请输入新的地址:");
        String newAdress= sc.next();
        stu.setAddress(newAdress);
        System.out.println("修改完毕!");
        list.add(stu);
    }
    public static void searchStudent(ArrayList<Student> list){
        System.out.println("查询学生");
        if(list.size()==0){
            System.out.println("当前无学生信息");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭地址");
        for (int i = 0; i < list.size(); i++) {
            Student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
