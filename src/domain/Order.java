package domain;

/**
 * Created by i20762 on 7/13/2017.
 */
public class Order {
    Float amount;

    public Order(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
