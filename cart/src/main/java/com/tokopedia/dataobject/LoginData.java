package com.tokopedia.dataobject;

import org.testng.annotations.DataProvider;

public class LoginData {
    private String email;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @DataProvider(name = "buyer")
    public static Object[][] buyer() {
        return new Object[][] {
                {"rahmat.ramadhani@tokopedia.com", "b1sm1llahtokped"}
        };
    }

    @DataProvider(name = "buyer1")
    public static Object[][] buyer1() {
        return new Object[][] {
                {"rahmat.ramadhani+01@tokopedia.com", "b1sm1llahtokped"}
        };
    }

    @DataProvider(name = "buyer2")
    public static Object[][] buyer2() {
        return new Object[][] {
                {"rahmat.ramadhani+02@tokopedia.com", "b1sm1llahtokped"}
        };
    }
}
