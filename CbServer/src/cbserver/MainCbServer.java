package cbserver;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class MainCbServer {

	public static void main(String[] args) throws Exception {

		ORB orb = ORB.init(args, null);
		POA root = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		root.the_POAManager().activate();
		
		HelloServant helloObj = new HelloServant();
		helloObj.setOrb(orb);
		
		org.omg.CORBA.Object ref = root.servant_to_reference(helloObj);
		Hello helloRef = HelloHelper.narrow(ref);
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		NameComponent path[] = ncRef.to_name("MSG");
		ncRef.rebind(path, helloRef);
		
		System.out.println("UP AND RUNNING");
		while(true){
			orb.run();
		}
		
	}

}
