package com.zr.compiler;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

import javax.annotation.Resource;
import javax.annotation.processing.Filer;
import javax.annotation.processing.FilerException;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;


public class ProcessorHelper {
    public static final String PROXY_CLASS_SIMPLE_NAME = "AppLifecycle$$Application";

    public static void createFile(Messager messager, Filer filer, String targetPackage, String qualifiedName, String simpleName, int index) {
        Writer writer = null;
        PrintWriter printWriter = null;
        try {
            String s = targetPackage + "." + PROXY_CLASS_SIMPLE_NAME + index;
            if (AppLifeCycleAnnotationProcessor.isDebug) {
                messager.printMessage(Diagnostic.Kind.NOTE, "=========代理类:" + s);
            }
            JavaFileObject sourceFile = filer.createSourceFile(s);

            writer = sourceFile.openWriter();
            printWriter = new PrintWriter(writer);


            printWriter.println("package " + targetPackage + ";");
            printWriter.println("import android.app.Application;");
            printWriter.println("import android.content.Context;");
            printWriter.println("import android.content.res.Configuration;");
            printWriter.println("import " + qualifiedName + ";");
            printWriter.println("import " + AppLifeCycleAnnotationProcessor.AppLifecycleListener + ";");
            printWriter.println("public class " + PROXY_CLASS_SIMPLE_NAME + index + " implements AppLifecycleListener {");
            printWriter.println("    private " + simpleName + " a;");
            printWriter.println("    public " + PROXY_CLASS_SIMPLE_NAME + index + "() {");
            printWriter.println("        this.a = new " + simpleName + "();");
            printWriter.println("    }");
            printWriter.println("    public int getPriority() {");
            printWriter.println("        return a.getPriority();");
            printWriter.println("    }");
            printWriter.println("    public void onCreate(Application application) {");
            printWriter.println("        a.onCreate(application);");
            printWriter.println("    }");
            printWriter.println("    public void attachBaseContext(Application application, Context base) {");
            printWriter.println("        a.attachBaseContext(application, base);");
            printWriter.println("    }");
            printWriter.println("    public void onConfigurationChanged(Application application, Configuration newConfig) {");
            printWriter.println("        a.onConfigurationChanged(application, newConfig);");
            printWriter.println("    }");
            printWriter.println("    public void onLowMemory(Application application) {");
            printWriter.println("        a.onLowMemory(application);");
            printWriter.println("    }");
            printWriter.println("    public void onTerminate(Application application) {");
            printWriter.println("        a.onTerminate(application);");
            printWriter.println("    }");
            printWriter.println("    public void onTrimMemory(Application application, int level) {");
            printWriter.println("        a.onTrimMemory(application, level);");
            printWriter.println("    }");
            printWriter.println("}");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                //不能close
//                printWriter.close();
            }
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}