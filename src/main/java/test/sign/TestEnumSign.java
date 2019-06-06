package test.sign;

public enum TestEnumSign {
	INSTANCE;
	
	private SignUser signUser;
	public void TestEnumSign() {
		signUser = new SignUser();
	}

	public SignUser getSign() {
		return signUser;
	}

}
