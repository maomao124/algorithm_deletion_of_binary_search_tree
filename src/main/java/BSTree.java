/**
 * Project name(项目名称)：算法_二叉搜索树的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): BSTree
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/17
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)：
 * 从一棵二叉搜索树T中删除一个结点z的整个策略可分为三个基本情况：
 * 如果z没有孩子结点，那么只是简单地将它删除，并修改它的父结点；
 * 如果z只有一个孩子结点，那么将这个孩子提升到树中z的位置上，并修改z的父结点，使其指向z的孩子结点；
 * 如果z有两个孩子，那么找z的后继结点y，并让y占据树中z的位置。
 * z的原来右子树部分成为y的新的右子树，并且z的左子树成为y的新的左子树。（根据二叉搜索树的性质，后继结点y一定在z的右子树中）。
 * 调用对象的insert(int key)()方法，构建一棵二叉搜索树；
 * 调用对象的遍历方法，输出删除元素前的各种遍历结果；
 * 调用对象的delete(int key)方法，删除元素key；
 * 调用对象的遍历方法，输出删除元素后的各种遍历结果；
 * 接着根据程序的输出判断程序是否正确。
 */

@SuppressWarnings("all")
public class BSTree
{
    private TreeNode root;//根结点

    public BSTree()
    {
        root = null;
    }

    /**
     * 向树root中插入a
     *
     * @param key 要插入的值
     */
    public void insert(int key)
    {
        TreeNode treeNode = root;
        TreeNode treeNode1 = null;//始终指向treeNode的父结点
        while (treeNode != null)          //遍历，直到没有子树
        {
            treeNode1 = treeNode;
            if (key < treeNode.item)       //传入的值小于父节点
            {
                treeNode = treeNode.leftChild;  //遍历左子树
            }
            else                   //大于父节点
            {
                treeNode = treeNode.rightChild;   //遍历右子树
            }
        }
        if (null == treeNode1)
        {//空树
            root = new TreeNode(key);      //空
        }
        else if (key < treeNode1.item)         //小
        {
            treeNode1.leftChild = new TreeNode(key);
        }
        else                                //大
        {
            treeNode1.rightChild = new TreeNode(key);
        }
    }

    /**
     * 在树root中删除结点key
     *
     * @param key
     * @return
     */
    public void delete(int key)
    {
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode treeNode, int key)
    {
        /********** Begin *********/

        if (treeNode == null)   //空
        {
            return null;
        }

        if (key < treeNode.item)        //小
        {
            treeNode.leftChild = delete(treeNode.leftChild, key);  //继续遍历左子树
        }
        else if (key > treeNode.item)  //大
        {
            treeNode.rightChild = delete(treeNode.rightChild, key);  //继续遍历右子树
        }
        else             //找到了需要的节点
        {
            if (treeNode.leftChild == null)   //左节点为空
            {
                return treeNode.rightChild;    //返回右节点
            }
            if (treeNode.rightChild == null)    //右节点为空
            {
                return treeNode.leftChild;       //返回左节点
            }
            TreeNode t = treeNode;          //做删除工作
            treeNode = min(t.rightChild);
            treeNode.rightChild = deleteMin(t.rightChild);
            treeNode.leftChild = t.leftChild;
        }
        return treeNode;
        /********** End *********/
    }

    /**
     * 删除树x中的最小结点
     *
     * @param x
     * @return
     */
    private TreeNode deleteMin(TreeNode x)
    {
        if (x.leftChild == null)
        {
            return x.rightChild;
        }
        x.leftChild = deleteMin(x.leftChild);
        return x;
    }

    /**
     * 查找树x中的最小结点
     *
     * @param x
     * @return
     */
    private TreeNode min(TreeNode x)
    {
        TreeNode p = x;
        while (p.leftChild != null)
        {
            p = p.leftChild;
        }
        return p;
    }

    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(TreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.item + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(TreeNode node)
    {
        if (node != null)
        {
            inOrder(node.leftChild);
            System.out.print(node.item + " ");
            inOrder(node.rightChild);
        }
    }

    public void postOrder()
    {
        postOrder(root);
    }

    private void postOrder(TreeNode node)
    {
        if (node != null)
        {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.item + " ");
        }
    }


    public static class TreeNode
    {
        private TreeNode leftChild;
        private TreeNode rightChild;
        private int item;

        public TreeNode(int item)
        {
            this(null, null, item);
        }

        public TreeNode(TreeNode leftChild, TreeNode rightChild, int item)
        {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.item = item;
        }
    }
}
