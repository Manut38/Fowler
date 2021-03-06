public class Movie {
    private String title;
    private int priceCode;

    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        priceCode = newPriceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int newPriceCode) {
        priceCode = newPriceCode;
    }

    public String getTitle() {
        return title;
    }
    
    public static class PriceCodes {
        public static final int CHILDRENS = 2;
        public static final int REGULAR = 0;
        public static final int NEW_RELEASE = 1;
    }
}