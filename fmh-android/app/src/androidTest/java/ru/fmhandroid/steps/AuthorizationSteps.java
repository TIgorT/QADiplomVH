package ru.fmhandroid.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;


import static ru.fmhandroid.data.Utils.waitDisplayed;


import ru.fmhandroid.elements.AuthorizationModule;
import ru.iteco.fmhandroid.R;

public class AuthorizationSteps {
    AuthorizationModule auth = new AuthorizationModule();

    MainStep main = new MainStep();

    public void isAuthorizationScreen() {

        auth.authScreen.check(matches(isDisplayed()));
    }

    public void waitAutorizationContainer() {
        auth.inRoot.perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 5000));
    }

    public void loginInputField(String login) {
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(login));
    }

    public void passwordInputField(String password) {
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(password));
    }

    public void buttonClick() {
        auth.signInButton.perform(click());
    }

    public void validAuth() {
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText("login2"));
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText("password2"));
        auth.signInButton.perform(click());
        main.isMainScreenLoaded();
        main.isMainScreen();
    }
}
