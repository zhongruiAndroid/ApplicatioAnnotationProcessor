package com.zr.compiler;

import com.google.auto.service.AutoService;
import com.zr.annotation.AppLifeCycle;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class AppLifeCycleAnnotationProcessor extends AbstractProcessor {
    public static final boolean isDebug = false;
    public static final String AppLifecycleListener = "com.zr.api.AppLifecycleListener";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.zr.lifecycle.proxy";

    private Messager messager;
    private Filer filer;
    private Types typeUtils;
    private int startIndex = 0;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        print("=============startIndex:" + startIndex);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(AppLifeCycle.class);
        if (elementsAnnotatedWith == null) {
            return false;
        }
        for (Element element : elementsAnnotatedWith) {
            if (element == null) {
                continue;
            }
            if (!(element instanceof TypeElement)) {
                continue;
            }
            AppLifeCycle annotation = element.getAnnotation(AppLifeCycle.class);
            String value = annotation.value();
            if (value == null || value.replace(" ", "").length() <= 0) {
                continue;
            }
            TypeElement typeElement = (TypeElement) element;
            List<? extends TypeMirror> interfaces = typeElement.getInterfaces();
            if (interfaces == null || interfaces.size() <= 0) {
                continue;
            }
            boolean checkInterfaceFlag = false;
            for (TypeMirror typeMirror : interfaces) {
                if (typeMirror == null) {
                    continue;
                }
                if (AppLifecycleListener.equals(typeMirror.toString())) {
                    checkInterfaceFlag = true;
                }
            }
            if (!checkInterfaceFlag) {
                continue;
            }
            Name qualifiedName = typeElement.getQualifiedName();
            Name simpleName = typeElement.getSimpleName();
            print("=========目标类:" + qualifiedName);
            ProcessorHelper.createFile(messager, filer, PROXY_CLASS_PACKAGE_NAME + "." + value, qualifiedName.toString(), simpleName.toString(), startIndex);
            startIndex += 1;
            print("" +
                    "");
        }
        return startIndex > 0;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(AppLifeCycle.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private void print(String msg) {
        if (!isDebug) {
            return;
        }
        messager.printMessage(Diagnostic.Kind.NOTE, msg);
    }
}