package kz.ugs.callisto.mis.loaders.sheet.model;

/**Класс модель показатель
 * @author ZTokbayev
 * создан 22/11/2017
 */
public class Indicator {

	/**
	 * наименование 
	 */
	private String name;

	/**
	 * @param name
	 */
	public Indicator(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	public Indicator() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
