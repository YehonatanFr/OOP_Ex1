package observer;

public class ConcreteMember implements  Member{

    private String name;
    private UndoableStringBuilder Usb;

    public ConcreteMember(String str) {
        this.name = str;
        this.Usb = new UndoableStringBuilder(str);
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.setUsb(usb);
        this.name = Usb.toString();
    }

    public UndoableStringBuilder getUsb() {
        return Usb;
    }

    public void setUsb(UndoableStringBuilder usb) {
        this.Usb = usb;
    }

    public String toString()
    {
        return "" +name;
    }

}
