import java.awt.*;

/**
 * Project name(项目名称)：算法_二叉搜索树的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/17
 * Time(创建时间)： 21:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@SuppressWarnings("all")
public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        if (args.length == 0)
        {
            BSTree tree = new BSTree();
            int del = 3;
            tree.insert(3);
            tree.insert(2);
            tree.insert(1);
            tree.insert(0);
            tree.insert(21);
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
        else
        {
            int pos = 1;
            try
            {
                BSTree tree = new BSTree();
                int del = 3;
                for (int i = 0; i < args.length; i++)
                {
                    tree.insert(Integer.parseInt(args[i]));
                    pos++;
                }
                System.out.println("已传入数据");
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
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("参数传递错误！！！ 请检查第" + pos + "个参数");
            }
        }
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
