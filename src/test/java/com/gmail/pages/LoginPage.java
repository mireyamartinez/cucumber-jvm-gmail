package com.gmail.pages;

import com.gmail.UI.DriverElement;
import com.gmail.UI.DriverElementLocator;

public class LoginPage extends BasePage {
    private DriverElement email = new DriverElement(DriverElementLocator.ID, "Email");
    private DriverElement password = new DriverElement(DriverElementLocator.ID, "Passwd");
    private DriverElement signIn = new DriverElement(DriverElementLocator.ID, "signIn");
    private DriverElement invalidCredOrPassword = new DriverElement(DriverElementLocator.ID, "errormsg_0_Passwd");
    private DriverElement enterEmail = new DriverElement(DriverElementLocator.ID, "errormsg_0_Email");

    public void enterInvalidCredentials() {
        UIDriver.type(email, "invalid");
        UIDriver.type(password, "invalid");
        UIDriver.click(signIn);
    }

    public String getMessageText(String element) {
        switch (element.replaceAll(" ", "").toLowerCase()) {
            case ("invalidcredentials"):
            case ("enterpassword"):
                System.out.println(UIDriver.getText(invalidCredOrPassword));
                return UIDriver.getText(invalidCredOrPassword);

            case ("enteremail"):
                System.out.println(UIDriver.getText(enterEmail));
                return UIDriver.getText(enterEmail);

            default:
                throw new IllegalStateException("Message does not exist in Page");
        }
    }

    public void leaveCredentialBlank(String credential) {
        switch (credential.replaceAll(" ", "").toLowerCase()) {
            case "emailaddress":
                UIDriver.type(email, "");
                UIDriver.type(password, "a");
                break;

            case "password":
                UIDriver.type(email, "a");
                UIDriver.type(password, "");
                break;

            default:
                throw new IllegalStateException("Invalid case passed");
        }

        UIDriver.click(signIn);


    }
}
