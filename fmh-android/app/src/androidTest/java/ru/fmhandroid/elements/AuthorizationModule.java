package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;


import ru.iteco.fmhandroid.R;

public class AuthorizationModule {
    public ViewInteraction authScreen = onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction login = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction password = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
    public ViewInteraction inRoot = onView(isRoot());

}
