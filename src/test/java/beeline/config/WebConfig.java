package beeline.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config{
    @Key("baseUrl")
    @DefaultValue("https://moskva.beeline.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("isRemote")
    @DefaultValue("true")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}