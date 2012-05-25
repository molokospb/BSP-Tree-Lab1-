/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 20.04.12
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class Node<E> {
    Node left;
    Node right;
    Point value;

    public Node(Point value) {
        this.value = value;
    }

    public void setValue(Point value) {
        this.value = value;
    }
}
