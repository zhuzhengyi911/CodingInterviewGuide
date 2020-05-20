package mytest.readXml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @program: CodingInterviewGuide
 * @description:
 * @author: Zhu Zheng-yi
 * @create: 2020-05-11 15:13
 **/

public class ParseXml {

    private Document document;

    private Element rootElm;

    private View root;

    private static int count = 1;

    public void parse(String path){
        load(path);
        rootElm = document.getRootElement().element("node");
        root = new View();
        root.parent = null;
        traverse(rootElm, root);
        printTree(root);
    }

    private void traverse(Element e , View v){

        // 数据获取
        for (Attribute a : e.attributes()){
            System.out.print(a + " ");
        }
        System.out.println();
        v.id = count++;

        // 遍历
        for (Element childElm : e.elements()){
            View child = new View();
            v.nexts.add(child);
            child.parent = v;
            traverse(childElm, child);
        }
    }

    private void load(String filename) {
        try {
            SAXReader saxReader = new SAXReader();
            this.document = saxReader.read(new File(filename));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printTree(View v){
        System.out.println(v.id);
        for (View child : v.nexts){
            printTree(child);
        }
    }

    public static void main(String[] args) {
        String xmlPath = "F:\\IdeaProjects\\CodingInterviewGuide\\src\\main\\resources\\widget2.xml";
        ParseXml parser = new ParseXml();
        parser.parse(xmlPath);
    }

}
