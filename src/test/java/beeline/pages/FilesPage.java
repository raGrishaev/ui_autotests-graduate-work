package beeline.pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesPage {

  private final SelenideElement
            contractLinkPdf = $("a[href*='https://static.beeline.ru/upload/images/B2b/help/" +
          "b2cc-2922-zayavlenie-o-rastorzhenii-dogovora.pdf']"),
            applicationLinkXls = $("a[href*='https://static.beeline.ru/upload/images/B2b/help/" +
                    "b2cc-2922-prilozhenie-1-k-dopolnitelnomu-soglasheniyu.xls']");

    public FilesPage openFilesPage() {
        open("/business/help/documents/obrazcy-zayavlenij/" +
                "zaiavleniia-na-izmenenie-i-rastorzhenie-dogovora/");
        return this;
    }

    public FilesPage checkDownloadContractPdf(String expectedText) throws Exception {
        File downloaded = contractLinkPdf.download();
        PDF pdf = new PDF(downloaded);
        Assertions.assertEquals(expectedText, pdf.title);
        return this;
    }

    public FilesPage checkDownloadApplicationXls(String expectedText) throws Exception {
        File downloaded = applicationLinkXls.download();
        XLS xls = new XLS(downloaded);
        Assertions.assertEquals(expectedText,
                xls.excel.getSheetAt(0).
                        getRow(2)
                        .getCell(6)
                        .getStringCellValue());
        return this;
    }

}









