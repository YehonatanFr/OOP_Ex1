import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {


    //Creates for members
    String s1 = "Yossi";
    String s2 = "Yaacov";
    String s3 = "Alice";
    String s4 = "Bob";
    String s5 = "Pnina";
    String s6 = "Rachel";
    String s7 = "Nitzan";
    String s8 = "Maya";

    //Create new members
    ConcreteMember m1 = new ConcreteMember(s1);
    ConcreteMember m2 = new ConcreteMember(s2);
    ConcreteMember m3 = new ConcreteMember(s1);
    ConcreteMember m4 = new ConcreteMember(s2);
    ConcreteMember m5 = new ConcreteMember(s1);
    ConcreteMember m6 = new ConcreteMember(s2);
    ConcreteMember m7 = new ConcreteMember(s1);
    ConcreteMember m8 = new ConcreteMember(s2);

    //Create new group
    GroupAdmin groupAdmin = new GroupAdmin();

    @Test
    void register() {
        //Print the members(names) for self-checked if members are exist
        System.out.println(m1);
        System.out.println(m2);

        //Regiater new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //Checks that the members has register currently
        assertEquals(groupAdmin.MembersCurrently(),2);

        groupAdmin.register(m3);
        groupAdmin.register(m4);

        assertEquals(groupAdmin.MembersCurrently(),4);
    }

    @Test
    void unregister() {
        //The current size is 0
        System.out.println(groupAdmin.MembersCurrently());
        //Regiater new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        //Print the cuurent size of the group
        System.out.println(groupAdmin.MembersCurrently());

        //Unregister the members, the size should be 0
        groupAdmin.unregister(m1);
        groupAdmin.unregister(m2);

        assertEquals(groupAdmin.MembersCurrently(), 0);

    }

    @Test
    void insert() {
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //Make some changes on usb-in groupadmin
        groupAdmin.append(s3);
        groupAdmin.insert(1, s4);
        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void append() {

    }

    @Test
    void delete() {

    }

    @Test
    void undo() {

    }

    @Test
    void notifyMembers() {

    }
}