package ByComs.Marketo;

import java.util.*;

/**
 * Created by JMYE on 4/14/17.
 * http://www.1point3acres.com/bbs/thread-143284-1-1.html
 * http://www.spoj.com/problems/TREEGAME/
 * 3
 * 5 2 7 3 1 6 8 4
 */



public class TreeGame {
    public void treeGame(){ // Assume full and complete
        Scanner sc = new Scanner(System.in);
        int height = Integer.parseInt(sc.nextLine());
        int inputs = (int)Math.pow(2,height);
        List<Integer> output = new ArrayList<>();
        Set<String> oneSet = new HashSet<>();
        Set<String> zeroSet = new HashSet<>();
        while (inputs > 1) {
            int cur = sc.nextInt();
            String guess = height+":"+cur;
            String curSibling = getSibling(guess);
            if (!oneSet.contains(curSibling)) {
                oneSet.add(guess);
                output.add(1);
            } else {
                String curNode = guess;
                while (true) {
                    String parent = getParent(curNode);
                    if (parent == null) {
                        break;
                    }
                    String parentSibling = getSibling(parent);
                    if (!oneSet.contains(parentSibling)) {
                        oneSet.add(parent);
                        int curHeight = getHeight(parent);
                        while (curHeight < height) {
                            String leftChild = getLeftChild(parent);
                            String rightChild = getRightChild(parent);
                            if (oneSet.contains(parent) && oneSet.contains(rightChild)) {
                                zeroSet.add(leftChild);
                            }   else  if (oneSet.contains(parent) && oneSet.contains(leftChild)){
                                zeroSet.add(rightChild);
                            }   else if (oneSet.contains(parent) && zeroSet.contains(rightChild)) {
                                oneSet.add(leftChild);
                            }   else if (oneSet.contains(parent) && zeroSet.contains(leftChild)){
                                oneSet.add(rightChild);
                            }   else if (zeroSet.contains(parent)) {
                                if (zeroSet.contains(leftChild)) {
                                    zeroSet.remove(leftChild);
                                }
                                oneSet.add(leftChild);
                                if (zeroSet.contains(rightChild)) {
                                    zeroSet.remove(rightChild);
                                }
                                oneSet.add(rightChild);
                            }
                            if (isLeftChild(parent)) {
                                parent = leftChild;
                            } else {
                                parent = rightChild;
                            }
                            if (curHeight == height - 1) {
                                System.out.println(">>>>>> " + guess);
                                if (isLeftChild(guess)) {
                                    if (oneSet.contains(leftChild)) {
                                        oneSet.add(guess);
                                        output.add(1);
                                    } else {
                                        zeroSet.add(guess);
                                        output.add(0);
                                    }
                                } else {
                                    if (oneSet.contains(rightChild)) {
                                        oneSet.add(guess);
                                        output.add(1);
                                    } else {
                                        zeroSet.add(guess);
                                        output.add(0);
                                    }
                                }
                            }
                            curHeight++;
                        }
                        break;
                    } else {
                        curNode = parent;
                    }
                    if (getParent(curNode) == null) {
                        break;
                    }                                    

                }
            }

            inputs --;
        }
        System.out.println("ones: "+oneSet.toString());   
        System.out.println("zeros: "+zeroSet.toString()); 
        System.out.println(output);
    }


    private boolean isLeftChild(String guess) {
        int curNode = Integer.parseInt(guess.split(":")[1]);
        return curNode%2==0? false:true;

    }
    private String getRightChild(String parent) {
        int level = Integer.parseInt(parent.split(":")[0]);
        int curNode = Integer.parseInt(parent.split(":")[1]);
        int rightChild = curNode * 2;
        return  (level + 1) +":"+rightChild;

    }

    private String getLeftChild(String parent) {
        int level = Integer.parseInt(parent.split(":")[0]);
        int curNode = Integer.parseInt(parent.split(":")[1]);
        int leftChild = (curNode * 2) - 1;
        return  (level + 1) +":"+leftChild;
    }

    private String getSibling(String curGuess) {
        String level = curGuess.split(":")[0];
        int curNode = Integer.parseInt(curGuess.split(":")[1]);
        return curNode % 2 != 0 ? level+":"+(curNode + 1): level+":"+(curNode - 1);
    }

    private String getParent(String curGuess) {
        int level = Integer.parseInt(curGuess.split(":")[0]) - 1;
        if (level < 0) {
           return null;
        }
        int curNode = Integer.parseInt(curGuess.split(":")[1]);
        if (curNode % 2 == 0) {
            return  level +":"+(curNode/2);
        }
        return level +":"+((curNode + 1)/2);
    }

    private int getHeight(String node){
        return Integer.parseInt(node.split(":")[0]);
    }





    public static void main(String[] args) {
        TreeGame test = new TreeGame();
        test.treeGame();
    }
}
