package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> data = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException{
        //int n = 50;
        //int n = 100;
       int n = 200;
        // int n = 500;
        // int n = 1000;
        // int n = 2000;
        // int n = 5000;
        // int n = 10000;
        double m;int k; double c=0;
        ArrayList<Integer> aa = new ArrayList<Integer>();
        ArrayList<Integer> bb = new ArrayList<Integer>();
        ArrayList<Double> cc = new ArrayList<Double>();
        ArrayList<Double> p = new ArrayList<Double>();
        ArrayList<Double> w = new ArrayList<Double>();
        double ccc;

        //for(int i = 0; i < n; i ++){ m =1+ (int)(Math.random()*99); w.add(m);}            //uncorrelated
        //for(int i = 0; i < n; i ++){m = 1+(int)(Math.random()*30); p.add(m);}             //uncorrelated
        //for(int i = 0; i < n; i ++){ m =101+ (int)(Math.random()*1000); w.add(m);}            //weakly correlated
        //for(int i = 0; i < n; i ++){p.add(w.get(i)-100+(int)(Math.random()*200));}            //weakly correlated

        for(int i = 0; i < n; i ++){ m =1+ (int)(Math.random()*99); w.add(m);}              //strongly correlated
        for(int i = 0; i < n; i ++){p.add(w.get(i)+10);}                                    //strongly correlated

        for (int i = 0; i < n; i++)
        {
            ccc = w.get(i)/p.get(i);
            cc.add(ccc);
        }
        //c = 2*100;
        for(int i = 0; i < n; i++) c=c+w.get(i);c=c/2;

        data.add(n);
        data.add((int)c);
        System.out.println("неотсортированные профиты:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(p.get(i) + " ");
        }
        System.out.println("");
        System.out.println("неотсортированные веса:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(w.get(i) + " ");
        }
        System.out.println("неотсортированные отношения:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(cc.get(i) + " ");
        }
        System.out.println("");
        bubble(cc, p, w, n);
        System.out.println("отсортированные профиты:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(p.get(i) + " ");
        }
        System.out.println("");
        System.out.println("отсортированные веса:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(w.get(i) + " ");
        }
        System.out.println("отсортированные отношения:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(cc.get(i) + " ");
        }
        System.out.println("");
        for(int i = 0; i < n; i++){
            m = p.get(i); k=(int)m;
            data.add(k);}
        for(int i = 0; i < n; i++){
            m = w.get(i); k=(int)m;
            data.add(k);}
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\try\\strongly_correlated_2v_50.txt")));
        for (int i = 0; i < data.size(); i++) {

                writer.write(String.valueOf(data.get(i)));
                writer.write(" ");

            //writer.write("\r\n");
        }
        writer.flush();
    }
    public static void bubble(ArrayList<Double> a, ArrayList<Double> b, ArrayList<Double> c, int n)
    {
        for (int i=n-1; i>=0; i--)
        {
            for (int j=0; j<i; j++)
            {
                if (a.get(j) > a.get(j + 1))
                {
                    double tmp = a.get(j);
                    double tmp2 = b.get(j);
                    double tmp3 = c.get(j);
                    a.set(j, a.get(j + 1));
                    b.set(j, b.get(j + 1));
                    c.set(j,c.get(j+1));
                    a.set(j+1,tmp);
                    b.set(j+1, tmp2);
                    c.set(j+1, tmp3);
                }
            }
        }
    }
}
