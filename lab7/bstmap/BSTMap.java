package bstmap;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class BSTNode {
        private BSTNode left, right;
        private K key;
        private V val;

        BSTNode() {

        }

        ;

        public BSTNode(BSTNode left, BSTNode right, K key, V val) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.val = val;
        }

        public BSTNode getLeft() {
            return left;
        }

        public void setLeft(BSTNode left) {
            this.left = left;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setRight(BSTNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }


        public BSTNode search(BSTNode node, K key) {
            if (node == null) return null;
            else if (node.key.equals(key)) return node;
            else if (node.key.compareTo(key) > 0) {
               return search(node.left, key);
            } else {
               return search(node.right, key);
            }
        }

        public BSTNode insert(BSTNode node, K key, V val) {
            if(node==null){
                return new BSTNode(null,null,key,val);
            }
            BSTNode n=node;
            while(n!=null){
                if(key.compareTo(n.key)<0){
                    if(n.left==null){
                        n.left=new BSTNode(null,null,key,val);
                        return n.left;
                    }
                    n= n.left;
                }
                else  if(key.compareTo(n.key)>0){
                    if(n.right==null){
                        n.right=new BSTNode(null,null,key,val);
                        return n.right;
                    }
                    n= n.right;
                }
                else if (key.compareTo(n.key)==0){
                    n.val=val;
                    size--;
                    return n;
                }
            }
            n=new BSTNode(null,null,key,val);
            return n;

            /*
            if (node == null) {
                BSTNode n=new BSTNode(null, null, key, val);
                return n;
            } else if (node.key.compareTo(key) < 0) {
               node.right= insert(node.right, key, val);

            } else if (node.key.compareTo(key) > 0) {
                node.left=insert(node.left, key, val);
            } else {
                node.val = val;
                return node;
            }
            return node;

             */
        }
        public void print(BSTNode n){
            if(n==null){
                return;
            }
            print(n.left);
            System.out.print(n.key+" ");
            print(n.right);
//            System.out.println(n.key+" ");
        }
    }
    private BSTNode bstNode;
    private int size;
    public BSTMap() {
        BSTNode bstNode;
        size=0;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void clear() {
        size=0;
        bstNode=null;
    }

    @Override
    public boolean containsKey(K key) {
       if(bstNode==null|| bstNode.search(bstNode,key)==null) {
           return false;
       }
       else{
           return true;
       }
    }

    @Override
    public V get(K key) {
       if(size==0) return null;
        BSTNode n=bstNode.search(bstNode,key);
        if(n==null) return null;
        return n.getVal();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
       if(bstNode==null) {
        bstNode=new BSTNode(null,null,key,value);
       }
       else{
           bstNode.insert(bstNode,key,value);
       }
        size++;
    }
    public void printInOrder(){
        bstNode.print(bstNode);
    }

    @Override
    public Set<K> keySet() {

        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
}
