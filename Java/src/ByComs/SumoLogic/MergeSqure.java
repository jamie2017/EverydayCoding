package ByComs.SumoLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 6/22/17.
 * design data structure to represent a square
 * which could be divided into 4 small squares recursively.
 * Each square has value 1 or 0.
 * Then, you are required to merge two given such square.
 */
class Square{
    int color;
    List<Square> sqList;
    public Square(){
        sqList = new ArrayList<>();
    }

    public Square(int c){
        sqList = new ArrayList<>();
        this.color = c;
    }
    public void setColor(int c) {
        this.color = c;
    }
    public int getColor() {
        return this.color;
    }
}
public class MergeSqure {

    public Square mergeSqure(Square s1, Square s2) {
        Square newS = new Square();
        if (s1.sqList.size() == 0 && s2.sqList.size() == 0) {
            if (s1.color == 0 && s2.color == 0) {
                newS.setColor(0);
            } else {
                newS.setColor(1);
            }
        } else if (s1.sqList.size() == 0) {
            int col = s1.color;
            if (col == 1) {
                newS = s1;
                return newS;
            } else if (col == 0) {
                newS = s2;
                return newS;
            }

        } else if (s2.sqList.size() == 0) {
            int col = s2.color;
            if (col == 1) {
                newS = s2;
                return newS;
            } else if (col == 0) {
                newS = s1;
                return newS;
            }
        } else {
            for (int i = 0 ; i < 4; i++) {
                newS.sqList.add(mergeSqure(s1.sqList.get(i), s2.sqList.get(i)));
            }
        }
        return newS;
    }

    public static void main(String[] args) {
        MergeSqure test = new MergeSqure();
        Square s1 = new Square();
        s1.sqList.add(new Square(1));
        s1.sqList.add(new Square(0));
        s1.sqList.add(new Square(0));
        s1.sqList.add(new Square());
        s1.sqList.get(3).sqList.add(new Square(0));
        s1.sqList.get(3).sqList.add(new Square(1));
        s1.sqList.get(3).sqList.add(new Square(0));
        s1.sqList.get(3).sqList.add(new Square(0));

//        assert s1.sqList.get(0).color == 1;
//        assert s1.sqList.get(3).sqList.get(1).color == 1;

        Square s2 = new Square();
        s2.sqList.add(new Square(0));
        s2.sqList.add(new Square(0));
        s2.sqList.add(new Square());
        s2.sqList.get(2).sqList.add(new Square(1));
        s2.sqList.get(2).sqList.add(new Square(0));
        s2.sqList.get(2).sqList.add(new Square(0));
        s2.sqList.get(2).sqList.add(new Square(0));
        s2.sqList.add(new Square(1));

        Square newS = test.mergeSqure(s1,s2);
        System.out.println(newS.sqList.size() == 4);
        System.out.println(newS.sqList.get(0).color == 1);
        System.out.println(newS.sqList.get(1).color == 0);
        System.out.println(newS.sqList.get(2).sqList.get(0).color == 1);
        System.out.println(newS.sqList.get(2).sqList.get(1).color == 0);
        System.out.println(newS.sqList.get(2).sqList.get(2).color == 0);
        System.out.println(newS.sqList.get(2).sqList.get(3).color == 0);
        System.out.println(newS.sqList.get(3).color == 1);
    }
}
