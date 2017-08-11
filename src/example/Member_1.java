package example;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class Photo {}

@DBTable_1(name = "MEMBER_1")
public class Member_1 {
    @SQLString_1(30)
    String firstname;
    @SQLString_1(50)
    String lastname;
    @SQLInteger_1
    Integer age;
    @SQLString_1(value = 30, constrains = @Constrains_1(primaryKey = true))
    String handle;
    @SQLBoolean
    Boolean newMemberStatus;
    @SQLVarchar
    String address;
    @SQLDateTime
    String dateTime;
    @SQLBlob
    Photo photo;
    static int memberCount;
    public String getHandle() { return this.handle; }
    public String getFirstname() { return this.firstname; }
    public String getLastname() { return this.lastname; }
    public int getAge() { return this.age; }
    public Boolean getNewMemberStatus() { return this.newMemberStatus; }
    public String getAddress() { return this.address; }
    public String getDateTime() { return this.dateTime; }
    public Photo getPhoto() { return this.photo; }
    public String toString() { return this.handle; }
}
