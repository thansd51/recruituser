package dage.recruituser.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Controller
public class PdfController {

    private final TemplateEngine templateEngine;

    public PdfController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @PostMapping("/convertToPdf")
    public void convertToPdf(@RequestParam("name") String name, HttpServletResponse response) throws Exception {
        // Thymeleaf 컨텍스트 설정
        Context context = new Context();
        context.setVariable("name", name); // 파라미터로 전달된 이름 설정

        // Thymeleaf 템플릿 로드 및 프로세스
        String htmlContent = templateEngine.process("template.html", context);

        // Flying Saucer를 사용하여 HTML을 PDF로 변환
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);

            // PDF 파일로 출력
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=output.pdf");
            try (OutputStream responseOutputStream = response.getOutputStream()) {
                outputStream.writeTo(responseOutputStream);
                outputStream.flush();
            }
        }
    }
}
