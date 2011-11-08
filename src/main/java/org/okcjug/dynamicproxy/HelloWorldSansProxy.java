package org.okcjug.dynamicproxy;

public class HelloWorldSansProxy extends AbstractHelloWorld implements HelloWorld {

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldSansProxy();
		helloWorld.sayHelloWorld();
	}
	
	public void sayHelloWorld() {
		System.out.println("Do something before method call.");
		super.sayHelloWorld();
		System.out.println("Do something after method call.");
	}
}