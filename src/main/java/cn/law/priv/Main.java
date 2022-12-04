package cn.law.priv;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        ClassName className = ClassName.get("cn.law.priv", "Test");
        TypeSpec.Builder testBuilder = TypeSpec.classBuilder("Test").addModifiers(Modifier.PUBLIC);
        ClassName testParameterClassName = ClassName.get("java.lang", "String");
        ParameterSpec testParameter = ParameterSpec.builder(testParameterClassName, "arg").build();
        MethodSpec testMethod = MethodSpec.methodBuilder("test").addModifiers(Modifier.PUBLIC).addParameter(testParameter).build();
        TypeSpec test = testBuilder.addMethod(testMethod).build();
        JavaFile file = JavaFile.builder("cn.law.priv", test).build();
        try {
            Path relative = Paths.get("./src/main/java/");
            file.writeTo(relative);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
