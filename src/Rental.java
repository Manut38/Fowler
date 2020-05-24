class Rental {
    private Movie movie;
    private int daysRented;
    private double amount;

    public Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
        amount = calculateAmount();
    }

    private double calculateAmount() {
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.PriceCodes.REGULAR:
                amount = 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.PriceCodes.NEW_RELEASE:
                amount = daysRented * 3;
                break;
            case Movie.PriceCodes.CHILDRENS:
                amount = 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        return amount;
    }
}