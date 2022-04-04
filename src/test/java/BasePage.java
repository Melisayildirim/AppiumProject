import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.apache.log4j.LogManager;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

//import static java.util.prefs.WindowsPreferences.logger;
//import static jdk.internal.net.http.common.Log.logger;

public class BasePage extends BaseTest {
    Logger logger = null;

    @Step("<3> saniye kadar bekle")
    public void waitForSecond(int s) throws InterruptedException {
        Thread.sleep(1000 * s);
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/ivSplash> sayfasını kontrol et")
    public void uygulamaKontrol(String id) {
        if (appiumDriver.findElement(By.id(id)).isDisplayed()) {

            logger.info("Özdilekteyim uygulaması açıldı");
            waitForsecond(2);
        }
        else
        {
            logger.info("Özdilekteyim uygulaması açılamadı!");
            // Assert.assertFalse("Özdilekteyim uygulaması açılamadı!",+);
            waitForsecond(2);
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/tv_startShoppingStore> elementi bul ve tıkla")
    public void alisveriseBasla(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed())
        {
            element.click();
            logger.info("Alışverişe Başla butonu ekranda göründü");
        }
        else
        {
            logger.info("Alışverişe Başla butonu ekranda görünür olmadı");
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/container> sayfasını kontrol et")
    public void alisverisKontrol(String id)
    {
        if (appiumDriver.findElement(By.id(id)).isDisplayed()) {
            logger.info("ALIŞVERİŞE BAŞLA butonuna tıklandı");
            waitForsecond(2);
        }
        else
        {
            logger.info("ALIŞVERİŞE BAŞLA butonuna tıklanamadı");
            waitForsecond(2);
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/nav_categories> elementi bul ve tıkla")
    public void kategoriler(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed())
        {
            logger.info("Kategoriler elementi ekranda göründü");
            element.click();
        }
        else
        {
            logger.info("Kategoriler elementi ekranda görünür olmadı");
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/container> sayfasını kontrol et")
    public void kategorilerKontrol(String id) {
        if (appiumDriver.findElement(By.id(id)).isDisplayed()) {
            logger.info("Kategoriler butonuna tıklandı");
            waitForsecond(2);
        }
        else
        {
            logger.info("Kategoriler butonuna tıklanamadı !");
            waitForsecond(2);
        }
    }

    @Step("Xpath <//*[@class='androidx.recyclerview.widget.RecyclerView']/android.widget.RelativeLayout[2]\n> elementi bul ve tıkla")
    public void kadınsecenegi(String xpath) {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        if (element.isDisplayed()) {
            logger.info("Kadın seçeneği ekranda göründü");
            element.click();
        }
        else
        {
            logger.info("Kadın seçeneği ekranda görünür olmadı");
        }
    }

    @Step("Xpath <//*[@class='android.widget.RelativeLayout']//*[@text='Pantolon']> elementi bul ve tıkla")
    public void pantolonsecenegi(String xpath) {
        MobileElement element = appiumDriver.findElement(By.id(xpath));
        if (element.isDisplayed())
        {
            logger.info("Pantolon seçeneği ekranda göründü");
            element.click();
        }
        else
        {
            logger.info("Pantolon seçeneği ekranda görünür olmadı");
        }
    }

    @Step("Sayfayı aşağı doğru kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("Telefon Ekran Boyutu " + dims);
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        System.out.println("Başlangıç noktası " + pointOptionStart);
        pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 4);
        System.out.println("Bitiş noktası " + pointOptionEnd);
        try
        {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try
        {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Rastgele ürün seçme")
    public void randomÜrün()
    {
        Random random = new Random();
        List<MobileElement> randomProduct = (List<MobileElement>) appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/recyclerView"));
        MobileElement element = randomProduct.get(random.nextInt(randomProduct.size()));
        element.click();
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/imgFav> sayfasını kontrol et")
    public void favori(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed())
        {
            logger.info("Favoriler butonu ekranda göründü");
            element.click();
        }
        else
        {
            logger.info("Favoriler butonu ekranda görünür olmadı");
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/etEposta> sayfasını kontrol et")
    public void girisSayfasiKontrol(String id)
    {
        if (appiumDriver.findElement(By.id(id)).isDisplayed())
        {
            logger.info("Giriş yapma sayfası açıldı");
            waitForsecond(2);
        }
        else
        {
            logger.info("Giriş yapma sayfası açılmadı!");
            waitForsecond(2);
        }
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    private BasePage findElement(By by) {
    }

    @Step ("<id> e-mail")
    public void Login (String id)
    {
        if (id != null)
        {
            sendKeys(By.id(id),"melisa");
            logger.info(id+"E-mail girişi yapıldı");
        }
        else
        {
            logger.info(id+"E-mail yazılamadı");
        }
    }


    @Step ("<id> şifre")
    public void LoginSifre(String id)
    {
        if (id != null)
        {
            sendKeys(By.id(id),"melisa");
            logger.info(id + "şifre girişi yapıldı");
        }
        else
        {
            logger.info(id+"şifre yazılamadı");
        }
    }

    @Step("Id <id> elementi bul ve tıkla")
    public void geributonu(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed())
        {
            logger.info("Geri butonu");
            element.click();
        }
        else
        {
            logger.info("Geri butonu çalışmadı");
        }
    }

    @Step("Rastgele ürün seçme2")
    public void rastgeleÜrün2()
    {
        Random random = new Random();
        List<MobileElement> randomProduct = (List<MobileElement>) appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/recyclerView"));
        MobileElement element = randomProduct.get(random.nextInt(randomProduct.size()));
        element.click();
    }

    @Step("Xpath <//*[@resource-id='com.ozdilek.ozdilekteyim:id/tvInSizeItem']> elementi bul ve tıkla")
    public void bedenSecme()
    {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        if (element.isDisplayed())
        {
            logger.info("Beden seçme başarılı");
            element.click();
        }
        else
        {
            logger.info("Beden seçme başarısız");
        }
    }

    @Step("Id <com.ozdilek.ozdilekteyim:id/relLayAddCartBtn> elementi bul ve tıkla")
    public void sepeteEkle()
    {
        MobileElement element = appiumDriver.findElement(By.xpath(id));
        if (element.isDisplayed())
        {
            logger.info("Sepete ekleme başarılı");
            element.click();
        }
        else
        {
            logger.info("Sepete ekleme başarısız");
        }
    }


    private void waitForsecond(int i) {

    }


}