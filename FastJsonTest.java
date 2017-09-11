package FastJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FastJson.bo.Group;
import FastJson.bo.User;
import FastJson.bo.Weibo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
  
//������FastJson�ļ�飺���õķ�����  
//  Fastjson API�������com.alibaba.fastjson.JSON�����õ����л�������������JSON���ϵľ�̬����ֱ����ɡ�  
//  public static final Object parse(String text); // ��JSON�ı�parseΪJSONObject����JSONArray   
//  public static final JSONObject parseObject(String text)�� // ��JSON�ı�parse��JSONObject      
//  public static final <T> T parseObject(String text, Class<T> clazz); // ��JSON�ı�parseΪJavaBean   
//  public static final JSONArray parseArray(String text); // ��JSON�ı�parse��JSONArray   
//  public static final <T> List<T> parseArray(String text, Class<T> clazz); //��JSON�ı�parse��JavaBean����   
//  public static final String toJSONString(Object object); // ��JavaBean���л�ΪJSON�ı�   
//  public static final String toJSONString(Object object, boolean prettyFormat); // ��JavaBean���л�Ϊ����ʽ��JSON�ı�   
//  public static final Object toJSON(Object javaObject); ��JavaBeanת��ΪJSONObject����JSONArray�������淽���������Ƿ���ֵ�ǲ�һ���ģ�  
  
/** 
 * ���ǹ���FastJson��һ��ʹ��Demo����Java��������֤�ģ� 
 * ʹ�õ�ʱ����Բ���������ӽ��л��䣡 
 * ��ע������д��Json��ʽ������"ǰ���\����˼�Ǹ��߱��������Ե��������"�� 
 * ���涨���������ࣺUser��Group��Weibo 
 * @author liuzhao 
 */  
public class FastJsonTest {  
  
    public static void main(String[] args) {  
          
        json2JsonObjectM1();//��Json�ı�������Ϣת��ΪJsonObject����Ȼ�����ü�ֵ�Եķ�ʽ��ȡ��Ϣ  
        json2BeanM2();//��Json�ı�����ת��ΪJavaBean���ݣ�  
        json2JSONArrayM3();//��json����ת��ΪJSONArray:   
        json2JavaBeanM4();//��JSON�ı�ת��ΪJavaBean�ļ��ϣ�ת��Ϊ������1��Object��parseObject(String text, Class<T> clazz);   
        bean2JsonM5();//��JavaBeanת��ΪJson��ʽ������/Json�ı� �û����ݵĴ��ݣ������ϴ�������  
        bean2JSONObjectM6();//��JavaBeanת��ΪJSON����  
        complexExampleM7();//һ����Ը��ӵ����ӣ�  
        complex2JsonM8();//һ�����ӵ�Object��Json��Demo  
        complexMap2JsonM9();//��Map����ת��ΪJsonString��Demo�������RedBoy����˲���ֱ�������  
    }  
  
    /** 
     * ��Json�ı�������Ϣת��ΪJsonObject����Ȼ�����ü�ֵ�Եķ�ʽ��ȡ��Ϣ 
     */  
    private static void json2JsonObjectM1() {  
        //һ��JsonObject�ı�����  
        String s = "{\"name\":\"liuzhao\"}";  
        //��JsonObject����ת��ΪJson  
        JSONObject object = JSON.parseObject(s);  
        //���ü�ֵ�Եķ�ʽ��ȡ��ֵ  
        System.out.println(object.get("name"));  
        /** 
         * ��ӡ�� 
         * liuzhao 
         */  
    }  
      
    /** 
     * ��Json�ı�����ת��ΪJavaBean���ݣ� 
     * ��Ҫע����ǣ���ʱ���Json�ı���Ϣ�еļ������Ʊ����JavaBean�е��ֶ�����һ��������û�е������JavaBean�о���ʾΪnull�� 
     */  
    private static void json2BeanM2() {  
        String s = "{\"id\":\"0375\",\"city\":\"ƽ��ɽ\"}";  
        //һ���򵥷��� �ķ�����Json�ı���Ϣת��ΪJsonObject�����ͬʱת��ΪJavaBean����  
        Weibo weibo = JSON.parseObject(s, Weibo.class);//Weibo�����±߶���  
        System.out.println(weibo.getId());  
        System.out.println(weibo.getCity());  
        //��ӡ�Ľ��     0375  
        //              ƽ��ɽ  
    }  
  
  
    /** 
     * ��Map���͵�����ת��ΪJsonString 
     */  
    private static void complexMap2JsonM9() {  
        Group group = new Group();  
        group.setId(1);  
        group.setName("group");  
          
        User user1 = new User();  
        user1.setId(2);  
        user1.setName("user1");  
  
        User user2 = new User();  
        user2.setId(3);  
        user2.setName("user2");  
        group.getList().add(user1);  
        group.getList().add(user2);  
          
        Map<Integer, Object> map = new HashMap<Integer,Object>();  
        map.put(1, "No.1");  
        map.put(2, "No.2");  
        map.put(3, group.getList());  
          
        String jsonString = JSON.toJSONString(map);  
        System.out.println(jsonString);  
        /** 
         *  �����{1:"No.1",2:"No.2",3:[{"id":2,"name":"user1"},{"id":3,"name":"user2"}]} 
         */  
    }  
  
    /** 
     * ��һ�����ӵ�Object��Json��Demo 
     */  
    private static void complex2JsonM8() {  
        Group group = new Group();  
        group.setId(1);  
        group.setName("group");  
          
        User user1 = new User();  
        user1.setId(2);  
        user1.setName("user1");  
  
        User user2 = new User();  
        user2.setId(3);  
        user2.setName("user2");  
        group.getList().add(user1);  
        group.getList().add(user2);  
        String jsonString = JSON.toJSONString(group);  
        System.out.println(jsonString);  
        /** 
         *  �����{"id":1,"list":[{"id":2,"name":"user1"},{"id":3,"name":"user2"}],"name":"group"} 
         */  
    }  
  
    /** 
     * һ����Ը��ӵ����ӣ� 
     * JSON�ı����ݣ� 
     *      ������JSONObject��ת��ΪJSONArray�� 
     *      Ȼ��JSONArrayת��ΪJavaBean 
     */  
    private static void complexExampleM7() {  
        String s = "{js:[{id:\"110000\",\"city\":\"��#001����\"},{id:\"110000\",\"city\":\"��#002����\"}"  
                + ",{id:\"110000\",\"city\":\"��#002����\"},{id:\"110000\",\"city\":\"��#002����\"},"  
                + "{id:\"110000\",\"city\":\"#006��#005����\"},"  
                + "{id:\"110000\",\"city\":\"��#002����\"},"  
                + "{id:\"110000\",\"city\":\"��#002����\"},{id:\"120000\",\"city\":\"��#009����\"}]}";  
          
        JSONObject object = JSON.parseObject(s);  
        Object jsonArray = object.get("js");  
        System.out.println(jsonArray);  
        List<Weibo> list = JSON.parseArray(jsonArray+"", Weibo.class);  
        for (Weibo weibo : list) {  
            System.out.println(weibo.getCity());  
        }  
    }  
  
    /** 
     * ��JavaBeanת��ΪJSON���� 
     */  
    private static void bean2JSONObjectM6() {  
        Weibo weibo = new Weibo("0373", "����");  
        JSONObject json = (JSONObject) JSON.toJSON(weibo);  
        System.out.println(json.get("id"));  
        /** 
         * ��ӡ�� 
         * 0373 
         */  
    }  
  
    /** 
     * ��JSON�ı�ת��ΪJavaBean�ļ��ϣ� 
     * �ڲ�ʵ�ֿ϶��ǣ�����ת��ΪJSONArray��Ȼ����ת��ΪList���� 
     */  
    private static void json2JavaBeanM4() {  
        String s = "[{\"id\":\"0375\",\"city\":\"ƽ��ɽ\"},{\"id\":\"0377\",\"city\":\"����\"}]";  
        List<Weibo> list = JSON.parseArray(s, Weibo.class);  
        for (Weibo weibo : list) {  
            System.out.println(weibo.getCity());  
        }  
        /** 
         * ��ӡ�� 
         * ƽ��ɽ 
         * ���� 
         */  
    }  
  
    /** 
     * ��json����ת��ΪJSONArray: 
     * ע�⣺��ȡ��JSONArray֮����������ֻ�ǻ�ȡ��JSONArray������JavaBean��List���ϣ� 
     * ��ȡJSONArray�е�����ת��ΪString������Ҫ����߼�""; 
     */  
    private static void json2JSONArrayM3() {  
        String s = "[{\"id\":\"0375\",\"city\":\"ƽ��ɽ\"},{\"id\":\"0377\",\"city\":\"����\"}]";  
        //��JSON�ı�ת��ΪJSONArray  
        JSONArray array = JSON.parseArray(s);  
        //���б���д���������+"";��Ȼ�ᱨ������ǿת�쳣��  
        String str = array.get(1)+"";  
        System.out.println(array.get(0));  
        JSONObject object = JSON.parseObject(str);  
        System.out.println(object.get("id"));  
        /** 
         * {"city":"ƽ��ɽ","id":"0375"} 
            0377 
         */  
    }  
  
  
    /** 
     * ��JavaBeanת��ΪJson��ʽ������/Json�ı� 
     * �û����ݵĴ��ݣ������ϴ������� 
     */  
    private static void bean2JsonM5() {  
        Weibo weibo = new Weibo("123456", "�Ϻ�");  
        String string = JSON.toJSONString(weibo);  
        System.out.println(string);  
        /** 
         * ��ӡ�� 
         * {"city":"�Ϻ�","id":"123456"} 
         */  
    }  
  
}
