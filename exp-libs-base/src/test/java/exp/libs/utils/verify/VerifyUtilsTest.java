package exp.libs.utils.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;


class VerifyUtilsTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsAscii() {
        Assertions.assertTrue(VerifyUtils.isASCII('0'));
        Assertions.assertTrue(VerifyUtils.isASCII('a'));
        Assertions.assertTrue(VerifyUtils.isASCII('A'));
        Assertions.assertTrue(VerifyUtils.isASCII('+'));
        Assertions.assertTrue(VerifyUtils.isASCII('\n'));
        Assertions.assertFalse(VerifyUtils.isASCII('天'));
    }

    @Test
    public void testIsAsciiCtrl() {
        Assertions.assertTrue(VerifyUtils.isASCIICtrl('\0'));
        Assertions.assertTrue(VerifyUtils.isASCIICtrl('\t'));
        Assertions.assertFalse(VerifyUtils.isASCIICtrl('A'));
        Assertions.assertFalse(VerifyUtils.isASCIICtrl('+'));
        Assertions.assertTrue(VerifyUtils.isASCIICtrl('\n'));
        Assertions.assertFalse(VerifyUtils.isASCIICtrl('天'));
    }

    @Test
    public void testIsRealNumber() {
        Assertions.assertFalse(VerifyUtils.isRealNumber("01234567"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("0"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("+0"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("-0"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("123.09"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("+123.09"));
        Assertions.assertTrue(VerifyUtils.isRealNumber("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isRealNumber("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isRealNumber("-"));
        Assertions.assertFalse(VerifyUtils.isRealNumber("+"));
        Assertions.assertFalse(VerifyUtils.isRealNumber("ab123"));
        Assertions.assertFalse(VerifyUtils.isRealNumber("xzy"));
    }

    @Test
    public void testIsPositiveReal() {
        Assertions.assertFalse(VerifyUtils.isPositiveReal("01234567"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("0"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("+0"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("-0"));
        Assertions.assertTrue(VerifyUtils.isPositiveReal("123.09"));
        Assertions.assertTrue(VerifyUtils.isPositiveReal("+123.09"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("-"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("+"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("ab123"));
        Assertions.assertFalse(VerifyUtils.isPositiveReal("xzy"));
    }

    @Test
    public void testIsNegativeReal() {
        Assertions.assertFalse(VerifyUtils.isNegativeReal("01234567"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("-04088"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("0"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("+0"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("-0"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("123.09"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("+123.09"));
        Assertions.assertTrue(VerifyUtils.isNegativeReal("-4088"));
        Assertions.assertTrue(VerifyUtils.isNegativeReal("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("-"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("+"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("ab123"));
        Assertions.assertFalse(VerifyUtils.isNegativeReal("xzy"));
    }

    @Test
    public void testIsNotNegativeReal() {
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("01234567"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-04088"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("+04088"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeReal("0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeReal("+0"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeReal("123.09"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeReal("+123.09"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-4088"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("-"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("+"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("ab123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeReal("xzy"));
    }

    @Test
    public void testIsIntegerNumber() {
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("01234567"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("-04088"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("+04088"));
        Assertions.assertTrue(VerifyUtils.isIntegerNumber("0"));
        Assertions.assertTrue(VerifyUtils.isIntegerNumber("+0"));
        Assertions.assertTrue(VerifyUtils.isIntegerNumber("-0"));
        Assertions.assertTrue(VerifyUtils.isIntegerNumber("123"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("123.09"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("+123.09"));
        Assertions.assertTrue(VerifyUtils.isIntegerNumber("-4088"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("-"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("+"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("ab123"));
        Assertions.assertFalse(VerifyUtils.isIntegerNumber("xzy"));
    }

    @Test
    public void testIsPositiveInteger() {
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("01234567"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-04088"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("+04088"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("0"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("+0"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-0"));
        Assertions.assertTrue(VerifyUtils.isPositiveInteger("123"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-123"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("123.09"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("+123.09"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-4088"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("-"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("+"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("ab123"));
        Assertions.assertFalse(VerifyUtils.isPositiveInteger("xzy"));
    }

    @Test
    public void testIsNegativeInteger() {
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("01234567"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("-04088"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("+04088"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("0"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("+0"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("-0"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("123"));
        Assertions.assertTrue(VerifyUtils.isNegativeInteger("-123"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("123.09"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("+123.09"));
        Assertions.assertTrue(VerifyUtils.isNegativeInteger("-4088"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("-"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("+"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("ab123"));
        Assertions.assertFalse(VerifyUtils.isNegativeInteger("xzy"));
    }

    @Test
    public void testIsNotNegativeInteger() {
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("01234567"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-04088"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("+04088"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeInteger("0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeInteger("+0"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeInteger("123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("123.09"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("+123.09"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("-"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("+"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("ab123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeInteger("xzy"));
    }

    @Test
    public void testIsFloatNumber() {
        Assertions.assertFalse(VerifyUtils.isFloatNumber("01234567"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("-04088"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("+04088"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("0"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("+0"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("-0"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("123"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("-123"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("123.09"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("+123.09"));
        Assertions.assertTrue(VerifyUtils.isFloatNumber("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("-"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("+"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("ab123"));
        Assertions.assertFalse(VerifyUtils.isFloatNumber("xzy"));
    }

    @Test
    public void testIsPositiveFloat() {
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("01234567"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-04088"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("+04088"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("0"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("+0"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-0"));
        Assertions.assertTrue(VerifyUtils.isPositiveFloat("123"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-123"));
        Assertions.assertTrue(VerifyUtils.isPositiveFloat("123.09"));
        Assertions.assertTrue(VerifyUtils.isPositiveFloat("+123.09"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("-"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("+"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("ab123"));
        Assertions.assertFalse(VerifyUtils.isPositiveFloat("xzy"));
    }

    @Test
    public void testIsNegativeFloat() {
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("01234567"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("-04088"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("+04088"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("0"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("+0"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("-0"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("123"));
        Assertions.assertTrue(VerifyUtils.isNegativeFloat("-123"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("123.09"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("+123.09"));
        Assertions.assertTrue(VerifyUtils.isNegativeFloat("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("-"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("+"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("ab123"));
        Assertions.assertFalse(VerifyUtils.isNegativeFloat("xzy"));
    }

    @Test
    public void testIsNotNegativeFloat() {
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("01234567"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-04088"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("+04088"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeFloat("0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeFloat("+0"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-0"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeFloat("123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-123"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeFloat("123.09"));
        Assertions.assertTrue(VerifyUtils.isNotNegativeFloat("+123.09"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-401.0026723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-401.0026.723424311"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("-"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("+"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("ab123"));
        Assertions.assertFalse(VerifyUtils.isNotNegativeFloat("xzy"));
    }

    @Test
    public void testIsDigits() {
        Assertions.assertTrue(VerifyUtils.isDigits("01234567"));
        Assertions.assertTrue(VerifyUtils.isDigits("0"));
        Assertions.assertFalse(VerifyUtils.isDigits("+0"));
        Assertions.assertFalse(VerifyUtils.isDigits("-0"));
        Assertions.assertFalse(VerifyUtils.isDigits("+123"));
        Assertions.assertFalse(VerifyUtils.isDigits("-401"));
        Assertions.assertFalse(VerifyUtils.isDigits("-"));
        Assertions.assertFalse(VerifyUtils.isDigits("+"));
        Assertions.assertFalse(VerifyUtils.isDigits("ab123"));
        Assertions.assertFalse(VerifyUtils.isDigits("xzy"));
    }

    @Test
    public void testIsLetterString() {
        Assertions.assertFalse(VerifyUtils.isLetter("0adg"));
        Assertions.assertFalse(VerifyUtils.isLetter("a%$%%"));
        Assertions.assertTrue(VerifyUtils.isLetter("Azxw"));
        Assertions.assertTrue(VerifyUtils.isLetter("g"));
        Assertions.assertFalse(VerifyUtils.isLetter("-+"));
        Assertions.assertFalse(VerifyUtils.isLetter("\n"));
        Assertions.assertFalse(VerifyUtils.isLetter("天"));
        Assertions.assertFalse(VerifyUtils.isLetter(""));
    }

    @Test
    public void testIsLetterChar() {
        Assertions.assertFalse(VerifyUtils.isLetter('0'));
        Assertions.assertTrue(VerifyUtils.isLetter('a'));
        Assertions.assertTrue(VerifyUtils.isLetter('A'));
        Assertions.assertFalse(VerifyUtils.isLetter('+'));
        Assertions.assertFalse(VerifyUtils.isLetter('\n'));
        Assertions.assertFalse(VerifyUtils.isLetter('天'));
    }

    @Test
    public void testIsUpperLetterString() {
        Assertions.assertFalse(VerifyUtils.isUpperLetter("0adg"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("a%$%%"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("Azxw"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("azxw"));
        Assertions.assertTrue(VerifyUtils.isUpperLetter("AZXW"));
        Assertions.assertTrue(VerifyUtils.isUpperLetter("B"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("-+"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("\n"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter("天"));
        Assertions.assertFalse(VerifyUtils.isUpperLetter(""));
    }

    @Test
    public void testIsUpperLetterChar() {
        Assertions.assertFalse(VerifyUtils.isUpperLetter('0'));
        Assertions.assertFalse(VerifyUtils.isUpperLetter('a'));
        Assertions.assertTrue(VerifyUtils.isUpperLetter('A'));
        Assertions.assertFalse(VerifyUtils.isUpperLetter('+'));
        Assertions.assertFalse(VerifyUtils.isUpperLetter('\n'));
        Assertions.assertFalse(VerifyUtils.isUpperLetter('天'));
    }

    @Test
    public void testIsLowerLetterString() {
        Assertions.assertFalse(VerifyUtils.isLowerLetter("0adg"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("a%$%%"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("Azxw"));
        Assertions.assertTrue(VerifyUtils.isLowerLetter("azxw"));
        Assertions.assertTrue(VerifyUtils.isLowerLetter("b"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("AZXW"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("-+"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("\n"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter("天"));
        Assertions.assertFalse(VerifyUtils.isLowerLetter(""));
    }

    @Test
    public void testIsLowerLetterChar() {
        Assertions.assertFalse(VerifyUtils.isLowerLetter('0'));
        Assertions.assertTrue(VerifyUtils.isLowerLetter('a'));
        Assertions.assertFalse(VerifyUtils.isLowerLetter('A'));
        Assertions.assertFalse(VerifyUtils.isLowerLetter('+'));
        Assertions.assertFalse(VerifyUtils.isLowerLetter('\n'));
        Assertions.assertFalse(VerifyUtils.isLowerLetter('天'));
    }

    @Test
    public void testIsDigitsOrLetterString() {
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("0adg"));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter("a%$%%"));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("Azxw"));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("azxw"));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("b"));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("1"));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter("AZXW"));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter("-+"));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter("\n"));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter("天"));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter(""));
    }

    @Test
    public void testIsDigitsOrLetterChar() {
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter('0'));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter('a'));
        Assertions.assertTrue(VerifyUtils.isDigitsOrLetter('A'));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter('+'));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter('\n'));
        Assertions.assertFalse(VerifyUtils.isDigitsOrLetter('天'));
    }

    @Test
    public void testIsUsername() {
        Assertions.assertFalse(VerifyUtils.isUsername("12345"));
        Assertions.assertFalse(VerifyUtils.isUsername("123456"));
        Assertions.assertFalse(VerifyUtils.isUsername("_123456"));
        Assertions.assertTrue(VerifyUtils.isUsername("sky123456"));
        Assertions.assertFalse(VerifyUtils.isUsername("sky231%$#"));
        Assertions.assertFalse(VerifyUtils.isUsername("123ddhs_dud"));
        Assertions.assertFalse(VerifyUtils.isUsername("12345_"));
        Assertions.assertFalse(VerifyUtils.isUsername("_12345"));
    }

    @Test
    public void testIsPassword() {
        Assertions.assertFalse(VerifyUtils.isPassword("12345"));
        Assertions.assertTrue(VerifyUtils.isPassword("123456"));
        Assertions.assertTrue(VerifyUtils.isPassword("_123456"));
        Assertions.assertTrue(VerifyUtils.isPassword("sky123456"));
        Assertions.assertTrue(VerifyUtils.isPassword("sky231%$#/!@~^&*(){}"));
        Assertions.assertTrue(VerifyUtils.isPassword("123ddhs_dud"));
        Assertions.assertTrue(VerifyUtils.isPassword("12345_"));
        Assertions.assertTrue(VerifyUtils.isPassword("_12345"));
    }

    @Test
    public void testIsFullwidthChar() {
        Assertions.assertTrue(VerifyUtils.isFullwidth("１２３４５"));
        Assertions.assertTrue(VerifyUtils.isFullwidth("ａｂｃｄｅｆｇ"));
        Assertions.assertFalse(VerifyUtils.isFullwidth("12345"));
        Assertions.assertFalse(VerifyUtils.isFullwidth("abcdefg"));
    }

    @Test
    public void testIsEmail() {
        Assertions.assertTrue(VerifyUtils.isEmail("abc@126.com"));
        Assertions.assertTrue(VerifyUtils.isEmail("123@hotmail.com"));
        Assertions.assertTrue(VerifyUtils.isEmail("_abc.123@qq.com"));
        Assertions.assertFalse(VerifyUtils.isEmail("_abc.123yahoo.com"));
        Assertions.assertFalse(VerifyUtils.isEmail("_abc@123@yahoo@com"));
        Assertions.assertFalse(VerifyUtils.isEmail("_abc#123@yahoo#org"));
    }

    @Test
    public void testIsHttp() {
        Assertions.assertTrue(VerifyUtils.isHttp("https://www.4008-517-517.cn/cn/?utm_source=baidu&utm_medium=cpc&utm_term=kfc%2525e7%2525bd%252591%2525e4%2525b8%25258a%2525e8%2525ae%2525a2%2525e9%2525a4%252590&utm_campaign=%2525e7%2525ab%25259e%2525e5%252593%252581%2525e8%2525af%25258d-%2525e5%2525b9%2525bf%2525e4%2525b8%25259c"));
        Assertions.assertTrue(VerifyUtils.isHttp("http://www.xp510.com/"));
        Assertions.assertTrue(VerifyUtils.isHttp("http://115.com/?goto=http%3A%2F%2F115.com%2F%3Fmode%3Dwangpan"));
        Assertions.assertFalse(VerifyUtils.isHttp("www.youbiyao.net/?y"));
        Assertions.assertFalse(VerifyUtils.isHttp("127.0.0.1:8081/nexus"));
        Assertions.assertFalse(VerifyUtils.isHttp("about:blank"));
    }

    @Test
    public void testIsTelephone() {
        Assertions.assertTrue(VerifyUtils.isTelephone("020-12345678"));
        Assertions.assertTrue(VerifyUtils.isTelephone("020-1234567"));
        Assertions.assertTrue(VerifyUtils.isTelephone("020-123456"));
        Assertions.assertTrue(VerifyUtils.isTelephone("0755-12345678"));
        Assertions.assertTrue(VerifyUtils.isTelephone("0755-1234567"));
        Assertions.assertTrue(VerifyUtils.isTelephone("0755-123456"));
        Assertions.assertFalse(VerifyUtils.isTelephone("020-123"));
        Assertions.assertTrue(VerifyUtils.isTelephone("10000"));
        Assertions.assertTrue(VerifyUtils.isTelephone("95508"));
        Assertions.assertTrue(VerifyUtils.isTelephone("88888888"));
        Assertions.assertFalse(VerifyUtils.isTelephone("13912345678"));
        Assertions.assertFalse(VerifyUtils.isTelephone("123"));
    }

    @Test
    public void testIsMobilePhone() {
        Assertions.assertFalse(VerifyUtils.isMobilePhone("020-12345678"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("020-1234567"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("020-123456"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("0755-12345678"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("0755-1234567"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("0755-123456"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("020-123"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("10000"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("95508"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("88888888"));
        Assertions.assertTrue(VerifyUtils.isMobilePhone("13912345678"));
        Assertions.assertFalse(VerifyUtils.isMobilePhone("123"));
    }

    @Test
    public void testIsIdentity() {
        Assertions.assertFalse(VerifyUtils.isIdentity("13912345678"));
        Assertions.assertFalse(VerifyUtils.isIdentity("020-12345678"));
        Assertions.assertFalse(VerifyUtils.isIdentity("123"));
        Assertions.assertTrue(VerifyUtils.isIdentity("440684199001010001"));
        Assertions.assertTrue(VerifyUtils.isIdentity("44068419900101000X"));
        Assertions.assertTrue(VerifyUtils.isIdentity("44068419900101000x"));
        Assertions.assertTrue(VerifyUtils.isIdentity("440684199001012"));
        Assertions.assertFalse(VerifyUtils.isIdentity("44068419900101X"));
        Assertions.assertFalse(VerifyUtils.isIdentity("44068419900101x"));
    }

    @Test
    public void testIsYear() {
        Assertions.assertFalse(VerifyUtils.isYear("0000"));
        Assertions.assertFalse(VerifyUtils.isYear("02015"));
        Assertions.assertTrue(VerifyUtils.isYear("0"));
        Assertions.assertTrue(VerifyUtils.isYear("2016"));
        Assertions.assertTrue(VerifyUtils.isYear("1234"));
        Assertions.assertTrue(VerifyUtils.isYear("456"));
        Assertions.assertTrue(VerifyUtils.isYear("98"));
        Assertions.assertTrue(VerifyUtils.isYear("5"));
        Assertions.assertTrue(VerifyUtils.isYear("9999"));
        Assertions.assertTrue(VerifyUtils.isYear("10001"));
    }

    @Test
    public void testIsMonth() {
        Assertions.assertFalse(VerifyUtils.isMonth("00"));
        Assertions.assertFalse(VerifyUtils.isMonth("02015"));
        Assertions.assertTrue(VerifyUtils.isMonth("01"));
        Assertions.assertTrue(VerifyUtils.isMonth("1"));
        Assertions.assertTrue(VerifyUtils.isMonth("02"));
        Assertions.assertTrue(VerifyUtils.isMonth("2"));
        Assertions.assertTrue(VerifyUtils.isMonth("10"));
        Assertions.assertTrue(VerifyUtils.isMonth("11"));
        Assertions.assertTrue(VerifyUtils.isMonth("12"));
        Assertions.assertFalse(VerifyUtils.isMonth("012"));
        Assertions.assertFalse(VerifyUtils.isMonth("13"));
    }

    @Test
    public void testIsDay() {
        Assertions.assertFalse(VerifyUtils.isDay("00"));
        Assertions.assertFalse(VerifyUtils.isDay("02015"));
        Assertions.assertTrue(VerifyUtils.isDay("01"));
        Assertions.assertTrue(VerifyUtils.isDay("1"));
        Assertions.assertTrue(VerifyUtils.isDay("02"));
        Assertions.assertTrue(VerifyUtils.isDay("2"));
        Assertions.assertTrue(VerifyUtils.isDay("10"));
        Assertions.assertTrue(VerifyUtils.isDay("21"));
        Assertions.assertTrue(VerifyUtils.isDay("29"));
        Assertions.assertTrue(VerifyUtils.isDay("30"));
        Assertions.assertTrue(VerifyUtils.isDay("31"));
        Assertions.assertFalse(VerifyUtils.isDay("32"));
        Assertions.assertFalse(VerifyUtils.isDay("031"));
    }

    @Test
    public void testIsHour() {
        Assertions.assertTrue(VerifyUtils.isHour("00"));
        Assertions.assertFalse(VerifyUtils.isHour("02015"));
        Assertions.assertTrue(VerifyUtils.isHour("01"));
        Assertions.assertTrue(VerifyUtils.isHour("1"));
        Assertions.assertTrue(VerifyUtils.isHour("02"));
        Assertions.assertTrue(VerifyUtils.isHour("2"));
        Assertions.assertTrue(VerifyUtils.isHour("10"));
        Assertions.assertTrue(VerifyUtils.isHour("21"));
        Assertions.assertFalse(VerifyUtils.isHour("29"));
        Assertions.assertTrue(VerifyUtils.isHour("23"));
        Assertions.assertFalse(VerifyUtils.isHour("24"));
        Assertions.assertFalse(VerifyUtils.isHour("32"));
        Assertions.assertFalse(VerifyUtils.isHour("024"));
    }

    @Test
    public void testIsMinute() {
        Assertions.assertTrue(VerifyUtils.isMinute("00"));
        Assertions.assertFalse(VerifyUtils.isMinute("02015"));
        Assertions.assertTrue(VerifyUtils.isMinute("01"));
        Assertions.assertTrue(VerifyUtils.isMinute("1"));
        Assertions.assertTrue(VerifyUtils.isMinute("02"));
        Assertions.assertTrue(VerifyUtils.isMinute("2"));
        Assertions.assertTrue(VerifyUtils.isMinute("0"));
        Assertions.assertTrue(VerifyUtils.isMinute("21"));
        Assertions.assertFalse(VerifyUtils.isMinute("029"));
        Assertions.assertTrue(VerifyUtils.isMinute("59"));
        Assertions.assertFalse(VerifyUtils.isMinute("60"));
        Assertions.assertFalse(VerifyUtils.isMinute("61"));
        Assertions.assertFalse(VerifyUtils.isMinute("059"));
    }

    @Test
    public void testIsSecond() {
        Assertions.assertTrue(VerifyUtils.isSecond("00"));
        Assertions.assertFalse(VerifyUtils.isSecond("02015"));
        Assertions.assertTrue(VerifyUtils.isSecond("01"));
        Assertions.assertTrue(VerifyUtils.isSecond("1"));
        Assertions.assertTrue(VerifyUtils.isSecond("02"));
        Assertions.assertTrue(VerifyUtils.isSecond("2"));
        Assertions.assertTrue(VerifyUtils.isSecond("0"));
        Assertions.assertTrue(VerifyUtils.isSecond("21"));
        Assertions.assertFalse(VerifyUtils.isSecond("029"));
        Assertions.assertTrue(VerifyUtils.isSecond("59"));
        Assertions.assertFalse(VerifyUtils.isSecond("60"));
        Assertions.assertFalse(VerifyUtils.isSecond("61"));
        Assertions.assertFalse(VerifyUtils.isSecond("059"));
    }

    @Test
    public void testIsMillis() {
        Assertions.assertTrue(VerifyUtils.isMillis("0"));
        Assertions.assertTrue(VerifyUtils.isMillis("00"));
        Assertions.assertTrue(VerifyUtils.isMillis("000"));
        Assertions.assertTrue(VerifyUtils.isMillis("010"));
        Assertions.assertTrue(VerifyUtils.isMillis("011"));
        Assertions.assertTrue(VerifyUtils.isMillis("1"));
        Assertions.assertTrue(VerifyUtils.isMillis("12"));
        Assertions.assertTrue(VerifyUtils.isMillis("999"));
        Assertions.assertFalse(VerifyUtils.isMillis("9999"));
    }

    @Test
    public void testIsDate() {
        Assertions.assertTrue(VerifyUtils.isDate("2016-01-01"));
        Assertions.assertFalse(VerifyUtils.isDate("02016-01-01"));
        Assertions.assertTrue(VerifyUtils.isDate("2016-1-1"));
        Assertions.assertFalse(VerifyUtils.isDate("2016-13-01"));
        Assertions.assertFalse(VerifyUtils.isDate("2016-01-32"));
    }

    @Test
    public void testIsTime() {
        Assertions.assertTrue(VerifyUtils.isTime("00:00:00"));
        Assertions.assertTrue(VerifyUtils.isTime("23:59:59"));
        Assertions.assertFalse(VerifyUtils.isTime("24:00:00"));
        Assertions.assertTrue(VerifyUtils.isTime("0:0:0"));
        Assertions.assertFalse(VerifyUtils.isTime("0:60:60"));
        Assertions.assertFalse(VerifyUtils.isTime("16-01-32"));
        Assertions.assertTrue(VerifyUtils.isTime("0:0:0.0"));
        Assertions.assertTrue(VerifyUtils.isTime("23:59:59.999"));
        Assertions.assertTrue(VerifyUtils.isTime("23:1:01.012"));
        Assertions.assertTrue(VerifyUtils.isTime("6:01:1.9"));
    }

    @Test
    public void testIsDateTime() {
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 00:00:00"));
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 23:59:59"));
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 23:59:59.123"));
        Assertions.assertFalse(VerifyUtils.isDateTime("2016-01-01 24:00:00"));
        Assertions.assertFalse(VerifyUtils.isDateTime("02016-01-01 0:0:0"));
        Assertions.assertFalse(VerifyUtils.isDateTime("2016-01-01 0:60:60"));
        Assertions.assertFalse(VerifyUtils.isDateTime("2016-13-01 16:01:32"));
        Assertions.assertFalse(VerifyUtils.isDateTime("2016-01-01-0:0:0.0"));
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 23:59:59.999"));
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 23:1:01.012"));
        Assertions.assertTrue(VerifyUtils.isDateTime("2016-01-01 6:01:1.9"));
    }

    @Test
    public void testIsMac() {
        Assertions.assertTrue(VerifyUtils.isMac("68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isMac("00-01-00-01-1D-30-A6-F8-68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isMac("127.0.0.1"));
        Assertions.assertFalse(VerifyUtils.isMac("fe80::5168:bd2c:886e:5550%13"));
        Assertions.assertFalse(VerifyUtils.isMac("00-00-00-00-00-00-00-E0"));
    }

    @Test
    public void testIsIp() {
        Assertions.assertFalse(VerifyUtils.isIP("68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isIP("00-01-00-01-1D-30-A6-F8-68-F7-28-F5-2C-D3"));
        Assertions.assertTrue(VerifyUtils.isIP("127.0.0.1"));
        Assertions.assertTrue(VerifyUtils.isIP("0.0.0.0"));
        Assertions.assertTrue(VerifyUtils.isIP("255.255.255.255"));
        Assertions.assertFalse(VerifyUtils.isIP("256.0.0.0"));
        Assertions.assertFalse(VerifyUtils.isIP("127.0.0.1:9998"));
        Assertions.assertFalse(VerifyUtils.isIP("fe80::5168:bd2c:886e:5550%13"));
        Assertions.assertFalse(VerifyUtils.isIP("00-00-00-00-00-00-00-E0"));
    }

    @Test
    public void testIsIpv4() {
        Assertions.assertFalse(VerifyUtils.isIPv4("68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isIPv4("00-01-00-01-1D-30-A6-F8-68-F7-28-F5-2C-D3"));
        Assertions.assertTrue(VerifyUtils.isIPv4("127.0.0.1"));
        Assertions.assertTrue(VerifyUtils.isIPv4("0.0.0.0"));
        Assertions.assertTrue(VerifyUtils.isIPv4("255.255.255.255"));
        Assertions.assertFalse(VerifyUtils.isIPv4("256.0.0.0"));
        Assertions.assertFalse(VerifyUtils.isIPv4("127.0.0.1:9998"));
        Assertions.assertFalse(VerifyUtils.isIPv4("fe80::5168:bd2c:886e:5550%13"));
        Assertions.assertFalse(VerifyUtils.isIPv4("00-00-00-00-00-00-00-E0"));
    }

    @Test
    public void testIsIpv6() {
        Assertions.assertFalse(VerifyUtils.isIPv6("68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isIPv6("00-01-00-01-1D-30-A6-F8-68-F7-28-F5-2C-D3"));
        Assertions.assertFalse(VerifyUtils.isIPv6("127.0.0.1"));
        Assertions.assertFalse(VerifyUtils.isIPv6("0.0.0.0"));
        Assertions.assertFalse(VerifyUtils.isIPv6("255.255.255.255"));
        Assertions.assertFalse(VerifyUtils.isIPv6("256.0.0.0"));
        Assertions.assertFalse(VerifyUtils.isIPv6("127.0.0.1:9998"));
        Assertions.assertFalse(VerifyUtils.isIPv6("00-00-00-00-00-00-00-E0"));
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80::5168:bd2c:886e:5550%13"));
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80:0000:0000:0000:0204:61ff:fe9d:f156"));	// 完整地址
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80:0:0:0:204:61ff:fe9d:f156"));	// 压缩全0字段
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80::204:61ff:fe9d:f156"));	// 去掉全0字段
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80:0000:0000:0000:0204:61ff:254.157.241.86"));	// 后2位为ipv4
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80:0:0:0:204:61ff:254.157.241.86"));	// 压缩全0字段，后2位为ipv4
        Assertions.assertTrue(VerifyUtils.isIPv6("fe80::204:61ff:254.157.241.86"));	// 去掉全0字段，后2位为ipv4
    }

    @Test
    public void testIsPortString() {
        Assertions.assertFalse(VerifyUtils.isPort("99999"));
        Assertions.assertFalse(VerifyUtils.isPort("00000"));
        Assertions.assertTrue(VerifyUtils.isPort("0"));
        Assertions.assertTrue(VerifyUtils.isPort("1"));
        Assertions.assertTrue(VerifyUtils.isPort("12"));
        Assertions.assertTrue(VerifyUtils.isPort("123"));
        Assertions.assertTrue(VerifyUtils.isPort("1024"));
        Assertions.assertTrue(VerifyUtils.isPort("55555"));
        Assertions.assertFalse(VerifyUtils.isPort("01024"));
        Assertions.assertTrue(VerifyUtils.isPort("65535"));
        Assertions.assertFalse(VerifyUtils.isPort("65536"));
    }

    @Test
    public void testIsPortInt() {
        Assertions.assertFalse(VerifyUtils.isPort(99999));
        Assertions.assertTrue(VerifyUtils.isPort(00000));
        Assertions.assertTrue(VerifyUtils.isPort(0));
        Assertions.assertTrue(VerifyUtils.isPort(1));
        Assertions.assertTrue(VerifyUtils.isPort(12));
        Assertions.assertTrue(VerifyUtils.isPort(123));
        Assertions.assertTrue(VerifyUtils.isPort(1024));
        Assertions.assertTrue(VerifyUtils.isPort(55555));
        Assertions.assertTrue(VerifyUtils.isPort(01024));
        Assertions.assertTrue(VerifyUtils.isPort(65535));
        Assertions.assertFalse(VerifyUtils.isPort(65536));
    }

    @Test
    public void testIsSocket() {
        Assertions.assertFalse(VerifyUtils.isSocket("0.0.0.0:99999"));
        Assertions.assertFalse(VerifyUtils.isSocket("0.0.0.0:00000"));
        Assertions.assertTrue(VerifyUtils.isSocket("0.0.0.0:0"));
        Assertions.assertTrue(VerifyUtils.isSocket("1.1.1.1:1"));
        Assertions.assertFalse(VerifyUtils.isSocket("255.255.255.256:12"));
        Assertions.assertTrue(VerifyUtils.isSocket("127.0.0.1:123"));
        Assertions.assertTrue(VerifyUtils.isSocket("127.0.0.1:1024"));
        Assertions.assertTrue(VerifyUtils.isSocket("192.168.0.1:55555"));
        Assertions.assertFalse(VerifyUtils.isSocket("255.255.255.255:01024"));
        Assertions.assertTrue(VerifyUtils.isSocket("255.255.255.255:65535"));
        Assertions.assertFalse(VerifyUtils.isSocket("255.255.255.255:65536"));
    }

    @Test
    public void testIsChineseString() {
        Assertions.assertFalse(VerifyUtils.isChinese("部分中文.!,,"));
        Assertions.assertFalse(VerifyUtils.isChinese("部分中文abc"));
        Assertions.assertFalse(VerifyUtils.isChinese("部分中文123"));
        Assertions.assertFalse(VerifyUtils.isChinese("部 分 中 文"));
        Assertions.assertTrue(VerifyUtils.isChinese("全是中文。！，，"));
        Assertions.assertTrue(VerifyUtils.isChinese("全是中文"));
        Assertions.assertTrue(VerifyUtils.isChinese("全角属于中文ａ"));
        Assertions.assertFalse(VerifyUtils.isChinese("all english"));
    }

    @Test
    public void testIsChineseChar() {
        Assertions.assertTrue(VerifyUtils.isChinese('中'));
        Assertions.assertFalse(VerifyUtils.isChinese('a'));
        Assertions.assertFalse(VerifyUtils.isChinese('1'));
        Assertions.assertTrue(VerifyUtils.isChinese('。'));
        Assertions.assertFalse(VerifyUtils.isChinese('&'));
        Assertions.assertTrue(VerifyUtils.isChinese('ａ'));	// 全角属于中文
        Assertions.assertFalse(VerifyUtils.isChinese(' '));
    }

    @Test
    public void testExistChinese() {
        Assertions.assertTrue(VerifyUtils.existChinese("部分中文.!,,"));
        Assertions.assertTrue(VerifyUtils.existChinese("部分中文abc"));
        Assertions.assertTrue(VerifyUtils.existChinese("部分中文123"));
        Assertions.assertTrue(VerifyUtils.existChinese("部 分 中 文"));
        Assertions.assertTrue(VerifyUtils.existChinese("全是中文。！，，"));
        Assertions.assertTrue(VerifyUtils.existChinese("全是中文"));
        Assertions.assertTrue(VerifyUtils.existChinese("全角属于中文ａ"));
        Assertions.assertFalse(VerifyUtils.existChinese("all english"));
    }

    @Test
    public void testExistMessyCode() {
        Assertions.assertFalse(VerifyUtils.existMessyChinese("部分中文.!,,"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("部分中文abc"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("部分中文123"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("部 分 中 文"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("全是中文。！，，"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("全是中文"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("全角属于中文ａ"));
        Assertions.assertFalse(VerifyUtils.existMessyChinese("all english"));

        try {
            byte[] bytes = "乱码测试ａtest123abc".getBytes("GBK");
            String messy = new String(bytes, "ISO-8859-1");
            System.out.println(messy);
            Assertions.assertTrue(VerifyUtils.existMessyChinese(messy));

        } catch (UnsupportedEncodingException e) {
            Assertions.fail("编码异常");
        }

        try {
            byte[] bytes = "乱码测试ａtest123abc".getBytes("ISO-8859-1");
            String messy = new String(bytes, "UTF-8");
            System.out.println(messy);
            Assertions.assertFalse(VerifyUtils.existMessyChinese(messy));

        } catch (UnsupportedEncodingException e) {
            Assertions.fail("编码异常");
        }
    }

}