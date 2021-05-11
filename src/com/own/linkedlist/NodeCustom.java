package com.own.linkedlist;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NodeCustom<T> {

    private T data;
    private NodeCustom<T> previous = null;
    private NodeCustom<T> next = null;

    public NodeCustom(T data) {
        this.data = data;
    }

    public NodeCustom(T data, NodeCustom<T> previous, NodeCustom<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeCustom<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeCustom<T> previous) {
        this.previous = previous;
    }

    public NodeCustom<T> getNext() {
        return next;
    }

    public void setNext(NodeCustom<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCustom{" +
                "data=" + data +
                '}';
    }
//
//    @Override
//    public Iterator<NodeCustom<T>> iterator() {
//        return new Iterator<NodeCustom<T>>() {
//            @Override
//            public boolean hasNext() {
//                return next != null;
//            }
//
//            @Override
//            public NodeCustom<T> next() {
//                return next;
//            }
//        };
//    }
}
