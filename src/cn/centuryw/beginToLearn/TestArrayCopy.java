package cn.centuryw.beginToLearn;

/**
 * 数组拷贝
 * arraycopy 参数说明:
 *  参数1：源数组
 *  参数2：源数组拷贝开始位置（下标）
 *  参数3：目标数组
 *  参数4：目标数组拷贝开始位置（下标）
 *  参数5：拷贝长度（拷贝的数量）
 *
 * 内容：
 *  1.基础拷贝
 *  2.从数组中删除某个元素
 *  3.删除数组中指定元素并返回数组
 *  4.数组指定位置插入元素
 *
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        System.out.println("基础拷贝");
        basicCopy1();

        System.out.println("从数组中删除某个元素");
        basicCopy2();

        System.out.println("删除数组中指定元素并返回数组");
        String[] testary = {"你","好","世","界"};
        removeElement(testary,1);

        System.out.println("数组指定位置插入元素");
        String[] testary2 = {"你","好","世","界"};
        extendElement(testary2,4,"!");

    }
    /* 基础拷贝 */
    public static void basicCopy1(){
        String[] s1 = {"阿里","京东","淘宝","搜狐","网易"};
        String[] s2 = new String[6];
        // 拷贝
        System.arraycopy(s1,2,s2,1,2);
        // 打印输出
        for(int i=0;i<s2.length;i++){
            System.out.println("下标"+i+"--"+s2[i]);
        }
    }
    /* 测试从数组中删除某个元素（本质上仍是数组拷贝） */
    public static void basicCopy2(){
        String[] s1 = {"阿里","京东","淘宝","搜狐","网易"};
        // 删除”淘宝“ 即将后面拷贝覆盖到删除的元素位置（提前一位） 然后将最后一位设为空
        System.arraycopy(s1,3,s1,2,2); //拷贝
        s1[s1.length-1] = null; //最后一位设为空
        // 打印输出
        for(int i=0;i<s1.length;i++){
            System.out.println("下标"+i+"--"+s1[i]);
        }
    }
    /* 删除数组中指定索引位置的元素，并将原数组返回 */
    public static String[] removeElement(String[] ary,int index){
        System.arraycopy(ary,index+1,ary,index,ary.length-(index+1));
        ary[ary.length-1] = null;
        for(int i=0;i<ary.length;i++){
            System.out.println("下标"+i+"--"+ary[i]);
        }
        return ary;
    }
    /* 数组指定位置插入元素，并返回数组 */
    public static String[] extendElement(String[] ary,int index,String numberElement){
        //首先创建新数组
        String[] resultAry = new String[ary.length+1];
        //先将索引位置之前的元素拷贝，再拷贝索引之后的元素
        System.arraycopy(ary,0,resultAry,0,index);
        resultAry[index] = numberElement;
        System.arraycopy(ary,index,resultAry,index+1,ary.length-index);
        for(int i=0;i<resultAry.length;i++){
            System.out.println("下标"+i+"--"+resultAry[i]);
        }
        return resultAry;
    }

}
