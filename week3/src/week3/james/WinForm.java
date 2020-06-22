package week3.james;
/**
 * author:james
 * date: 2020-06-22
 */
public class WinForm extends Composite{
    private  String name ;
    public WinForm(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void Print() {
        System.out.println("WinForm:"+this.name);
        super.Print();
    }
}
