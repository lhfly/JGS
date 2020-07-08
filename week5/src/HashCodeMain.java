package src;

import sun.security.provider.MD5;

import java.security.MessageDigest;


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
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    };

    public static void main(String[] args) {
        for (int i = 0; i < serverList.length; i++) {
            int hash = GetHashCode(serverList[i]);
            sortedMap.put(hash, serverList[i]);
            countMap.put(serverList[i], 0);
        }

        for (int j = 0; j < 1000000; j++) {
            String node = UUID.randomUUID().toString();
            String name = getServer(node);
            if (countMap.containsKey(name)) {
                countMap.replace(name, countMap.get(name) + 1);
            } else {
                countMap.put(name, 1);
            }
        }

        //计算总数
        int server_count = 0;
        for (int item : countMap.values()) {
            server_count += item;
        }

        int avg = server_count / serverList.length;

        int sum = 0;
        for (int item : countMap.values()) {
            sum += Math.pow((item - avg), 2);
        }
        System.out.println("" + countMap);
        System.out.println("标准差：" + Math.sqrt(sum / serverList.length));

    }

    private static String getServer(String node) {
        int hash = GetHashCode(node);
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        Integer i = 0;
        if (subMap != null && !subMap.isEmpty()) {
            i = subMap.firstKey();
            return subMap.get(i);
        } else {
            i = sortedMap.lastKey();
            return sortedMap.get(i);
        }
    }

    public static int GetHashCode(String str) {
        str = encrypt(str);
        int b = 378551;
        int a = 63689;
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * a + str.charAt(i);
            a = a * b;
        }
        return (hash & 0x7FFFFFFF);
    }

    public static String encrypt(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
