public class Supplier extends Person{

    private long INN ; //ИНН
    private long OGRN; //ОГРН
    public Supplier(long id, String name, int phonenumber, String email, long paymentdeteails, long INN, String OGRN) {
        super(id, name, phonenumber, email, paymentdeteails, INN, OGRN);
    }

    public long getINN() {
        return INN;
    }

    public void setINN(long INN) {
        this.INN = INN;
    }

    public long getOGRN() {
        return OGRN;
    }

    public void setOGRN(long OGRN) {
        this.OGRN = OGRN;
    }
}
