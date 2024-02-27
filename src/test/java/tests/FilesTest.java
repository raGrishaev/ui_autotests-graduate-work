package tests;

import pages.FilesPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование загрузки файлов договоров Билайн с проверкой содержимого текста ")
@Tags({@Tag("ui"), @Tag("files")})
public class FilesTest extends TestBase {

    FilesPage filesPage = new FilesPage();

    @Test
    @DisplayName("Проверка содержимого текста загружаемого файла в формате PDF")
    @Story("Тест загрузки файла 'Заявление о расторжении договора' формата PDF с проверкой текста")
    @Severity(SeverityLevel.CRITICAL)
    void downloadContractPdfTest() {
        step("Открываем страницу с файлами договоров", () -> {
            filesPage.openFilesPage();
        });
        step("Скачиваем файл 'Заявление о расторжении договора' и проверяем его содержимое", () -> {
            filesPage.checkDownloadContractPdf("Addendum_Frame Contract");
        });

    }

    @Test
    @DisplayName("Проверка содержимого текста загружаемого файла в формате XLS")
    @Story("Тест загрузки файла 'Приложение 1 к дополнительному соглашению' формата XLS с проверкой текста)")
    @Severity(SeverityLevel.CRITICAL)
    void downloadApplicationXlsTest() {
        step("Открываем страницу с файлами договоров", () -> {
            filesPage.openFilesPage();
        });
        step("Скачиваем файл 'Приложение 1 к дополнительному соглашению' и проверяем его содержимое", () -> {
            filesPage.checkDownloadApplicationXls("АДРЕС РЕГИСТРАЦИИ");
        });

    }

}






