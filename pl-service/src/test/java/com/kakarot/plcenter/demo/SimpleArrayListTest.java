package com.kakarot.plcenter.demo;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jinzj on 2017/2/4.
 */
public class SimpleArrayListTest {

    private Random random = new Random();

    @Test
    public void test() throws Exception {
        SimpleArrayList<String> list = new SimpleArrayList<String>();

        int size = random.nextInt(50);
        int index = random.nextInt(size);
        String str = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                str = i + "";
            }
            list.add(i + "");
        }
        assertThat(list.size()).isEqualTo(size);
        assertThat(str).isEqualTo(list.get(index));
        list.remove(str);
        assertThat(list.size()).isEqualTo(size - 1);
    }
}
