package client.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HashMap测试
 * HashMap与LinkedHashMap在迭达时除了迭代Entry数组还会迭代桶中hash冲突导致的单向链表的所有元素.
 * 如果hashcode一样但是对象不一样是会重复迭代的,并且额外占用内存空间
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<LinkedHashMapTest.RepeatHashCode,String> map = new HashMap<LinkedHashMapTest.RepeatHashCode,String>();
        LinkedHashMapTest.RepeatHashCode repeatHashCode = new LinkedHashMapTest.RepeatHashCode();
        map.put(repeatHashCode,"1");
        map.put(repeatHashCode,"2");
        Set<LinkedHashMapTest.RepeatHashCode> keyStr =   map.keySet();
        Iterator<LinkedHashMapTest.RepeatHashCode> it =  keyStr.iterator();
        while (it.hasNext()){
            LinkedHashMapTest.RepeatHashCode key = null;
            System.out.println("key = " + (key = it.next()) + "\tvalue = " + map.get(key));
        }
        System.out.println(map.size());
    }



}
