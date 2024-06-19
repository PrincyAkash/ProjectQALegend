package listeners;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Annotation_Transformer implements IAnnotationTransformer // to give rety with xml file 
{
 
	public void transform(ITestAnnotation annotation,Class testclass , Constructor testconstructor,Method testmethod) 
	{
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}