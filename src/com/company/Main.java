package com.company;

public class Main {

    public static void main(String[] args) {
	 Main app = new Main();
	 app.run();
    }

    private void run() {
        Function f = new Function();
        IntegralProcessor ip = new IntegralProcessor(f::calc);
        System.out.println(ip.calcLeftPhyramid(1.5,2.5,2));
    }
}
