package week3.james;

/**
 * author:james
 * date: 2020-06-22
 */
public class Frame extends Composite {
    private String name;
    public Frame(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("Frame:"+name);
        super.Print();
    }
}
