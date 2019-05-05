import java.lang.instrument.Instrumentation;

public class ObjectSizeFinder {
	private static volatile Instrumentation instrumentation;


	//Implementation of the overloaded premain method that is first invoked by
	//the JVM during use of instrumentation.
	public static void premain(String agentArgs, Instrumentation inst) {
		instrumentation = inst;
		System.out.println("Agent-> In premain method");
	}

	//Implementation of the overloaded agentmain method that is invoked for
	//accessing instrumentation of an already running JVM.
	public static void agentmain(String agentArgs, Instrumentation inst) {
		instrumentation = inst;
		System.out.println("Agent-> In agentmain method");
	}


	public  static long getObjectSize(Object o) {
		if (instrumentation == null)
	      {
	         throw new IllegalStateException("Agent-> not initialized.");
	      }
		return instrumentation.getObjectSize(o);
	}
}
