package com.sframe.component.common.util.encrypt;

import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

/**
 * @author mumu
 * @vervion v1.0
 * @description Base64 工具类
 * @date 16/9/18 2016, 下午10:47
 */
@NoArgsConstructor
public class Base64Util {

//////////////////////////////////// 编码

    /**
     * 使用 commons codec jar包进行 base64 对字节数组编码,返回字节数组
     * @param data  被编码的字节数组
     * @return
     */
    public static byte[] encryptBase64ToByte(byte[] data){
        Base64 base64 = new Base64();
        return base64.encode(data);
    }

    /**
     * 使用 commons codec jar包进行 base64 对字符串编码,返回字节数组
     * @param data  被编码的字符串
     * @return
     */
    public static byte[] encryptBase64ToByte(String data){
        return encryptBase64ToByte(data.getBytes());
    }

    /**
     * 使用 commons codec jar包进行 base64 对字节数组编码,返回字符串
     * @param data  被编码的字节数组
     * @return
     */
    public static String encryptBase64ToString(byte[] data){
        return new String(encryptBase64ToByte(data));
    }

    /**
     * 使用 commons codec jar包进行 base64 对字符串编码,返回字符串
     * @param data  被编码的字符串
     * @return
     */
    public static String encryptBase64ToString(String data){
        return new String(encryptBase64ToByte(data));
    }

//////////////////////////////////// 解码

    /**
     * 使用 commons codec jar包进行 base64 对字节数组解码,返回字节数组
     * @param data  需要解码的字节数组
     * @return
     */
    public static byte[] decryptBase64ToByte(byte[] data){
        Base64 base64 = new Base64();
        return base64.decode(data);
    }

    /**
     * 使用 commons codec jar包进行 base64 对字符串解码,返回字节数组
     * @param data  需要解码的字符串
     * @return
     */
    public static byte[] decryptBase64ToByte(String data){
        return decryptBase64ToByte(data.getBytes());
    }

    /**
     * 使用 commons codec jar包进行 base64 对字节数组解码,返回字符串
     * @param data  需要解码的字节数组
     * @return
     */
    public static String decryptBase64ToString(byte[] data){
        return new String(decryptBase64ToByte(data));
    }

    /**
     * 使用 commons codec jar包进行 base64 对字符串解码,返回字符串
     * @param data  需要解码的字符串
     * @return
     */
    public static String decryptBase64ToString(String data){
        return new String(decryptBase64ToByte(data));
    }

}
