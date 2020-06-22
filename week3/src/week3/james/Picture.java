package week3.james;
import javax.swing.*;
/**
 * author:james
 * date: 2020-06-22
 */
public class Picture extends Composite {
    private  String name;
    public Picture(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("Picture:"+this.name);
    }
}
