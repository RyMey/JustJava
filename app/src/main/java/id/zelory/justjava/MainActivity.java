package id.zelory.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee
 */

public class MainActivity extends ActionBarActivity
{
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the button order is clicked.
     *
     * @param view
     */

    public void submitOrder(View view)
    {

        int price = quantity * 5;
        String priceMessage;
        if (quantity != 0)
        {
            priceMessage = "Total = $" + price + "\nThank you!";
        } else
        {
            priceMessage = "Please select coffee if you want to buy";
        }
        displayPriceMessage(priceMessage);
    }

    /**
     * this method is called when the button + is clicked.
     *
     * @param view
     */

    public void increment(View view)
    {
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * this method is called when the button - is clicked.
     *
     * @param view
     */

    public void decrement(View view)
    {
        if (quantity > 0)
            quantity = quantity - 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This ethod display the given quantity value on the screen
     *
     * @param number
     */

    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen
     *
     * @param number
     */

    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen
     *
     * @param priceMessage
     */

    private void displayPriceMessage(String priceMessage)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
    }
}
