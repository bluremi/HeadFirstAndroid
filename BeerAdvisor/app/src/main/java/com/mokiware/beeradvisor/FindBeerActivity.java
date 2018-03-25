package com.mokiware.beeradvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        //call when the user clicks the FIND BEER button
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());

        BeerExpert expert = new BeerExpert();
        List<String> beerList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for (String beer : beerList) {
            brandsFormatted.append(beer).append('\n');
        }

        brands.setText(brandsFormatted);
    }
}
