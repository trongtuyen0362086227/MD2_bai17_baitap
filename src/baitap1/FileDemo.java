package baitap1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = readDataformFile("taptinnguon");
        writeDataToFile("taptindich", list, tinhkytu(list));

    }

    public static List<String> readDataformFile(String path) {
        List<String> list = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return list;
    }

    public static void writeDataToFile(String path, List<String> list, String sokytu) {
        File file = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            file = new File(path);
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            for (String str : list) {
                bw.write(str);
                bw.flush();
                bw.newLine();
            }
            bw.write(sokytu);
            bw.flush();

        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

    public static String tinhkytu(List<String> list) {
        int cnt = 0;
        for (String str : list) {
            cnt += str.length();
        }
        return "So ky tu la: " + cnt;
    }
}

