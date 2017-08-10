package annotations.database;

/**
 * Created by anonymous.vn1985@gmail.com
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstname;
    @SQLString(50)
    String lastname;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constrains = @Constrains(primaryKey = true))
    String handle;
    static int memberCount;
    public String getHandle() {return this.handle;}
    public String getFirstname() {return this.firstname;}
    public String getLastname() {return this.lastname;}
    public Integer getAge() {return this.age;}
    public String toString() {return this.handle;}
}
