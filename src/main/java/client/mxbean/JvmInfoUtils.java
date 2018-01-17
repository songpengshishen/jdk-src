package client.mxbean;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用MxBean获取JVM运行信息
 * MXBean : 是一种符合JMX规范的接口Bean,用来监控管理jvm
 * @author wsp
 */
public class JvmInfoUtils {

    private GarbageCollectorMXBean youngGC; /*Java 虚拟机的垃圾回收的管理接口*/

    private GarbageCollectorMXBean fullGC; /*Java 虚拟机的垃圾回收的管理接口*/

    private ThreadMXBean threadMxBean; /*Java 虚拟机线程系统的管理接口*/

    private ClassLoadingMXBean classLoadingMXBean;/*Java 虚拟机类加载系统的管理接口*/

    private MemoryMXBean memoryMXBean; /*Java 虚拟机内存系统的管理接口*/

    private OperatingSystemMXBean operatingSystemMXBean;/*Java 虚拟机所在的操作系统管理接口*/

    public JvmInfoUtils(){
        this.threadMxBean = ManagementFactory.getThreadMXBean();
        this.classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
        this.operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        List gcList = ManagementFactory.getGarbageCollectorMXBeans();
        if(gcList != null && !gcList.isEmpty()) {
            if(gcList.size() == 1) {
                this.youngGC = (GarbageCollectorMXBean)gcList.get(0);
            } else if(gcList.size() >= 2) {
                this.youngGC = (GarbageCollectorMXBean)gcList.get(0);
                this.fullGC = (GarbageCollectorMXBean)gcList.get(1);
            }
        }
    }


    public static void main(String[] args) {
        JvmInfoUtils jvmInfoUtils = new JvmInfoUtils();
        List<byte[]> bytes = new ArrayList<byte[]>();
        for(;;){
            bytes.add(new byte[100]);
            System.out.println("youngGC 次数 : "  + jvmInfoUtils.youngGC.getCollectionCount());
            System.out.println("youngGC 时间 : "  + jvmInfoUtils.youngGC.getCollectionTime());
            System.out.println("youngGC 名称 : " + jvmInfoUtils.youngGC.getName());
            System.out.println("fullGC 次数 : "  + jvmInfoUtils.fullGC.getCollectionCount());
            System.out.println("fullGC 时间 : "  + jvmInfoUtils.fullGC.getCollectionTime());
            System.out.println("youngGC 名称 : " + jvmInfoUtils.fullGC.getName());
            System.out.println("操作系统名称: " + jvmInfoUtils.operatingSystemMXBean.getName());
        }
    }

}
