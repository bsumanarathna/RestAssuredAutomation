package api.tests;

import api.endpoints.userendpoints;
import api.payloads.user;
import api.utilities.DataProviders;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDtestCases {

    @Test(priority = 1,dataProvider = "Data" ,dataProviderClass = DataProviders.class )
    public void testPostUser(int Id,String userName,String fName,String lName, String emailId,String pwd,String ph)
    {
      user userPayload=new user();
        userPayload.setId(Integer.parseInt(String.valueOf(Id)));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fName);
        userPayload.setLastName(lName);
        userPayload.setEmail(emailId);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);

        Response response= userendpoints.Createuser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2,dataProvider = "Usernames" , dataProviderClass = DataProviders.class)
    public void deleteUser(String userName)
    {
        Response response=userendpoints.Deleteuser(userName);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
