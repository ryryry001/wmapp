package com.example.wmapp.util;

/**
 * 
 * 加解密辅助类
 * 用于敏感信息的加解密
 * 
 * @author rongyue
 *




3.新建一个com.example.wmapp.data的包，包里面包含这几个类：
  1）DBHelper.java（继承自SQLiteOpenHelper，网上有很多资料），建立两张表ORDER和PERSON。ORDER表中的字段有自增id，订单号，下单时间戳，订单状态，商户名，商户id，价格。PERSON表中的字段有自增id，name，gender,phone，destination
  2）Person.java: 与表PERSON对应的java类，有四个量name，gender，phone，destination，提供对应的set，get方法。
  3）Order.java:与表ORDER对应的java类，提供orderNumber，time，status，shopname的get，set方法。

 *
 */
public class EncryptionUtil {
	
	

	  /**
	   *用户名MD5加密
	   *@param plainText 字符串
	   *@return String 返回加密字符串
	  */
	  public static String encrypt(String plainText)
	  {
	    try
	    {
	      byte[] _plainText = plainText.getBytes("ISO-8859-1");
	      String name = new String();
	     // char[] _plainText = plainText.toCharArray();
	      for (int i = 0; i < _plainText.length; i++) {
	          int asc = _plainText[i];
	          _plainText[i] = (byte) (asc + 27);
	          name = name + (asc + 27) + "%";
	      }
	      return name;
	    }catch(Exception e)
	    {
	      e.printStackTrace() ;
	      return null;
	    }
	  }

	  /**
	   *用户名解密
	   *@param encryptedText 字符串
	   *@return String 返回解密字符串
	  */
	  public static String decrypt(String encryptedText)
	  {
	    try
	    {
	      String name = new String();
	      java.util.StringTokenizer st=new java.util.StringTokenizer(encryptedText,"%");
	      while (st.hasMoreElements()) {
	        int asc =  Integer.parseInt((String)st.nextElement()) - 27;
	        name = name + (char)asc;
	      }

	      return name;
	    }catch(Exception e)
	    {
	      e.printStackTrace() ;
	      return null;
	    }
	  }
	
	
	
}
