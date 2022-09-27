public class Customer extends Person {

    private int age; //возраст покупателя
    private String gender; //пол покупателя

    public Customer(long id, String name, int phonenumber, String email, long paymentdeteails, int age, String gender) {
        super(id, name, phonenumber, email, paymentdeteails, age, gender);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


