package api.tests;
import api.endpoints.userendpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import api.payloads.user;
import org.testng.annotations.Test;

public class usertestcases {

    Faker faker;
    user userPayLoad;
    @BeforeClass
    public void Datasetup()
    {
   faker = new Faker();
   userPayLoad=new user();

   userPayLoad.setId(faker.idNumber().hashCode());
   userPayLoad.setUsername(faker.name().username());
   userPayLoad.setFirstName(faker.name().firstName());
   userPayLoad.setLastName(faker.name().lastName());
   userPayLoad.setEmail(faker.internet().emailAddress());
   userPayLoad.setPassword(faker.internet().password());
   userPayLoad.setPhone(faker.phoneNumber().phoneNumber());
       }


       @Test(priority = 1)
       public void TestCreateUser(){
           Response response = userendpoints.Createuser(userPayLoad);
           response.then().log().body();
           Assert.assertEquals(response.getStatusCode(),200);
       }

       @Test(priority = 2)
    public void TestReadUser(){
        Response response = userendpoints.ReadUser(this.userPayLoad.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
       }

       //This test method is to update the lastname,email and password
@Test(priority = 3)
    public void TestUpdateUSer()
{
    //These feilds going to be updated
    userPayLoad.setLastName(faker.name().lastName());
    userPayLoad.setEmail(faker.internet().emailAddress());
    userPayLoad.setPassword(faker.internet().password());

    Response response = userendpoints.Updateuser(this.userPayLoad.getUsername(), userPayLoad);
    response.then().log().body();
    Assert.assertEquals(response.getStatusCode(),200);
}

    @Test(priority = 4)
    public void TestDeleteUser(){
        Response response = userendpoints.Deleteuser(this.userPayLoad.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
