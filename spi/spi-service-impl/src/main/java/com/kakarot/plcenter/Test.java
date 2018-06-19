package com.kakarot.plcenter;

import java.util.ServiceLoader;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
        for (DogService d : loaders) {
            d.sleep();
        }
    }
}
