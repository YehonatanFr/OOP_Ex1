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
    }

    @Override
    public void register(Member obj) {
        this.MemberList.add(obj);
        System.out.println("Great to have you as a Member: "+obj.toString());
    }

    @Override
    public void unregister(Member obj) {
        this.MemberList.remove(obj);
        System.out.println("Hope you will register in the future: "+obj.toString());
    }

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

    public String toString()
    {
        return MemberList.toString();
    }


}
