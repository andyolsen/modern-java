package solution.methods.factory;

public interface LoggerProvider {
	
	Logger getLogger();
	
	static Logger getNullLogger() {
		return (message) -> {};
	}
}
