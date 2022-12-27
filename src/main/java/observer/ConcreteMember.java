package observer;

public class ConcreteMember implements  Member{

    private UndoableStringBuilder Usb;

    public ConcreteMember(String str) {
        this.Usb = new UndoableStringBuilder(str);
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.setUsb(usb);
    }

    public UndoableStringBuilder getUsb() {
        return Usb;
    }

    public void setUsb(UndoableStringBuilder usb) {
        this.Usb = usb;
    }

}
