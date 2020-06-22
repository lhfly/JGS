package week3.james;

/**
 * author:james
 * date: 2020-06-22
 */
public class Lable extends Composite {
    private  String name;
    public Lable(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("Lable:"+name);
    }
}
