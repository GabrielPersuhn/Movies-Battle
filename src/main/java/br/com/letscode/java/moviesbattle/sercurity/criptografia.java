package br.com.letscode.java.moviesbattle.sercurity;

import org.apache.commons.codec.digest.DigestUtils;

public class criptografia {

    public String encode(String plainPassword) {
        return DigestUtils.sha1Hex(plainPassword);

    }
}
