package ui;

public class SplashScreen {

    public void show() {

        System.out.println("****************************************************");
        System.out.println("*                                                  *");
        System.out.println("*                 CODEVAULT v1.0                   *");
        System.out.println("*       Interview Question Management System       *");
        System.out.println("*                                                  *");
        System.out.println("****************************************************");

        System.out.print("\nLoading");

        try {

            for (int i = 0; i < 5; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("\n");
    }
}
