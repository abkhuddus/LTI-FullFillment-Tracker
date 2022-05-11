package com.lti.user.util;

import java.util.Arrays;
public class ReferralConfig {
    
    public final static char PATTERN_PLACEHOLDER = '#';
    
    public static class Charset {
        public static final String ALPHABETIC   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public static final String ALPHANUMERIC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public static final String NUMBERS      = "0123456789";
    }
    
    private final Integer length;
    private final String charset;
    private final String prefix;
    private final String postfix;
    private final String pattern;
      
    public ReferralConfig(Integer length, String charset, String prefix, String postfix, String pattern) {
        if (length == null) {
            length = 8;
        }
        
        if (charset == null) {
            charset = Charset.ALPHANUMERIC;
        }
        
        if (pattern == null) {
            char[] chars = new char[length];
            Arrays.fill(chars, PATTERN_PLACEHOLDER);
            pattern = new String(chars);
        }
        
        this.length = length;
        this.charset = charset;
        this.prefix = prefix;
        this.postfix = postfix;
        this.pattern = pattern;        
    }
    
    public static ReferralConfig length(Integer length) {
        return new ReferralConfig(length, null, null, null, null);
    }
    
    public static ReferralConfig pattern(String pattern) {
        return new ReferralConfig(null, null, null, null, pattern);
    }

    public Integer getLength() {
        return length;
    }

    public String getCharset() {
        return charset;
    }
    
    public ReferralConfig withCharset(String charset) {
        return new ReferralConfig(length, charset, prefix, postfix, pattern);
    }

    public String getPrefix() {
        return prefix;
    }
    
    public ReferralConfig withPrefix(String prefix) {
        return new ReferralConfig(length, charset, prefix, postfix, pattern);
    }

    public String getPostfix() {
        return postfix;
    }
    
    public ReferralConfig withPostfix(String postfix) {
        return new ReferralConfig(length, charset, prefix, postfix, pattern);
    }

    public String getPattern() {
        return pattern;
    }
    
    @Override
    public String toString() {
        return "CodeConfig ["
                + "length="  + length  + ", "
                + "charset=" + charset + ", "
                + "prefix="  + prefix  + ", "
                + "postfix=" + postfix + ", "
                + "pattern=" + pattern + "]";
    }
}
