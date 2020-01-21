package com.yq.jasypt.config.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.core.env.Environment;

import java.nio.charset.StandardCharsets;

/**
 * <p> 自定义Jasypt加解密类</p>
 * @author youq  2020/1/21 14:12
 */
@Slf4j
public class JasyptStringEncryptor implements StringEncryptor {

    private final StandardPBEByteEncryptor byteEncryptor;

    private final Base64 base64;

    public JasyptStringEncryptor() {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("suibiantianle");
        this.byteEncryptor = new StandardPBEByteEncryptor();
        this.byteEncryptor.setConfig(config);
        this.base64 = new Base64();
    }

    public JasyptStringEncryptor(Environment environment) {
        byteEncryptor = new StandardPBEByteEncryptor();
        byteEncryptor.setConfig(getConfig(environment));
        this.base64 = new Base64();
    }

    public JasyptStringEncryptor(String password) {
        SimplePBEConfig config = new SimplePBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword(password);
        byteEncryptor = new StandardPBEByteEncryptor();
        byteEncryptor.setConfig(config);
        this.base64 = new Base64();
    }

    @Override
    public String encrypt(String message) {
        byte[] encrypt = byteEncryptor.encrypt(message.getBytes());
        byte[] encode = base64.encode(encrypt);
        return new String(encode, StandardCharsets.UTF_8);
    }

    @Override
    public String decrypt(String encryptedMessage) {
        byte[] decode = base64.decode(encryptedMessage.getBytes());
        byte[] decrypt = byteEncryptor.decrypt(decode);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    private PBEConfig getConfig(Environment environment) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(getRequiredProperty(environment, "jasypt.encryptor.password"));
        config.setAlgorithm(getProperty(environment, "jasypt.encryptor.algorithm", "PBEWithMD5AndDES"));
        config.setKeyObtentionIterations(getProperty(environment, "jasypt.encryptor.keyObtentionIterations", "1000"));
        config.setPoolSize(getProperty(environment, "jasypt.encryptor.poolSize", "1"));
        config.setProviderName(getProperty(environment, "jasypt.encryptor.providerName", null));
        config.setSaltGeneratorClassName(getProperty(environment, "jasypt.encryptor.saltGeneratorClassname", "org.jasypt.salt.RandomSaltGenerator"));
        config.setStringOutputType(getProperty(environment, "jasypt.encryptor.stringOutputType", "base64"));
        return config;
    }

    private static String getProperty(Environment environment, String key, String defaultValue) {
        if (!propertyExists(environment, key)) {
            log.info("Encryptor config not found for property {}, using default value: {}", key, defaultValue);
        }
        return environment.getProperty(key, defaultValue);
    }

    private static String getRequiredProperty(Environment environment, String key) {
        if (!propertyExists(environment, key)) {
            throw new IllegalStateException(String.format("required encryption configuration property missing: %s", key));
        }
        return environment.getProperty(key);
    }

    private static boolean propertyExists(Environment environment, String key) {
        return environment.getProperty(key) != null;
    }

}
