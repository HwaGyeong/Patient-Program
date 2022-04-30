
package project;

import java.util.Scanner;

public class Tree {
    Node root;
    Scanner sc= new Scanner(System.in);
    
    public Tree(){
        root= null;
    }
    
    public Node getRoot(){
        return root;
    }
    
    public void createRoot(int newRootNodeID, String newQuestion){
        root = new Node(newRootNodeID, newQuestion);
      //  System.out.println("Created root node "+newRootNodeID);
    }
    
    public void addYesNode(int existingNodeID, int newNodeID, String newQuestion){
        if(root==null){
            System.out.println("ERROR: No root node! "
            +" Use createRoot method. ");
        }else{
            if(searchTreeAndAddYesNode(root, existingNodeID, newNodeID, newQuestion)){
               // System.out.println("Added node "+newNodeID+ " to yes branch. ");
            }
            else{
                System.out.println("Node "+existingNodeID+" not found! ");
            }
        }
    }
    
    private boolean searchTreeAndAddYesNode(Node currentNode, int existingNodeID, int newNodeID, String question){
        if(currentNode.nodeID ==existingNodeID){
            if(currentNode.yesBranch==null){
                currentNode.yesBranch= new Node(newNodeID, question);
            }else{
                System.out.println("WARNING: Overwriting previous yes node! ");
                currentNode.yesBranch= new Node(newNodeID, question);
            }
            return true;
        }
        else{
            if(currentNode.yesBranch!=null){
                if(searchTreeAndAddYesNode(currentNode.yesBranch,existingNodeID, newNodeID, question))
                    return true;
                else
                {
                   if(currentNode.noBranch != null){
                       return (searchTreeAndAddYesNode(currentNode.noBranch, existingNodeID, newNodeID, question));
                   } 
                   else
                       return false;
                }
            }else
                return false;
        }
    }


        public void addNoNode(int existingNodeID, int newNodeID, String newQuestion){
        if(root==null){
            System.out.println("ERROR: No root node! "
            +" Use createRoot method. ");
        }else{
            if(searchTreeAndAddNoNode(root, existingNodeID, newNodeID, newQuestion)){
               // System.out.println("Added node "+newNodeID+ " to no branch. ");
            }
            else{
                System.out.println("Node "+existingNodeID+" not found! ");
            }
        }
    }
        
         private boolean searchTreeAndAddNoNode(Node currentNode, int existingNodeID, int newNodeID, String question){
        if(currentNode.nodeID ==existingNodeID){
            if(currentNode.noBranch==null){
                currentNode.noBranch= new Node(newNodeID, question);
            }else{
                System.out.println("WARNING: Overwriting previous no node! ");
                currentNode.noBranch= new Node(newNodeID, question);
            }
            return true;
        }
        else{
            if(currentNode.yesBranch!=null){
                if(searchTreeAndAddNoNode(currentNode.yesBranch,existingNodeID, newNodeID, question))
                    return true;
                else
                {
                   if(currentNode.noBranch != null){
                       return (searchTreeAndAddNoNode(currentNode.noBranch, existingNodeID, newNodeID, question));
                   } 
                   else
                       return false;
                }
            }else
                return false;
        }
    }
         
         public void querybTree(Node currentNode){
             if(currentNode.yesBranch==null){
                 if(currentNode.question!=null)
                    System.out.println(currentNode.question);             
               return;
             }         
             askQuestion(currentNode);
         }
         private void askQuestion(Node currentNode){

             System.out.println(currentNode.question);
             String answer = sc.nextLine();
             answer = answer.toLowerCase();
             if(currentNode!=null){
                if(answer.equals("no")){
                    querybTree(currentNode.noBranch);
                }
                else{
                        querybTree(currentNode.yesBranch);
                    }
            }            
         }
         
}
