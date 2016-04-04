package designPattern.factory;

public class DellProducer extends PcProducer {

	@Override
	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new DellCpu();
	}

	@Override
	public Ram createRam() {
		// TODO Auto-generated method stub
		return new DellRam();
	}
	
	private DellProducer(){}
	
	public static PcProducer getInstance() {
		return InstanceHolder.producer;
	}

	private static class InstanceHolder {
		private final static PcProducer producer = new DellProducer(); 
	}
}
