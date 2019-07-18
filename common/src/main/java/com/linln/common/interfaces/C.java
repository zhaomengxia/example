package com.linln.common.interfaces;

/**
 * 可以实现多个接口
 * 如果接口A和接口B中的抽象方法有相同的，则C中实现的的这个方法，接口A和接口B共用即实现方法是一致的
 * C会实现接口A和接口B中所有的抽象方法 即我们说的取并集
 *
 * 允许实现多个接口，当实现多个接口时，若存在不同接口中存在相同的方法，只需要实现一次就可以。因为接口没有方法体，所以可以实现多个接口
 *
 * Java中类不能多继承也是为了安全，因为无论是抽象类还是非抽象类都包含非抽象方法（非抽象类也可能没有非抽象方法），
 * 如果类可以实现多继承，被继承的不同父类可能会存在相同（同名同参）的方法，则在子类实例调用这个方法时会出现冲突
 * @Author zhaomengxia
 * @create 2019/7/15 13:40
 */
public class C implements A,B {
    @Override
    public String eat() {
        return null;
    }

    @Override
    public String drink() {
        return null;
    }

    @Override
    public String action() {
        return null;
    }

    @Override
    public String ss() {
        return null;
    }

}
