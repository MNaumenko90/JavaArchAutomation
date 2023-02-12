package api.enumeration;

public enum Urls {
    CREATE_PET_STORE_ORDER("/store/order");

    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
