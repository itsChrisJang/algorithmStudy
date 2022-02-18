
public class Test1 extends TestParents{

    public static void main(String[] args) {

        Test1 tt1 = new Test1();
        tt1.testtttt("Test1");


        System.out.println(tt1.updateMyHeadByTeacher());
        System.out.println(tt1.updateMyHeadByTeacher("zz"));
        System.out.println(tt1.updateMyHeadByTeacher("uu", 2));

        Test2 tt2 = new Test2();
        tt2.testtttt("Test2");

        Test3 tt3 = new Test3();
        tt3.testtttt("Test3");

    }

    // 카멜 표기법
    // 어떤 행위를 하는지 적는다.  보통 동사+명사 구조
    // 앞에는 소문자로 시작

    // overload
    //
    public String updateMyHeadByTeacher() {

        return "호호";
    }

    public String updateMyHeadByTeacher(String dd) {

        return dd + "히히";
    }

    public String updateMyHeadByTeacher(String dd,int s) {

        return dd + "커커 :"+ s;
    }
    //네이밍룰
    //selectSummaryByCust
    //selectSummaryByGoods
    //selectSummaryBySeller






}
