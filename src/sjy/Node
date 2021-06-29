package cn.xpy.demoproject.leetcode;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Data
@Slf4j
public class Node<T> {

    private T data;
    private Node<T> left;
    private Node<T> right;


    public Node() {

    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.setData(data);
        this.setLeft(left);
        this.setRight(right);
    }

    @Override
    public String toString() {
        return String.format("data: %s, left: %s, right: %s", data, left != null ? left.getData() : null, right != null ? right.getData() : null);
    }

    public static <T> void printList(Node<T> head) {
        log.info("linked list: ");
        Node<T> pointer = head;
        while (pointer != null) {
            log.info("-> data: {}", pointer.getData());
            pointer = pointer.getRight();
        }
    }

    public static <T> void printTree(Node<T> head) {
        log.info("linked tree: ");
        Node<T> pointer = head;
        if (pointer != null) {
            log.info("-> data: {}", pointer.getData());
            printTree(pointer.getLeft());
            printTree(pointer.getRight());
        } else {
            log.info("-> data: null");
        }
    }

    public static <T> Node<T> reverseList(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> i = head.getLeft();
        Node<T> j = head;
        Node<T> k = j.getRight();
        if (k == null) {
            return j;
        }
        Node<T> l = k.getRight();

        while (k != null) {
            j.setLeft(k);
            j.setRight(i);
            k.setLeft(l);
            k.setRight(j);
            i = j;
            j = k;
            k = l;
            if (l != null) {
                l = l.getRight();
            }
        }

        return j;
    }

    public static <T> Node<T> reverse2(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> before = head.getLeft();
        Node<T> now = head;
        Node<T> after = head.getRight();

        while (now != null) {
            now.setLeft(after);
            now.setRight(before);
            before = now;
            now = after;
            if (after != null) {
                after = after.getRight();
            }
        }

        return before;
    }

    /**
     * 非递归先序遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void preOrder(Node<T> head) {
        Node<T> pointer = head;
        if (pointer == null) {
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.add(pointer);

        while (!stack.isEmpty()) {
            pointer = stack.pop();
            log.info("-> {}", pointer.getData());
            if (pointer.getRight() != null) {
                stack.push(pointer.getRight());
            }
            if (pointer.getLeft() != null) {
                stack.push(pointer.getLeft());
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void midOrder(Node<T> head) {
        Node<T> pointer = head;
        if (pointer == null) {
            return;
        }

        Set<Node<T>> visitedNodeSet = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.add(pointer);

        while (!stack.isEmpty()) {
            pointer = stack.peek();
            while (pointer.getLeft() != null) {
                if (visitedNodeSet.contains(pointer.getLeft())) {
                    break;
                }
                stack.push(pointer.getLeft());
                pointer = pointer.getLeft();
            }

            pointer = stack.pop();
            log.info("-> {}", pointer.getData());
            visitedNodeSet.add(pointer);

            if (pointer.getRight() != null) {
                stack.push(pointer.getRight());
            }
        }

    }

    /**
     * 非递归中序遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void midOrder2(Node<T> head) {
        Node<T> pointer = head;
        if (pointer == null) {
            return;
        }

        Stack<Node<T>> stack = new Stack<>();

        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                stack.add(pointer);
                pointer = pointer.getLeft();
            }
            pointer = stack.pop();
            log.info("-> {}", pointer.getData());
            pointer = pointer.getRight();
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void postOrder(Node<T> head) {
        Node<T> pointer = head;
        if (pointer == null) {
            return;
        }

        Set<Node<T>> visitedNodeSet = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.add(pointer);

        while (!stack.isEmpty()) {
            pointer = stack.peek();
            if ((pointer.getLeft() == null && pointer.getRight() == null) ||
                    ((pointer.getLeft() != null && visitedNodeSet.contains(pointer.getLeft())) &&
                            (pointer.getRight() != null && visitedNodeSet.contains(pointer.getRight()))) ||
                    (pointer.getLeft() == null && pointer.getRight() != null && visitedNodeSet.contains(pointer.getRight())) ||
                    (pointer.getRight() == null && pointer.getLeft() != null && visitedNodeSet.contains(pointer.getLeft()))) {
                log.info("-> {}", pointer.getData());
                visitedNodeSet.add(pointer);
                stack.pop();
                continue;
            }

            if (pointer.getLeft() != null) {
                while (pointer.getLeft() != null && !visitedNodeSet.contains(pointer.getLeft())) {
                    stack.push(pointer.getLeft());
                    pointer = pointer.getLeft();
                }
            }
            if (pointer.getRight() != null) {
                if (!visitedNodeSet.contains(pointer.getRight())) {
                    stack.push(pointer.getRight());
                }
            }
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void postOrder2(Node<T> head) {
        if (head == null) {
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.push(head);

        List<T> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            if (node != null) {
                result.add(node.getData());
                stack.push(node.getLeft());
                stack.push(node.getRight());
            }
        }
        Collections.reverse(result);
        log.info("-> {}", result);
    }

    /**
     * 非递归层级遍历
     *
     * @param head 头结点
     * @param <T>  泛型
     */
    public static <T> void levelOrder(Node<T> head) {
        List<List<Integer>> resultList=new ArrayList<>();
        int levelNum=0;//记录某层具有多少个节点
        Queue<TreeNode> treeQueue=new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            levelNum=treeQueue.size();
            List<Integer> levelList=new ArrayList<>();
            while(levelNum>0){
                TreeNode tempNode=treeQueue.poll();
                if(tempNode!=null){
                    levelList.add(tempNode.val);
                    treeQueue.add(tempNode.left);
                    treeQueue.add(tempNode.right);
                }
                levelNum--;
            }
            if(levelList.size()>0)
                resultList.add(levelList);
        }
        return resultList;
    }

}
