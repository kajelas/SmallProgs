package designPattern.singleton;

public class Singleton {
	private static class SingletonHolder {
		private static final Singleton instance = new Singleton();
	}
	
	private Singleton() {}
	
	public static final Singleton getInstance() {
		return SingletonHolder.instance;
	}
}
