package client;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * JDK源码执行者
 * @author wangsongpeng
 */
public class Executor {


    public static void main(String args[]){
        Executor.JDKClassLoader jdkClassLoader = new Executor.JDKClassLoader();
    }



    static class JDKClassLoader extends ClassLoader{

        private Map<String,Class> map = new HashMap<String,Class>();

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            String classPath =  getLoadClassUrl(name);
            byte[] bytes = getClassByte(classPath);
            return super.defineClass("jdkClassLoader-"+name,bytes,0,bytes.length);
        }

        private String getLoadClassUrl(String name){
            if(null==name&&name.isEmpty()){
              throw new NullPointerException("name is Null!");
            }
            return name+".class";
        }

        private byte[] getClassByte(String classPath){
            byte[] bytes = null;
            try(InputStream in = getResourceAsStream(classPath)) {
                bytes = new byte[in.available()];
                in.read(bytes);
            }catch (Exception e){
                e.printStackTrace();
            }
            return bytes;
        }
    }

}
