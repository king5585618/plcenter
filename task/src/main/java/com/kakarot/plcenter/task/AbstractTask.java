package com.kakarot.plcenter.task;

/**
 * @author jinzj
 * @since v4.0.0
 */
public abstract class AbstractTask implements Runnable {
    private Integer index;
    private Integer num;


    @Override
    public void run() {
        process();
    }

    public abstract void process();

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
