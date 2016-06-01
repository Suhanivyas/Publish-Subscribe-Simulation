import java.util.ArrayList;
import java.util.Arrays;

/**
* class Test --- class to test functioning of whole system.  
* Topics created are Food,Health and Books.
*  Suhani subscribes Food,Health and Books in PULL mode
*  Shamvi subscribes Health and Books in PUSH mode
*  Publish data via command line input.
* @author    Suhani Vyas 
*/
public class Test {
	public static void main(String[] args) {
		TopicPublisher p1=new TopicPublisher("Food","/Users/suhanivyas/Desktop/Food.txt");
		TopicPublisher p2=new TopicPublisher("Health","/Users/suhanivyas/Desktop/health.txt");
		Subscriber s1=new Subscriber("Suhani",SubscriberType.PULL, new ArrayList<TopicPublisher>(Arrays.asList(p1,p2)));
		p1.start();
		Subscriber s2=new Subscriber("Shamvi",SubscriberType.PUSH,new ArrayList<TopicPublisher>(Arrays.asList(p2)));
		p2.start();
		s1.start();
		s2.start();
		TopicPublisher p3=new TopicPublisher("Books","/Users/suhanivyas/Desktop/Book.txt");
		s2.subscribePublisher(p3);
		s1.unsubscribePublisher(p1);
		p3.start();	

	 }
}
