# Problem

**There are two workarounds for this problem suggested https://github.com/eclipse/org.aspectj/issues/170**

**Workarounds are implemented in the profiles ```no-inline``` and ```exclude-aspect```** 

Running newer versions of JaCoCo together with AspectJ LTW fails during weaving due to an unknown constant type 17. Please execute ```mvn clean verify``` to reproduce the problem.

```
java.lang.RuntimeException: Crashed whilst crashing with this exception: java.lang.RuntimeException: Unknown constant type 17
    at org.aspectj.weaver.bcel.BcelWeaver.weave(BcelWeaver.java:1727)
    at org.aspectj.weaver.bcel.BcelWeaver.weaveWithoutDump(BcelWeaver.java:1650)
    at org.aspectj.weaver.bcel.BcelWeaver.weaveAndNotify(BcelWeaver.java:1417)
    at org.aspectj.weaver.bcel.BcelWeaver.weave(BcelWeaver.java:1192)
    at org.aspectj.weaver.tools.WeavingAdaptor.getWovenBytes(WeavingAdaptor.java:549)
    at org.aspectj.weaver.tools.WeavingAdaptor.weaveClass(WeavingAdaptor.java:385)
    at org.aspectj.weaver.loadtime.Aj.preProcess(Aj.java:115)
    at org.aspectj.weaver.loadtime.ClassPreProcessorAgentAdapter.transform(ClassPreProcessorAgentAdapter.java:51)
    at java.instrument/java.lang.instrument.ClassFileTransformer.transform(ClassFileTransformer.java:246)
    at java.instrument/sun.instrument.TransformerManager.transform(TransformerManager.java:188)
    at java.instrument/sun.instrument.InstrumentationImpl.transform(InstrumentationImpl.java:563)
    at java.base/java.lang.ClassLoader.defineClass1(Native Method)
    at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1017)
    at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:174)
    at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:800)
    at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:698)
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:621)
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:579)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
    at de.example.Example.sayHello_aroundBody0(Example.java:7)
    at de.example.Example$AjcClosure1.run(Example.java:1)
    at org.aspectj.runtime.reflect.JoinPointImpl.proceed(JoinPointImpl.java:179)
    at de.example.ExampleAspect.around(ExampleAspect.java:13)
    at de.example.Example.sayHello(Example.java:1)
    at de.example.ExampleTest.testHello(ExampleTest.java:11)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:566)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
    at org.junit.runners.BlockJUnit4ClassRunner$1.evaluate(BlockJUnit4ClassRunner.java:100)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)
    at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
    at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
    at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
    at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365)
    at org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273)
    at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238)
    at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159)
    at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)
    at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)
    at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)
    at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)
    Caused by: java.lang.RuntimeException: Unknown constant type 17
    at org.aspectj.apache.bcel.classfile.ConstantPool.constantToString(ConstantPool.java:232)
    at org.aspectj.weaver.bcel.LazyMethodGen$BodyPrinter.printInstruction(LazyMethodGen.java:777)
    at org.aspectj.weaver.bcel.LazyMethodGen$BodyPrinter.print(LazyMethodGen.java:721)
    at org.aspectj.weaver.bcel.LazyMethodGen$BodyPrinter.run(LazyMethodGen.java:649)
    at org.aspectj.weaver.bcel.LazyMethodGen.print(LazyMethodGen.java:610)
    at org.aspectj.weaver.bcel.LazyClassGen.printOne(LazyClassGen.java:917)
    at org.aspectj.weaver.bcel.LazyClassGen.print(LazyClassGen.java:876)
    at org.aspectj.weaver.bcel.LazyClassGen.toLongString(LazyClassGen.java:864)
    at org.aspectj.weaver.bcel.BcelWeaver.weave(BcelWeaver.java:1725)
    ... 53 more
```

## Order of java-agents

I saw the recommendation to simply switch the order of Java agents, so that the AspectJ Java agent is executed first and the JaCoCo Java agents second. 
This, however, will prevent JaCoCo from calculating coverage for AspectJ weaved classes. 

### Explanation from the JaCoCo documentation

Jacoco uses classIds to connect coverage at runtime with the class files [(JaCoCo-documentation)](https://www.jacoco.org/jacoco/trunk/doc/classids.html).
ClassIds are calculated based on the byte code of classes. 
When the bytecode of a class is modified, JaCoCo calculates an incorrect classId and the coverage of this class cannot be determined.
Therefore, they recommend in their documentation: "If you use another Java agent make sure the JaCoCo agent is specified at first in the command line. This way the JaCoCo agent should see the original class files."

You can confirm this by running the profile "switch-order". It moves the AspectJ Java agent to the front and executes the JaCoCo Java agent afterwards. The result is that no coverage can be calculated.
