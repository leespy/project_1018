package com.muse.genericity;

/**
 * 泛型类
 *
 * @author muse
 */
public class ClassGenericity {

    public static void main(String[] args) {
        //创建对象并指定元素类型
        ObjectTool<String> tool = new ObjectTool<>();
        tool.setObj("muse");
        System.out.println(tool.getObj());

        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        // 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
        objectTool.setObj(10);
        System.out.println(objectTool.getObj());
    }

    static class ObjectTool<T> {

        private T obj;

        public T getObj() {

            return obj;
        }
        public void setObj(T obj) {

            this.obj = obj;
        }
    }
}


