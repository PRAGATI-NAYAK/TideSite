package uistore;

import org.openqa.selenium.By;

public class ApplicationUI {

	public By free = By.xpath("//*[@id='site-content']/div/div/div/div[1]/div[5]/div/div/div/div[2]/div/div[2]/div[1]/a/p/strong");
	public By wash = By.xpath("//*[@id='site-header']/div[3]/div/div/div/div[3]/a");
	public By product = By.xpath("//*[@id='site-header']/div[3]/div/div/div/div[1]/a");
	public By button = By.xpath("//button[@type='submit']");
	public By Search = By.xpath("//input[@placeholder='Search']");
	public By anti = By.xpath("//a[@href='https://tide.com/en-us/shop/type/fabric-care/tide-antibacterial-fabric-spray']//p//strong");
	public By Powder = By.xpath("//a[@data-action-detail='Powder']");
	public By Laundry = By.xpath("//*[@id='site-footer']/div[2]/div/div[2]/div/div[1]/div[2]/a");
	public By learn = By.xpath("//*[@id='site-content']/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/a[2]");
	public By read = By.xpath("//div[@class='article-preview-content']//a//p[contains(text(),'How to Read Laundry Symbols')]");
    public By preview = By.xpath("//div[@class='product-preview']");

}
