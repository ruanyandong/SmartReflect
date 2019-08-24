package com.miracle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SmartReflect {
    /**
     * 反射得到构造函数，创建对象
     *
     * @param className
     * @param paramsType
     * @param paramsValue
     * @return
     */
    public static Object createObject(String className, Class[] paramsType, Object[] paramsValue) {
        try {
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getDeclaredConstructor(paramsType);
            constructor.setAccessible(true);
            Object object = constructor.newInstance(paramsValue);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射得到构造函数，创建对象
     *
     * @param clazz
     * @param paramsType
     * @param paramsValue
     * @return
     */
    public static Object createObject(Class clazz, Class[] paramsType, Object[] paramsValue) {
        try {
            Constructor constructor = clazz.getDeclaredConstructor(paramsType);
            constructor.setAccessible(true);
            return constructor.newInstance(paramsValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射调用实例方法
     *
     * @param obj
     * @param methodName
     * @param paramsType
     * @param paramsValue
     * @return
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class[] paramsType, Object[] paramsValue) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, paramsType);
            method.setAccessible(true);
            return method.invoke(obj, paramsValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射调用静态方法
     *
     * @param className
     * @param methodName
     * @param paramsType
     * @param paramsValue
     * @return
     */
    public static Object invokeStaticMethod(String className, String methodName, Class[] paramsType, Object[] paramsValue) {
        try {
            Class clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, paramsType);
            method.setAccessible(true);
            return method.invoke(null, paramsValue);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * 反射调用静态方法
     *
     * @param clazz
     * @param methodName
     * @param paramsType
     * @param paramsValue
     * @return
     */
    public static Object invokeStaticMethod(Class clazz, String methodName, Class[] paramsType, Object[] paramsValue) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, paramsType);
            method.setAccessible(true);
            return method.invoke(null, paramsValue);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * 通过反射获取相应实例变量、静态变量
     *
     * @param className
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object getFieldObject(String className, Object obj, String fieldName) {
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射获取静态变量
     *
     * @param className
     * @param fieldName
     * @return
     */
    public static Object getStaticFieldObject(String className, String fieldName) {
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射获取静态变量
     *
     * @param clazz
     * @param fieldName
     * @return
     */
    public static Object getStaticFieldObject(Class clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射给变量设值
     * @param className
     * @param obj
     * @param fieldName
     * @param fieldValue
     */
    public static void setFieldObject(String className,Object obj,String fieldName,Object fieldValue){
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射给变量设值
     * @param clazz
     * @param obj
     * @param fieldName
     * @param fieldValue
     */
    public static void setFieldObject(Class clazz,Object obj,String fieldName,Object fieldValue){
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射给静态变量设值
     * @param className
     * @param fieldName
     * @param fieldValue
     */
    public static void setStaticFieldObject(String className,String fieldName,Object fieldValue){
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(null,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过反射给静态变量设值
     * @param clazz
     * @param fieldName
     * @param fieldValue
     */
    public static void setStaticFieldObject(Class clazz,String fieldName,Object fieldValue){
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(null,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

