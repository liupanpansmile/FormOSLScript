package onepam.synthetic.agent.config;





import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by liujian on 2015/6/19 10:58.
 */
public class XMLUtil {
    private static final Logger logger = LogManager.getLogger(XMLUtil.class.getName());
    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr xml对应的String
     * @param cls    xml对应的class类
     * @return T     xml对应的class类的实例对象
     * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);

    public static <T> T toBean(String xmlStr, Class<T> cls) {
        //注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }
     */

    /**
     * 从xml文件读取报文
     *
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @param cls class
     * @return T
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBeanFromFile(String absPath, String fileName, Class<T> cls) throws Exception {
        String filePath = absPath + fileName;
        InputStream ins;
        try {
            ins = new FileInputStream(new File(filePath));
        } catch (Exception e) {
            throw new Exception("read File {" + filePath + "} error!", e);
        }

        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj;
        try {
            obj = (T) xstream.fromXML(ins);
        } catch (Exception e) {
            throw new Exception("analysis XML{" + filePath + "}error!", e);
        }
        ins.close();
        return obj;
    }
}

