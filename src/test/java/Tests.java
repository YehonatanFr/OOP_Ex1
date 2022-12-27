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
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        ConcreteMember member1 = new ConcreteMember(s1);
        ConcreteMember member2 = new ConcreteMember(s2);

        GroupAdmin groupAdmin = new GroupAdmin();

        groupAdmin.register(member1);
        groupAdmin.register(member2);

        member1.toString();

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
