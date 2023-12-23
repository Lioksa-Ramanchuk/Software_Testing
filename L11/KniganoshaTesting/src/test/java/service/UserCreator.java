package service;

import model.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    @Contract(" -> new") public static @NotNull User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }


    @Contract(" -> new") public static @NotNull User withEmptyUsername() { return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD)); }
    @Contract(" -> new") public static @NotNull User withEmptyPassword() { return new User(TestDataReader.getTestData((TESTDATA_USER_NAME)), ""); }
}
