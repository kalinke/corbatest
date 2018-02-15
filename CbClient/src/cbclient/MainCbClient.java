package cbclient;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class MainCbClient {

	static int i = 0;
	
	public static void main(String[] args) throws InvalidName, Exception{
		ORB orb = ORB.init(args, null);
		org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
		NamingContextExt ref = NamingContextExtHelper.narrow(obj);

		Hello hello = HelloHelper.narrow(ref.resolve_str("MSG"));
		
		System.out.println(hello.msg());
	} 
	
}
