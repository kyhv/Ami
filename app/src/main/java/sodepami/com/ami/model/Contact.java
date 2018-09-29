package sodepami.com.ami.model;

public class Contact {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String id;

    public String getRawContactId() {
        return rawContactId;
    }

    public void setRawContactId(String rawContactId) {
        this.rawContactId = rawContactId;
    }

    private String rawContactId;
    private String name;
    private String phone;
    private String convertPhone;
    private boolean isCheck = true;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getConvertPhone() {
        return convertPhone;
    }

    public void setConvertPhone(String convertPhone) {
        this.convertPhone = convertPhone;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equalsIgnoreCase(((Contact)obj).id);
    }
}
