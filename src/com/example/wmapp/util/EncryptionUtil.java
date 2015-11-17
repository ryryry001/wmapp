package com.example.wmapp.util;

/**
 * 
 * 加解密辅助类
 * 用于敏感信息的加解密
 * 
 * @author rongyue
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
