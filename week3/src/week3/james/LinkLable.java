package week3.james;

/**
 * author:james
 * date: 2020-06-22
 */
public class LinkLable extends Composite {
    private  String name;
    public LinkLable(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("LinkLable:"+name);
    }
}
