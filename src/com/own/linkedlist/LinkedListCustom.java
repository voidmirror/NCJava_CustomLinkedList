package com.own.linkedlist;

import java.util.*;

public class LinkedListCustom<T> implements Iterable<NodeCustom<T>> {

    private NodeCustom<T> first = null;
    private NodeCustom<T> last = null;

    private int size = 0;

    public NodeCustom<T> getFirst() {
        return first;
    }

    public void setFirst(NodeCustom<T> first) {
        this.first = first;
    }

    public NodeCustom<T> getLast() {
        return last;
    }

    public void setLast(NodeCustom<T> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    //TODO: checkIndex

    public void add(T data) {
        // add node to last
        NodeCustom<T> node = new NodeCustom<>(data);

        //TODO: if first == null:

        if (first == null) {
            first = node;
        } else {

        //TODO: normal last:

        last.setNext(node);
        node.setPrevious(last);

        }
        last = node;

        size++;
    }

    public void addToBegin(T data) {
        NodeCustom<T> node = new NodeCustom<>(data);

        //TODO: if first == null:

        if (first == null) {
            first = node;
            last = node;
        } else {

            //TODO: normal first:

            node.setNext(first);
            first.setPrevious(node);
            first = node;

        }

        size++;

    }

    public void addByIndex(T data, int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else {
            NodeCustom<T> tmp = get(index);
            if (tmp == first) {
                addToBegin(data);
            } else {
                NodeCustom<T> node = new NodeCustom<>(data);
                node.setNext(tmp);
                node.setPrevious(tmp.getPrevious());
                tmp.getPrevious().setNext(node);
                tmp.setPrevious(node);
            }
        }

        size++;

    }

    public void addNodeByIndex(NodeCustom<T> node, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else {
            NodeCustom<T> tmp = get(index);
            if (tmp == first) {
                addToBegin(node.getData());
            } else {
                node.setNext(tmp);
                node.setPrevious(tmp.getPrevious());
                tmp.getPrevious().setNext(node);
                tmp.setPrevious(node);
            }
        }

        size++;
    }

    public void addAll(Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
    }

    public NodeCustom<T> get(int index) {

        checkElementIndex(index);
        return getNode(index);

    }

    public NodeCustom<T> getNode(int index) {

        NodeCustom<T> tmp;
        if (index < (size/ 2)) {

            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }

        } else {

            tmp = last;
            for (int i = size - 1; i > index; i--) {
                tmp = tmp.getPrevious();
            }

        }
        return tmp;

    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (NodeCustom<T> tmp = first; tmp != null; tmp = tmp.getNext()) {
                if (tmp.getData() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (NodeCustom<T> tmp = first; tmp != null; tmp = tmp.getNext()) {
                if (o.equals(tmp.getData())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (NodeCustom<T> tmp = last; tmp != null; tmp = tmp.getPrevious()) {
                index--;
                if (tmp.getData() == null) {
                    return index;
                }
            }
        } else {
            for (NodeCustom<T> tmp = last; tmp != null; tmp = tmp.getPrevious()) {
                index--;
                if (o.equals(tmp.getData())) {
                    return index;
                }
            }
        }
        return -1;
    }

    public void removeElement(NodeCustom<T> node) {
        if (node.getPrevious() == null) {
            if (node.getNext() == null) {
                first = null;
                last = null;
            } else {
                first = node.getNext();
                node.getNext().setPrevious(null);
            }
        } else {
            node.getPrevious().setNext(node.getNext());
            if (last == node) {
                last = node.getPrevious();
            }
        }
    }

    public NodeCustom<T> popFirst() {
        NodeCustom<T> tmp = getFirst();
        removeElement(first);
        return tmp;
    }

    public NodeCustom<T> popLast() {
        NodeCustom<T> tmp = getLast();
        removeElement(last);
        return tmp;
    }

    public boolean remove(String o) {
        if (o == null) {
            for (NodeCustom<T> tmp = first; tmp != null; tmp = tmp.getNext()) {
                if (tmp.getData() == null) {
                    removeElement(tmp);
                    size--;
                    return true;
                }
            }
        } else {
            for (NodeCustom<T> tmp = first; tmp != null; tmp = tmp.getNext()) {
                if (o.equals(tmp.getData())) {
                    removeElement(tmp);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public void clear() {
        for (NodeCustom<T> tmp = first; tmp != null;) {
            NodeCustom<T> next = tmp.getNext();
            tmp.setNext(null);
            tmp.setData(null);
            tmp.setPrevious(null);
            tmp = next;
        }

        first = last = null;
        size = 0;
    }

    @Override
    public Iterator<NodeCustom<T>> iterator() {

        return new ListIterator<NodeCustom<T>>() {
            int index = 0;
            int lastRet = -1;
            int nextIndex = 0;
            NodeCustom<T> lastReturned;
            NodeCustom<T> next = first;

            @Override
            public boolean hasNext() {
                try {
                    return get(nextIndex) != null;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            @Override
            public NodeCustom<T> next() {

                if (!hasNext())
                    throw new NoSuchElementException();


//                NodeCustom<T> t = get(index).getNext();
//                index++;


                lastReturned = next;
                next = next.getNext();
                nextIndex++;
                return lastReturned;
            }

            @Override
            public boolean hasPrevious() {
                return get(nextIndex).getNext() != null;
            }

            @Override
            public NodeCustom<T> previous() {
                return get(nextIndex).getPrevious();
            }

            @Override
            public int nextIndex() {
                return nextIndex + 1;
            }

            @Override
            public int previousIndex() {
                if (nextIndex == 0) {
                    throw new IndexOutOfBoundsException("Index cannot be negative");
                }
                return nextIndex - 1;
            }

            @Override
            public void remove() {
//                removeElement(get(index));
                NodeCustom<T> node = get(nextIndex);

                if (node.getPrevious() == null) {
                    if (node.getNext() == null) {
                        first = null;
                    } else {
                        first = node.getNext();
                    }
                } else {
                    node.getPrevious().setNext(node.getNext());
                    if (last == node) {
                        last = node.getPrevious();
                    }
                }

//                NodeCustom<T> lastNext = next.getNext();
//                removeElement(lastReturned);
//                if (next == lastReturned)
//                    next = lastNext;
//                else
//                    nextIndex--;
//                lastReturned = null;
            }

            @Override
            public void set(NodeCustom<T> tNodeCustom) {
                addNodeByIndex(tNodeCustom, nextIndex);
            }

            @Override
            public void add(NodeCustom<T> tNodeCustom) {
                tNodeCustom.setNext(get(nextIndex).getNext());
                tNodeCustom.setPrevious(get(nextIndex));
                get(nextIndex).getNext().setPrevious(tNodeCustom);
                get(nextIndex).setNext(tNodeCustom);
            }
        };
    }

//    @Override
//    public String toString() {
//        String s = "";
//        for (NodeCustom<T> tNodeCustom : first) {
//            s = s + tNodeCustom + " ";
//        }
//        return s;
//    }


}
