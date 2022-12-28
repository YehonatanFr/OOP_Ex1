import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

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

        //Create new members
        ConcreteMember member1 = new ConcreteMember(s1);
        ConcreteMember member2 = new ConcreteMember(s2);

        //Test if create new members
        System.out.println(member1);
        System.out.println(member2);

        //Create new group
        GroupAdmin groupAdmin = new GroupAdmin();

        //Adding members to the group
        groupAdmin.register(member1);
        groupAdmin.register(member2);

        //Test if unregister members
        System.out.println(groupAdmin);
        groupAdmin.unregister(member1);
        System.out.println(groupAdmin);
    }

}
