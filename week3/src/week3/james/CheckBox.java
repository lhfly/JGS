package week3.james;
/**
 * author:james
 * date: 2020-06-22
 */
public class CheckBox extends Composite {
    private  String name;
    public CheckBox(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("CheckBox:"+name);
    }
}
