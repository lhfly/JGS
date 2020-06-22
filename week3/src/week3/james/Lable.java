package week3.james;
/**
 * author:james
 * date: 2020-06-22
 */
public class Lable extends Component {
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
