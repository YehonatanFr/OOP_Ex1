package observer;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupAdmin implements Sender {
    //The variable usb is the status describer of the Changes.
    private UndoableStringBuilder usb;
    //The ArrayList MemberList is for keeping all the members in the group.
    private ArrayList<Member> MemberList;

    public GroupAdmin() {
        this.MemberList = new ArrayList<>();
        this.usb = new UndoableStringBuilder();
    }

    /**
     * function that gives us the current number of members in the memberList in order to allow us to run tests on tha register function
     * @return number of members.
     */
    public int MembersCurrently()
    {
        return MemberList.size();
    }

    /**
     * Implements register from Sender interface (observer).
     * @param obj adding the member that created by ConcreteMember to the MemberList.
     */
    @Override
    public void register(Member obj) {
        this.MemberList.add(obj);
        System.out.println("Great to have you as a Member: "+obj.toString());
    }

    /**
     * Implements unregister from Sender interface (observer).
     * @param obj = removing the member that the function gets from the MemberList.
     */
    @Override
    public void unregister(Member obj) {
        this.MemberList.remove(obj);
        System.out.println("Hope you will register in the future: "+obj.toString());
    }

    /**
     *  Implements unregister from Sender interface (observer).
     * @param offset = the index to start in implementing the new strung in usb
     * @param obj = the index to end in implementing the new strung in usb
     */
    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset, obj);
        notifyMembers(usb);
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyMembers(usb);
    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyMembers(usb);
    }

    @Override
    public void undo() {
        usb.Undo();
        notifyMembers(usb);
    }

    public void notifyMembers(UndoableStringBuilder usb){
        for (Member member: this.MemberList){
            member.update(usb);
        }
    }

    public UndoableStringBuilder getUsb() {
        return usb;
    }

    public void setUsb(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    public ArrayList<Member> getMemberList() {
        return MemberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        MemberList = memberList;
    }

    public String toString()
    {
        return MemberList.toString();
    }

}
