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
    String s2 = "Yaakov";
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
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Print the members(names) for self-checked if members are exist
        System.out.println(m1);
        System.out.println(m2);

        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //printing the memoryStats of groupAdmin after adding two members.
        System.out.println("The groupAdmin memory use  after adding two members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Checks if the members has register currently
        assertEquals(groupAdmin.MembersCurrently(),2);
        groupAdmin.register(m3);
        groupAdmin.register(m4);

        assertEquals(groupAdmin.MembersCurrently(),4);
    }

    @Test
    void unregister() {
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
        //The current size is 0
        System.out.println(groupAdmin.MembersCurrently());

        //Regiater new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //printing the memoryStats of groupAdmin after adding two members.
        System.out.println("The groupAdmin memory use  after adding two members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Print the cuurent size of the group
        System.out.println(groupAdmin.MembersCurrently());

        //Unregister the members, the size should be 0
        groupAdmin.unregister(m1);
        groupAdmin.unregister(m2);

        //printing the memoryStats of groupAdmin after unregister the two members we added before.
        System.out.println("The groupAdmin memory use after unregister the two members we added before.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        assertEquals(groupAdmin.MembersCurrently(), 0);

    }

    @Test
    void insert() {
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //printing the memoryStats of groupAdmin after adding two members.
        System.out.println("The groupAdmin memory use  after adding two members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);
        groupAdmin.insert(1, s4);

        //printing the memoryStats of groupAdmin after the usb has changed for all the members.
        System.out.println("The groupAdmin memory use after the usb has changed for all the members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void append() {
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //printing the memoryStats of groupAdmin after adding two members.
        System.out.println("The groupAdmin memory use  after adding two members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);

        //printing the memoryStats of groupAdmin after append new 'usb' to the members.
        System.out.println("The groupAdmin memory use after append new 'usb' to the members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Check some test
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void delete() {
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);

        //printing the memoryStats of groupAdmin after adding two members.
        System.out.println("The groupAdmin memory use  after adding two members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make some changes on usb-in GroupAdmin
        groupAdmin.append(s3);
        groupAdmin.delete(0,4);

        //printing the memoryStats of groupAdmin after the usb has changed be 'delete' function for all the members.
        System.out.println("The groupAdmin memory use after the usb has changed be 'delete' function for all the members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Test chalking
        assertEquals(groupAdmin.getUsb(),m1.getUsb());
        assertEquals(groupAdmin.toString(), groupAdmin.getMemberList().toString());
    }

    @Test
    void undo() {
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);

        //printing the memoryStats of groupAdmin after adding three members.
        System.out.println("The groupAdmin memory use  after adding three members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make some changes on usb-in GroupAdmin
        groupAdmin.undo();
        groupAdmin.undo();

        //printing the memoryStats of groupAdmin after the usb has changed be 'undo' function for all the members.
        System.out.println("The groupAdmin memory use after the usb has changed be 'undo' function for all the members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        assertEquals(groupAdmin.getUsb(),m1.getUsb());
    }

    @Test
    void notifyMembers() {
        UndoableStringBuilder usb = new UndoableStringBuilder(s4);
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);

        //printing the memoryStats of groupAdmin after adding three members.
        System.out.println("The groupAdmin memory use  after adding three members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make actions and tests
        groupAdmin.notifyMembers(usb);

        //printing the memoryStats of groupAdmin after the usb has changed be 'notifyMembers' function for all the members.
        System.out.println("The groupAdmin memory use after the usb has changed be 'notifyMembers' function for all the members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        assertEquals(m1.getUsb().toString(), s4);
    }

    @Test
    void update() {
        UndoableStringBuilder usb = new UndoableStringBuilder(s4);
        //printing the memoryStats of groupAdmin before adding members.
        System.out.println("The groupAdmin memory use before adding members");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Register new members
        groupAdmin.register(m1);
        groupAdmin.register(m2);
        groupAdmin.register(m3);

        //printing the memoryStats of groupAdmin after adding three members.
        System.out.println("The groupAdmin memory use  after adding three members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        //Make actions and tests
        groupAdmin.notifyMembers(usb);

        //printing the memoryStats of groupAdmin after the usb has changed be 'update' function for all the members.
        System.out.println("The groupAdmin memory use after the usb has changed be 'update' function for all the members.");
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

        assertEquals(m1.getUsb().toString(), s4);
    }


}
