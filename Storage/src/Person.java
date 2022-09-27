public class Person {
    private long id; //id аккаунта
    private String name; //ФИО пользователя или название организации
    private String phonenumber; //Контактный телефон
    private String email; //Контактная электронная почта
    private long paymentdeteails; //платежные данные

    public Person(long id, String name, String phonenumber, String email, long paymentdeteails) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.paymentdeteails = paymentdeteails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPaymentdeteails() {
        return paymentdeteails;
    }

    public void setPaymentdeteails(long paymentdeteails) {
        this.paymentdeteails = paymentdeteails;
    }
}
