package org_nebra_listeners

import org.testng.IAnnotationTransformer
import org.testng.annotations.ITestAnnotation
import org_nebra_utils.DataProviderUtils
import java.lang.reflect.Constructor
import java.lang.reflect.Method

class AnnotationTransformer: IAnnotationTransformer {

    override fun transform(annotation: ITestAnnotation?, testClass: Class<*>?, testConstructor: Constructor<*>?, testMethod: Method?) {

        annotation?.dataProvider = "getData"
        annotation?.dataProviderClass = DataProviderUtils::class.java
        annotation?.setRetryAnalyzer(RetryFailedTests::class.java)
    }
}