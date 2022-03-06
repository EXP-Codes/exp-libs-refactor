package exp.libs.ocr;

import exp.libs.ocr.OCR;
import exp.libs.utils.file.FileUtils;
import exp.libs.utils.other.PathUtils;
import exp.libs.utils.str.StrUtils;

import java.io.File;

class OCRTest {

    public static void main(String[] args) {
        String moduleName = "exp-libs-image";
        String ocrDir = StrUtils.concat( "./", moduleName, "/data/ocr/tesseract");
        OCR ocr = new OCR(ocrDir);

        String imgDir = StrUtils.concat( "./", moduleName, "/src/test/resources/exp/libs/ocr");
        File dir = new File(imgDir);
        File[] imgs = dir.listFiles();
        for(File img : imgs) {
            String name = img.getName();
            String content = ocr.recognizeText(img.getAbsolutePath());
            System.out.println(name + " : " + content);
        }
    }

}