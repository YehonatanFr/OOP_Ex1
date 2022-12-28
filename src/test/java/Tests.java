import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    //Creates for members
    String s1 = "Yossi";
    String s2 = "Yaacov";
    String s3 = "Alice";
    String s4 = "Bob";

    //Create new members
    ConcreteMember m1 = new ConcreteMember(s1);
    ConcreteMember m2 = new ConcreteMember(s2);
    ConcreteMember m3 = new ConcreteMember(s3);
    ConcreteMember m4 = new ConcreteMember(s4);

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


        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);
        groupAdmin.insert(1, s4);
        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void append() {
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);
        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void delete() {
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);
        groupAdmin.delete(0,4);
        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void undo() {
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);
        //Make some changes on usb-in GroupAdmin
        groupAdmin.undo();
        groupAdmin.undo();
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
    }

    @Test
    void notifyMembers() {
        UndoableStringBuilder usb = new UndoableStringBuilder(s4);
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);
        //Make actions and tests
        groupAdmin.notifyMembers(usb);
        assertEquals(m1.getUsb().toString(), s4);
    }

    @Test
    void update() {
        UndoableStringBuilder usb = new UndoableStringBuilder(s4);
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);
        //Make actions and tests
        groupAdmin.notifyMembers(usb);
        assertEquals(m1.getUsb().toString(), s4);
    }

}
