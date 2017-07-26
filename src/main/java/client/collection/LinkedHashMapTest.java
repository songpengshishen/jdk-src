package client.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap测试
 *  HashMap与LinkedHashMap在迭达时除了迭代Entry数组还会迭代桶中hash冲突导致的单向链表的所有元素.
 *  如果hashcode一样但是对象不一样是会重复迭代的,并且额外占用内存空间
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        HashMap<RepeatHashCode,String> map = new LinkedHashMap<RepeatHashCode,String>();
        map.put(new RepeatHashCode(),"1");
        map.put(new RepeatHashCode(),"2");
        Iterator<Map.Entry<RepeatHashCode, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
              Map.Entry<RepeatHashCode,String> entry =  it.next();
              System.out.println(entry);
        }
    }


    static class RepeatHashCode{
        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
