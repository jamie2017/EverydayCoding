package ByComs.Marketo;

import java.util.*;

/**
 * Created by JMYE on 5/10/17.
 */
public class TreeGameOpt {

    public static void main(String[] args) {
        TreeGameOpt test = new TreeGameOpt();
        test.treeGameOpt();
    }
    private Map<Integer, Map<Integer, Integer>> guessMap;

    public void treeGameOpt() {
        Scanner sc = new Scanner(System.in);
        int height = Integer.parseInt(sc.nextLine());
        guessMap = new HashMap<>();
        for (int i = 0; i < height + 1; i++) {
            guessMap.put(i,new HashMap<>());
        }
        int inputs = (int) Math.pow(2, height);
        List<Integer> output = new ArrayList<>();
        while (inputs > 1) {
            int curGuess = sc.nextInt();
            int curSibling = getSiblingVal(curGuess,height);
            if (curSibling == -1 || curSibling != 1) {
                guessMap.get(height).put(curGuess,1);
                output.add(1);
            } else {
                int upNode = curGuess;
                int upHeight = height;
                while (upHeight > 0) {
                    int parent = getParent(upNode,upHeight);
                    if (parent == -1) {
                        break;
                    }
                    int parentSibling = getSiblingVal(parent,upHeight - 1);
                    if (parentSibling == -1 || parentSibling != 1) {
                        guessMap.get(upHeight - 1).put(parent, 1);
                        int downHeight = upHeight - 1;
                        while (downHeight < height) {
                            int parentVal = guessMap.get(downHeight).get(parent);
                            int lChildVal = getleftChildVal(parent,downHeight);
                            int rChildVal = getRightChildVal(parent,downHeight);
                            int lChild = parent * 2 - 1;
                            int rChild = parent * 2;

                            if (parentVal == 1 && rChildVal == 1) {
                                guessMap.get(downHeight + 1).put(lChild, 0);
                            } else if (parentVal == 1 && lChildVal == 1){
                                guessMap.get(downHeight + 1).put(rChild, 0);
                            } else if (parentVal == 1 && rChildVal == 0) {
                                guessMap.get(downHeight + 1).put(lChild, 1);
                            } else if (parentVal == 1 && lChildVal == 0) {
                                guessMap.get(downHeight + 1).put(rChild, 1);
                            } else if (parentVal == 0) {
                                guessMap.get(downHeight + 1).put(lChild, 1);
                                guessMap.get(downHeight + 1).put(rChild, 1);
                            }
                            if (isLeftChild(parent)) {
                                parent = lChild;
                            } else {
                                parent = rChild;
                            }
                            downHeight++;
                        }
                        output.add(guessMap.get(height).get(curGuess));
                        break;
                    } else {
                        upNode = parent;
                        upHeight --;
                    }

                }
            }
            inputs--;
        }
        System.out.println(output);
    }


    private boolean isLeftChild(int curGuess) {
        return (curGuess & 1) != 0;
    }

    private int getRightChildVal(int parent, int h) {
        int childH = h + 1;
        int rChild = parent * 2;
        if (!guessMap.get(childH).containsKey(rChild)) {
            guessMap.get(childH).put(rChild,-1);
            return -1;
        }
        return guessMap.get(childH).get(rChild);
    }

    private int getleftChildVal(int parent, int h) {
        int childH = h + 1;
        int lChild = parent * 2 - 1;
        if (!guessMap.get(childH).containsKey(lChild)) {
            guessMap.get(childH).put(lChild,-1);
            return -1;
        }
        return guessMap.get(childH).get(lChild);
    }


    private int getSiblingVal(int curGuess, int h) {
        int sibling;
        if ((curGuess & 1) != 0) {
            sibling = curGuess + 1;
        } else {
            sibling = curGuess - 1;
        }
        if (!guessMap.get(h).containsKey(sibling)) {
            guessMap.get(h).put(sibling, -1);
            return -1;
        }
        return guessMap.get(h).get(sibling);
    }

    private int getParent(int curGuess, int h) {
        int pH = h - 1;
        if (pH < 0) {
            return -1;
        }
        int parent;
        if ((curGuess & 1) != 0) {
            parent = (curGuess + 1)/2;
        } else {
            parent = curGuess/2;
        }
        if (!guessMap.get(pH).containsKey(parent)) {
            guessMap.get(pH).put(parent, -1);
        }
        return parent;
    }
}
