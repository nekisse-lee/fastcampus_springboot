package com.nekisse.myweb;


import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void testEncoding() throws Exception {
        PasswordEncoder passwordEncoder =
                 PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodeStr = passwordEncoder.encode("aa");
        System.out.println(encodeStr);
    }
}
