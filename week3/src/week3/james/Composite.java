package week3.james;

import java.util.ArrayList;
import java.util.List;

/**
 * author:james
 * date: 2020-06-22
 * 组件组合器
 */
public class Composite extends Component {
    private List<Component> components = new ArrayList<Component>();
    private String name ;
    public Composite(String name) {
        super(name);
        this.name=name;
    }
    public void  addComponent(Component component){
        this.components.add(component);
    }

    public void  removeComponent(Component component){
        this.components.remove(component);
    }

    @Override
    public void Print() {
        for (Component item:components      ) {
            item.Print();
        }
    }

}
