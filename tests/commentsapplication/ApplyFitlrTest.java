package commentsapplication;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Olia on 04.07.2016.
 */
public class ApplyFitlrTest {

    @DataProvider(name = "data")
    public static Object[][] dataProvider() {
        return new Object[][] { { IBrowser.BrowserList.CHROME, IVersion.VersionList.VERSION1_0 },
                { IBrowser.BrowserList.CHROME, IVersion.VersionList.VERSION1_1 },
                { IBrowser.BrowserList.FIRE_FOX, IVersion.VersionList.VERSION1_0 },
                { IBrowser.BrowserList.FIRE_FOX, IVersion.VersionList.VERSION1_1 }
        };
    }


}
