package com.kakarot.plcenter;

import com.thoughtworks.xstream.XStream;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Caaccteny caaccteny = new Caaccteny();
        XStream xStream = new XStream();
        xStream.toXML(caaccteny);
    }
}
