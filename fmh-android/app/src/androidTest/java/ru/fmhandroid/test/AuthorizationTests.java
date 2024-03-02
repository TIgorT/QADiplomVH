package ru.fmhandroid.test;



import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import ru.fmhandroid.steps.AuthorizationSteps;
import ru.fmhandroid.steps.MainStep;
import ru.iteco.fmhandroid.ui.AppActivity;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTests {


    AuthorizationSteps auth = new AuthorizationSteps();
    MainStep main = new MainStep();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        auth.waitAutorizationContainer();

        try {
            auth.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            main.logOut();
        }
    }

    @Test
    @DisplayName("Вход с валидными данными")
    public void validAuth(){
        auth.isAuthorizationScreen();
        auth.validAuth();
        main.logOut();
    }
}
