package Storage;
public class Person {
    private int id; //id аккаунта
    private String name; //ФИО пользователя или название организации
    private String phonenumber; //Контактный телефон
    private String email; //Контактная электронная почта
    private String paymentdeteails; //платежные данные

    public Person( String name, String phonenumber, String email, String paymentdeteails) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.paymentdeteails = paymentdeteails;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentdeteails() {
        return paymentdeteails;
    }

    public void setPaymentdeteails(String paymentdeteails) {
        this.paymentdeteails = paymentdeteails;
    }
}