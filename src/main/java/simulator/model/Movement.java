package simulator.model;

public enum Movement {
	
	FORWARD('A'), LEFT('L'), RIGHT('R');
	
	private char commandKey;

	private Movement(char commandKey) {
		this.commandKey = commandKey;
	}

	public char getCommandKey() {
		return commandKey;
	}
	
}
