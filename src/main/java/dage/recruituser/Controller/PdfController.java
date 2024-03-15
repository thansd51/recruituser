package dage.recruituser.Controller;

// 타임리프 템플릿 엔진에서 settlement.html 파일을 context와 내려준다.

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

String html = templateEngine.process("settlement", context);
// PdfRender 클래스
@Component
@RequiredArgsConstructor
@Slf4j
public class PdfRender {

    public ByteArrayOutputStream generatePdfFromHtml(String html)
            throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //renderer 설정
        ITextRenderer renderer = new ITextRenderer();

        renderer.getFontResolver();
        renderer.setDocumentFromString(html);
        renderer.layout();
        // PDF 만들어준다.
        renderer.createPDF(outputStream);

        outputStream.close();
        // outputStream 으로 리턴후 S3로 파일업로드를 stream 형태로 올린다.
        return outputStream;
    }
}
