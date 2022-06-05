package com.company.Newsletter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Post implements Clients {
    @Override
    public void handleEvent(int discount, String date) {
        File f;
        File path = new File("D:/Курсовая");
        try {
            f = File.createTempFile("Newsletter", ".txt", path);
            PrintWriter pw = new PrintWriter(f);
            pw.print("Скидки более " + discount + "% с " + date + "!");
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
