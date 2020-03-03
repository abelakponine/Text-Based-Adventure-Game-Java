
/**
 * Write a description of class Test_GameObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_GameObject
{
    private GameObject gameObject;

    public Test_GameObject()
    {
        gameObject = new GameObject();
        // set properties
        gameObject.setName("TestScene");
        gameObject.setIndex(4);
        //get properties
        System.out.println(""+gameObject.getName());
        System.out.println(gameObject.getIndex());
    }
}
