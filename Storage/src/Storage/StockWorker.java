package Storage;

public class StockWorker extends Person{
    private String jobtitle; //должность работника


    public StockWorker( String name, String phonenumber, String email, String jobtitle) {
        super( name, phonenumber, email, jobtitle);
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getPhonenumber() {
        return super.getPhonenumber();
    }

    @Override
    public void setPhonenumber(String phonenumber) {
        super.setPhonenumber(phonenumber);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
}
