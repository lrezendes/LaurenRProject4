package comp.comp152;

public class Node {
    boolean visited;
    String data;
    Node[] neighbors;

    public Node (String Data)  {
        this.data = Data;
    }
    public void visit(){
        System.out.println(data);
        visited = true;
    }
}