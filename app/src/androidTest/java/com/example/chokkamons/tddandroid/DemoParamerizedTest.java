package com.example.chokkamons.tddandroid;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Chokkamon.S on 25/05/2015.
 */
@RunWith(Parameterized.class)
public class DemoParamerizedTest {
    private final String celsius;
    private final String fahrenheit;

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Parameters
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"0","32.0"},
                {"1","33.8"}
        });
    }

    public DemoParamerizedTest(String celsius, String fahrenheit){
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    @Test
    public void convertDataFromCelsiusToFahrenheit(){
        onView(withId(R.id.txtCelcius)).perform(ViewActions.typeText(this.celsius));

    }



}
