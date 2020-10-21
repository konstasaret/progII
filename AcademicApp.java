public class AcademicApp {
    public static void main(String[] args) {
        Students students=new Students("KAS","EA","WDAD",2019);
        Department department=new Department(123,"ERSE");
        Teacher teacher=new Teacher("dawd","wda",1000,"ewawda","wdwd",department);
        AdministrativePersonnel administrativePersonnel=new AdministrativePersonnel("SDAD","AWDA",3232,"EFAAD","AWDAW");
        System.out.println(students.toString());
        System.out.println(department.toString());
        System.out.println(teacher.toString());
        System.out.println(administrativePersonnel.toString());
    }
}
