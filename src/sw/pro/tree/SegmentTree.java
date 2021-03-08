package sw.pro.tree;

import java.io.IOException;

public class SegmentTree {
    private static final int MaxN = 100000;
    private static final int[] tree = new int[MaxN * 4];
    private static final int[] tag = new int[MaxN * 4];
    private static final int[] a = new int[MaxN];

    public static void main(String[] args) throws IOException {

    }

    //初始化 树，非必要的步骤
    private static void build(int p, int l, int r) {
        tag[p] = 0;
        //如果左右区间相同，那么必然是叶子节点啦，只有叶子节点是被真实赋值的
        if (l == r) {
            tree[p] = a[l];
            return;
        }
        //此处由于我们采用的是二叉树，所以对于整个结构来说，可以用二分来降低复杂度，否则树形结构则没有什么明显的优化
        int mid = (l + r) >> 1;
        build(ls(p), l, mid);
        build(rs(p), mid + 1, r);

        //此处由于我们是要通过子节点来维护父亲节点，所以pushup的位置应当是在回溯时。
        pushUp(p);
    }

    private static int ls(int p) {
        //二进制位左移一位代表着数值 *2∗2
        return p << 1;
    }

    private static int rs(int p) {
        //左移完之后再或上 1，由于左移完之后最后一位二进制位上一定会是 0，所以 |1等价于 +1
        return p << 1 | 1;
    }

    //我们可以认识到，f函数的唯一目的，就是记录当前节点所代表的区间
    //由于是这个区间统一改变，所以tree数组要加元素个数次啦
    private static void f(int p, int l, int r, int k) {
        tag[p] = tag[p] + k;
        tree[p] = tree[p] + k * (r - l + 1);
    }

    //对应 Max Min Sum Xor等逻辑
    private static void pushUp(int p) {
        tree[p] = tree[ls(p)] + tree[rs(p)];
        /*
        tree[p] = Math.min(tree[ls(p)], tree[rs(p)]);//max
        tree[p] = Math.max(tree[ls(p)], tree[rs(p)]);//min
        */
    }
    //每次更新两个儿子节点。以此不断向下传递
    private static void pushDown(int p, int l, int r) {
        int mid = (l + r) >> 1;
        f(ls(p), l, mid, tag[p]);
        f(rs(p), mid + 1, r, tag[p]);
        tag[p] = 0;
    }

    private static void update(int nl, int nr, int l, int r, int p, int k) {
        //nl nr 要修改的区间
        //l r p 为当前节点所存储的区间及节点的编号
        if (nl <= l && r <= nr) {
            tree[p] += k * (r - l + 1);
            tag[p] += k;
            return;
        }
        //回溯之前（也可以说是下一次递归之前，因为没有递归就没有回溯）
        //由于是在回溯之前不断向下传递，所以自然每个节点都可以更新到
        pushDown(p, l, r);
        int mid = (l + r) >> 1;
        if (nl <= mid) update(nl, nr, l, mid, ls(p), k);
        if (nr > mid) update(nl, nr, mid + 1, r, rs(p), k);
        //回溯之后
        pushUp(p);
    }

    //区间查询
    private static int query(int qX, int qY, int l, int r, int p) {
        int res = 0;
        if (qX <= l && r <= qY) return tree[p];
        int mid = (l + r) >> 1;
        pushDown(p, l, r);//查询的时候 进行更新
        //需对应具体的区间操作， sum、max、min、xor
        if (qX <= mid) res += query(qX, qY, l, mid, ls(p));
        if (qY > mid) res += query(qX, qY, mid + 1, r, rs(p));
        return res;
    }
}
