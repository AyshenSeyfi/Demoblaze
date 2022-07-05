package TestData;

import Utils.RandomStringGenerator;
import lombok.var;
import models.UserModel;

public class DefaultUser {

    public static UserModel getDefaultUser(){

        var userModel = new UserModel();
        var random = RandomStringGenerator.generateRandomString(5);
        userModel.setUsername("test"+ random);
        userModel.setPassword("123"+random);

        return userModel;
    }
}
