package callbus.zaritalk.dataaccesslayer.entity;

public enum EAccountType {
    REALTOR("중개사"),
    LESSOR("임대인"),
    LESSEE("임차인");

    private final String value;

    EAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
