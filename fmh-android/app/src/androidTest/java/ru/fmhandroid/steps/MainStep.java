package ru.fmhandroid.steps;


import ru.fmhandroid.elements.MainElement;
import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.fmhandroid.data.Utils.waitDisplayed;



public class MainStep {
    MainElement main = new MainElement();

    public void isMainScreen(){
        main.allNews.check(matches(isDisplayed()));
    }

    public void isMainScreenLoaded(){
        main.inRoot.perform(waitDisplayed(R.id.trademark_image_view, 5000));
    }

    public void logOut() {
        main.profile.perform(click());
        main.logOut.perform(click());
        main.authScreen.check(matches(isDisplayed()));
    }


}
