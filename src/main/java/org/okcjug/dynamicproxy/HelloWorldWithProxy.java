package org.okcjug.dynamicproxy;

public class HelloWorldWithProxy extends AbstractHelloWorld implements HelloWorld {

	public static void main(String[] args) {
		HelloWorld helloWorld = ProxyFactory.build(HelloWorld.class, new HelloWorldWithProxy());
		helloWorld.sayHelloWorld();
	}
}