
package project;

public class Node  {
    public int nodeID;
    public String question = null;
    public Node yesBranch  = null;
    public Node noBranch   = null;

    /* CONSTRUCTOR */
    public Node(int newNodeID, String newQuestion) {
        nodeID     = newNodeID;
        question = newQuestion;
    }
    
    public void displayNode() {
        System.out.println("NodeID = " + nodeID + ", " + question);
    }
}
