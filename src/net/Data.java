package net;

public class Data {
	
	private int type;//0:chat  1:unit  2:science
	private String content;

	public Data(int type, String content) {
		this.type = type;
		this.content = content;
	}
	
	public String toString(){
		return type+" "+content;
	}
	
	public static int getType(String s){
		String[] ss = s.split(" ");
		return Integer.parseInt(ss[0]);
	}
	
	public static String getContent(String s){
		String[] ss = s.split(" ");
		return ss[1];
	}
}
