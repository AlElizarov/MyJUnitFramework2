package myJUnit;

public class Messager {
	
	private boolean isOk;
	private boolean isFailed;
	private boolean isFailure;
	private String mes;
	
	public Messager() {
	}
	
	public Messager(String mes) {
		this.mes = mes;
	}
	
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public boolean isFailed() {
		return isFailed;
	}
	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}
	public boolean isFailure() {
		return isFailure;
	}
	public void setFailure(boolean isFailure) {
		this.isFailure = isFailure;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

}
