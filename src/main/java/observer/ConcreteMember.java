package observer;

public class ConcreteMember implements  Member{

    private UndoableStringBuilder Usb;
    @Override
    public void update(UndoableStringBuilder usb) {
        this.setUsb(usb);
    }

    public UndoableStringBuilder getUsb() {
        return Usb;
    }

    public void setUsb(UndoableStringBuilder usb) {
        Usb = usb;
    }

}
