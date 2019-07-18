package com.linln.common.interfaces;

/**
 * 因为抽象类中可以没有抽象方法，即存在有方法体的方法
 * java之所以只能单继承，是因为如果D和E中存在相同的方法，F不知道调用哪个类的这个方法。
 * 为什么只能单继承，主要是防止多个类有相同的方法名，但方法体不一样，子类就不知道难选了。故java和C#都不支持多继承
 * @Author zhaomengxia
 * @create 2019/7/15 13:42
 */
public class F extends D {
    @Override
    public String eat() {
        return null;
    }

    @Override
    public String drink() {
        return null;
    }
}
