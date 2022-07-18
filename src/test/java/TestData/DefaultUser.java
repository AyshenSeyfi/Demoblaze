package TestData;

import Utils.RandomStringGenerator;
import models.UserModel;

public class DefaultUser {

    public static UserModel getDefaultUser(){

        UserModel userModel = new UserModel();
        String random = RandomStringGenerator.generateRandomString(5);
        userModel.setUsername("test"+ random);
        userModel.setPassword("123"+random);

        return userModel;
    }
}
