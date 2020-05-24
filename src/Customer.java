import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();
    private int frequentRenterPoints = 0;

    public Customer(String newName) {
        name = newName;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.PriceCodes.NEW_RELEASE) && rental.getDaysRented() > 1)
            frequentRenterPoints++;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental : rentals) {
            // get amount for current rental
            double amount = rental.getAmount();
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
                    + String.valueOf(amount) + "\n";
            // add current rental amount to total
            totalAmount += amount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
