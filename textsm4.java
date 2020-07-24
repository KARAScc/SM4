package com.text;

import com.commons.sm4.*;
import java.util.*;

public class textsm4 {
	public static void main(String[] args) {		
		 try {
			 Sm4Util sm4util = new Sm4Util();
			 
			 System.out.println("输入需要加密的字符串：");
			 Scanner in = new Scanner(System.in);
			 String paramstr = in.nextLine();
			 
//			 String paramstr = "{sadadsad1451131}";
//			 System.out.println("加密字符串："+paramstr);
			 
			 // 自定义的32位16进制密钥
			 String key = "86C63180C2806ED1F47B859DE501215B";
			 String cipher = sm4util.encryptEcb(key, paramstr);
			 System.out.println("自定义密钥加密后的字符："+cipher);
			 System.out.println("加密前后字符是否相同："+sm4util.verifyEcb(key, cipher, paramstr));// true
			 // 解密
			 paramstr = sm4util.decryptEcb(key, cipher);
			 System.out.println("解密后的字符串："+paramstr);
			 System.out.println("\n");
			 
			 // 自动生成密钥
			 byte[] generateKey = sm4util.generateKey();
			 System.out.println(generateKey);
			 String cipher2 = sm4util.encryptEcb(generateKey, paramstr);				 
			 System.out.println("默认密钥加密后的字符："+cipher2);
			 System.out.println("加密前后字符是否相同："+sm4util.verifyEcb(generateKey, cipher2, paramstr));// true
			 // 解密
			 paramstr = sm4util.decryptEcb(generateKey, cipher2);
			 System.out.println("解密后的字符串："+paramstr);						 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}
