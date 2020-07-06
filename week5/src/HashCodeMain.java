import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * author:james
 * date: 2020-07-06
 */
public class HashCodeMain {
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    private static SortedMap<String, Integer> countMap = new TreeMap<String, Integer>();

    private static String[] serverList = {
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",};

    public static void main(String[] args) {
        System.out.println("192.168.0.0:111的哈希值：" + "192.168.0.0:1111".hashCode());
        for (int i = 0; i < serverList.length; i++) {
            int hash = Math.abs(serverList[i].hashCode());
            System.out.println("[" + serverList[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, serverList[i]);

            countMap.put(serverList[i], 0);
        }

        for (int j = 0; j < 10000; j++) {
            String node = UUID.randomUUID().toString();
            String name = getServer(node);
            if (countMap.containsKey(name)) {
                countMap.replace(name, countMap.get(name) + 1);
            } else {
                countMap.put(name, 1);
            }
            System.out.println(name);
        }

        System.out.println(countMap.values());

        int server_count = 0;
        for (int item : countMap.values()) {
            server_count += item;
        }

        int avg = server_count / serverList.length;

        int sum = 0;
        for (int item : countMap.values()) {
            sum += Math.pow((item - avg), 2);
        }

        System.out.println("标准差：" + Math.sqrt(sum / serverList.length));

    }

    private static String getServer(String node) {
        // 得到带路由的结点的Hash值
        int hash = Math.abs(node.hashCode());
        System.out.print(hash);
        System.out.print("--");
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        Integer i = 0;
        if (subMap != null && !subMap.isEmpty()) {
            // 第一个Key就是顺时针过去离node最近的那个结点
            i = subMap.firstKey();
            return subMap.get(i);

        } else {
            i = sortedMap.lastKey();
            return sortedMap.get(i);

        }


    }
}
