package com.example.chokkamons.tddandroid;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloEspressoTest{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void convert_temperator_from_0_celsius_should_32_fahrenheit(){
        onView(withId(R.id.txtCelcius)).perform(typeText("0"));
        onView(withId(R.id.txtFahrenheit)).check(matches(withText("32.0")));
    }

    @Test
    public void convert_temperator_from_32_fahrenheit_should_0_celsius(){
        onView(withId(R.id.txtFahrenheit)).perform(typeText("32"));
        onView(withId(R.id.txtCelcius)).check(matches(withText("0.0")));
    }

}
