package com.yq.test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * <p> test</p>
 * @author youq  2020/1/21 13:19
 */
public class TestMain {

    private static Logger log = LogManager.getLogger(TestMain.class);

    public static void main(String[] args) {
        jasyptTest();
    }

    public static void jasyptTest() {
        StandardPBEStringEncryptor strongEncryptor = new StandardPBEStringEncryptor();
        strongEncryptor.setAlgorithm("PBEWithMD5AndDES");
        strongEncryptor.setPassword("unioncast@Password!@#*%^");
        //每次运行出现的加密结果是完全不同的，但是解密出来是一样的。
        String encryptData = strongEncryptor.encrypt("nkipwd");
        log.info("[nkipwd] jasypt encrypt: {}", encryptData);
        String d1 = strongEncryptor.decrypt("i0JMklFlvw2JBKzuN3w9tw==");
        log.info("[i0JMklFlvw2JBKzuN3w9tw==] decrypt: {}", d1);
        String d2 = strongEncryptor.decrypt("Q+k3fKNwbWxIgQAoPpbT5Q==");
        log.info("[Q+k3fKNwbWxIgQAoPpbT5Q==] decrypt: {}", d2);
    }

}
