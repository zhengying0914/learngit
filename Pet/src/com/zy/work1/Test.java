package com.zy.work1;

public class Test {
	public static void main(String[] args) {
		Pet[] p = new Pet[5];
		p[0] = new Dog();
		p[1] = new Cat();
		p[2] = new Dog();
		p[3] = new Cat();
		p[4] = new Dog();
		
		int i=0;
		for(i=0;i<5;i++) {
			p[i].call();
			p[i].run();
			if(p[i] instanceof Dog) {
				((Dog) p[i]).swim();
			}
			else {
				((Cat) p[i]).catchMouse();
			}
		}
		
	}
}
