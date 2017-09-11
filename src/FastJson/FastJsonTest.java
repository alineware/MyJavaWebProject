package FastJson;

import com.alibaba.fastjson.JSONObject;

import FastJson.bo.Group;

public class FastJsonTest {
	public static void main(String[] args) {  
		String s = "{\"name\":\"group1\",\"id\":1,\"List\":[{\"name\":\"user1\",\"id\":1},{\"name\":\"user2\",\"id\":2}]}";
		JSONObject jo = JSONObject.parseObject(s);
		Group g = (Group) JSONObject.parseObject(s, Group.class);
		System.out.println(jo.get("name"));
		System.out.println(g.getId()+"--"+g.getName());
	}
}
