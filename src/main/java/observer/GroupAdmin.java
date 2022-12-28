package observer;

import java.util.ArrayList;

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
        System.out.println("Great to have you as a Member");
    }

    @Override
    public void unregister(Member obj) {
        this.MemberList.remove(obj);
        System.out.println("Hope you will register in the future");
    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset, obj);
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
    }

    @Override
    public void undo() {
        usb.Undo();
    }


}
//git try