package designPattern.factory;


public class MacProducer extends PcProducer {

	@Override
	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new MacCpu();
	}

	@Override
	public Ram createRam() {
		// TODO Auto-generated method stub
		return new MacRam();
	}
	
	private MacProducer(){}
	
	public static PcProducer getInstance() {
		return InstanceHolder.producer;
	}

	private static class InstanceHolder {
		private final static PcProducer producer = new MacProducer(); 
	}
}
