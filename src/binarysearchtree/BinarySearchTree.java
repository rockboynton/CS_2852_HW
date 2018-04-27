package binarysearchtree;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        E value;
        Node<E> lKid;
        Node<E> rKid;
        Node(E value) {
            this(value, null, null);
        }

        Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            lKid = left;
            rKid = right;
        }
    }

    private Node<E> root;

    public boolean isEmpty() {
        return root==null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> subroot) {
        int size = 0;
        if(subroot!=null) {
            size = 1 + size(subroot.lKid) + size(subroot.rKid);
        }
        return size;
    }

    public boolean add(E value) {
        if(value==null) {
            throw new NullPointerException("Nulls not welcome here");
        }
        boolean isChanged;
        if(root==null) {
            root = new Node<>(value);
            isChanged = true;
        } else {
            isChanged = add(root, value);
        }
        return isChanged;
    }

    private boolean add(Node<E> subroot, E value) {
        boolean isChanged = false;
        int comparison = value.compareTo(subroot.value);
        if(comparison>0) {
            if(subroot.rKid == null) {
                subroot.rKid = new Node<>(value);
                isChanged = true;
            } else {
                isChanged = add(subroot.rKid, value);
            }
        } else if(comparison<0) {
            if(subroot.lKid==null) {
                subroot.lKid = new Node<>(value);
                isChanged = true;
            } else {
                isChanged = add(subroot.lKid, value);
            }
        }
        return isChanged;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, Node<E> root) {
        boolean contains = false;
        if (root != null) {
            int comparison = element.compareTo(root.value);
            if (comparison == 0) {
                contains = true;
            } else if (comparison < 0) {
                contains = contains(element, root.lKid);
            } else {
                contains = contains(element, root.rKid);
            }
        }
        return contains;
    }

    @Override
    public String toString() {
        String result = toString(root);
        result = result.length() < 3 ? "" : result.substring(0, result.length() - 2);
        return "[" + result + "]";
    }

    private String toString(Node<E> root) {
        String treeStr = "";
        if (root != null) {
            if (root.lKid != null) {
                treeStr = toString(root.lKid) + ", " + root.value + ", " + toString(root
                        .rKid);
            } else if (root.rKid != null) {
                treeStr = root.value + ", " + toString(root.rKid);
            } else {
                treeStr = "" + root.value;
            }
        }
        return treeStr;
    }

    public String toString2() {
        String result = toString2(root);
        result = result.length() < 3 ? "" : result.substring(0, result.length() - 2);
        return "[" + result + "]";
    }

    private String toString2(Node<E> root) {
        String treeStr = "";
        if (root != null) {
            if (root.lKid != null) {
                treeStr += toString2(root.lKid) + ", ";
            }
            if (root.rKid != null) {
                treeStr += root.value + ", " + toString2(root.rKid);
            }
            else {
                treeStr += root.value  + ", ";
            }
        }
        return treeStr;
    }

    public String toString3() {
        String result = toString3(root);
        result = result.length() < 3 ? "" : result.substring(0, result.length() - 2);
        return "[" + result + "]";
    }

    private String toString3(Node<E> root) {
        String treeStr = "";
        if (root != null) {
            treeStr = toString3(root.lKid) + ", " + root.value + ", " + toString3(root.rKid);
        }
        return treeStr;
    }

    public E max() {
        return max(root);
    }

    private E max(Node<E> root) {
        E max = null;
        if (root != null) {
            if (root.rKid != null) {
                max = max(root.rKid);
            } else {
                max = root.value;
            }
        }
        return max;
    }

    public E min() {
        return min(root);
    }

    private E min(Node<E> root) {
        E min = null;
        if (root != null) {
            if (root.lKid != null) {
                min = min(root.lKid);
            } else {
                min = root.value;
            }
        }
        return min;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<E> root) {
        int count = 0;
        if (root != null) {
            if (root.lKid == null && root.rKid == null) {
                count++;
            } else {
                count = countLeaves(root.lKid) + countLeaves(root.rKid);
            }
        }
        return count;
    }
}


