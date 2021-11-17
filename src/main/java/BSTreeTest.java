import java.util.Scanner;

/**
 * Project name(项目名称)：算法_二叉搜索树的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): BSTreeTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/17
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)：
 * 测试输入：3 2 1 0 21
 * 预期输出：
 *
 * 前序遍历: 3 2 1 0 21
 * 中序遍历: 0 1 2 3 21
 * 后序遍历: 0 1 2 21 3
 * 前序遍历: 21 2 1 0
 * 中序遍历: 0 1 2 21
 * 后序遍历: 0 1 2 21
 */

public class BSTreeTest
{
    public static void main(String[] args)
    {
        BSTree tree = new BSTree();
        int del = Integer.MIN_VALUE;
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int item = in.nextInt();
            tree.insert(item);
            if (del == Integer.MIN_VALUE)
            {
                del = item;
            }
        }
        System.out.print("前序遍历: ");
        tree.preOrder();
        System.out.println();
        System.out.print("中序遍历: ");
        tree.inOrder();
        System.out.println();
        System.out.print("后序遍历: ");
        tree.postOrder();
        System.out.println();
        tree.delete(del);
        System.out.print("前序遍历: ");
        tree.preOrder();
        System.out.println();
        System.out.print("中序遍历: ");
        tree.inOrder();
        System.out.println();
        System.out.print("后序遍历: ");
        tree.postOrder();
        del = Integer.MIN_VALUE;
    }
}
