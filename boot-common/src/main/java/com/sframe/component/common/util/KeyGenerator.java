package com.sframe.component.common.util;

import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/15 2017, 上午12:06
 */
@NoArgsConstructor
public class KeyGenerator {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 自动生成主键值，uuid 作为主键
     * @return
     */
    public static String getUuid(){
        String keyId = UUID.randomUUID().toString().replaceAll("-", "");
        return keyId;
    }

    /**
     * 生成业务主键（纳秒作为业务主键）
     * @param	type	业务类型
     * @return	String
     */
    public static String getBusinessCode(){
        long keyId = System.nanoTime();
        return String.valueOf(keyId);
    }

    /**
     * 获取8位uuid<p>
     * <b>警告：此方法不保证绝对唯一，使用时，应该校验唯一性</b>
     * <p>
     * 经单for循环 10000000 次测试，没有出现重复
     * @return  String
     */
    public static String getUUID8Characters() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

}
