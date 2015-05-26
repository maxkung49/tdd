package com.example.chokkamons.tddandroid;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Chokkamon.S on 26/05/2015.
 */
@RunWith(Parameterized.class)
public class convertFahrenheitToCelsiusTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);
    private String fahrenheit;
    private String celcius;

    @Parameters

        public static Iterable<Object[]> data(){
            return Arrays.asList(new Object[][]{
                    {"32.0","0"},
                    {"33.8","1"}
            });
        //Cat and Dog
        }


    public convertFahrenheitToCelsiusTest(String fahrenheit,String celcius){
        this.fahrenheit = fahrenheit;
        this.celcius = celcius;
    }

   @Test
    public void convertDataFromFahrenheitToCelsius(){
       onView(withId(R.id.txtCelcius)).perform(ViewActions.typeText(this.celcius));
       onView(withId(R.id.txtFahrenheit)).check(matches(withText(this.fahrenheit)));
       //onView(withId(R.id.txtFahrenheit)).perform(ViewActions.typeText(this.fahrenheit));

   }
}
