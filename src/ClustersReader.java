import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Анастасия on 22.05.2017.
 */
public class ClustersReader {
    public static ArrayList<ArrayList<Double>> subTrees = new ArrayList<>();
    public static ArrayList<ArrayList<Double>> getSubTrees(){
        String[] str = null;
        try {
            initialize();
        }catch (IOException e){

        }
        return subTrees;
    }
    public static void initialize() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("clusters.txt"));
        PrintWriter pw = new PrintWriter("list.txt");

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Map<Integer, ArrayList<Double>> map = new LinkedHashMap<>();
        Map<Integer, ArrayList<Integer>> map1 = new LinkedHashMap<>();
        Map<Integer, ArrayList<Integer>> kids = new LinkedHashMap<>();

        int i = 1;
        ArrayList<Double> list = new ArrayList<>();
        list.add(Double.parseDouble(line[0]));
        list.add(Double.parseDouble(line[1]));
        System.out.println(i + ":  " + list);
        map.put(i, list);
        ArrayList<Integer> k = new ArrayList<>();
        k.add(0);
        k.add(0);
        kids.put(i, k);

        i++;
        int num = 2;

        for (int ii = 0; ii < n - 1; ii++) {
            line = br.readLine().split(" ");
            double first = Double.parseDouble(line[0]);
            double second = Double.parseDouble(line[1]);
            ArrayList<Double> f, s, res;
            res = new ArrayList<>();
            ArrayList<Integer> k1 = new ArrayList<>();
            ArrayList<Integer> k2 = new ArrayList<>();
            //System.out.println(first+" "+second);
            if (first > n) {
                int get = (int) (first - (n));
                f = map.get(get);
                if (f != null) {
                    res.addAll(f);
                }
                k1.add((int) (first - n));
                k2.add((int) (first - n));
            } else {
                k1.add(0);
                k2.add((int)first);
                res.add(first);
            }
            if (second > n) {
                int get = (int) (second - (n));
                //System.out.println(get);
                s = map.get(get);
                if (s != null) {
                    res.addAll(s);
                }
                k1.add((int) (second - n));
                k2.add((int) (second - n));

            } else {
                res.add(second);
                k1.add(0);
                k2.add((int)second);
            }
            Collections.sort(res);
            System.out.println(i + ":  " + res + res.size());
            map.put(i, res);
            kids.put(i, k1);
            map1.put(i,k2);
            i++;

        }


        ArrayList<Double> list1 = map.get(i - 1);
        ArrayList<Double> list2 = map.get(i - 2);
        System.out.println(map.size());
        System.out.println(map.get(i - 1).size());
        System.out.println(map.get(i - 2).size());

        int c = 8;

        ArrayList<Integer> my = new ArrayList<>(c);
        my.addAll(map1.get(map.size()));
        for (i=map.size()-1;i>1;i--){
            if (my.size()==c){
                break;
            }
            ArrayList<Integer> r;
            r = map1.get(i);
            System.out.println("r: "+r);
            int parent = 0;
            for (Map.Entry<Integer,ArrayList<Integer>> ii : kids.entrySet()){
                if ((ii.getValue().get(0))==(double)r.get(0)&&(ii.getValue().get(1))==(double)r.get(1)){
                    parent = ii.getKey();
                }
            }
            System.out.println("parent: "+parent);
            my.remove(my.indexOf(parent));
            my.addAll(r);

        }
        System.out.println("Treees: "+my);


        for (int j = 0; j<my.size();j++){
            subTrees.add(new ArrayList<Double>());
            subTrees.get(j).addAll(map.get(my.get(j)));
        }
        System.out.println(subTrees.size());



        System.out.println(kids);
        br.close();
        pw.flush();
        pw.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("clusters.txt"));
        PrintWriter pw = new PrintWriter("list.txt");

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Map<Integer, ArrayList<Double>> map = new LinkedHashMap<>();
        Map<Integer, ArrayList<Integer>> map1 = new LinkedHashMap<>();
        Map<Integer, ArrayList<Integer>> kids = new LinkedHashMap<>();

        int i = 1;
        ArrayList<Double> list = new ArrayList<>();
        list.add(Double.parseDouble(line[0]));
        list.add(Double.parseDouble(line[1]));
        System.out.println(i + ":  " + list);
        map.put(i, list);
        ArrayList<Integer> k = new ArrayList<>();
        k.add(0);
        k.add(0);
        kids.put(i, k);

        i++;
        int num = 2;

        for (int ii = 0; ii < n - 1; ii++) {
            line = br.readLine().split(" ");
            double first = Double.parseDouble(line[0]);
            double second = Double.parseDouble(line[1]);
            ArrayList<Double> f, s, res;
            res = new ArrayList<>();
            ArrayList<Integer> k1 = new ArrayList<>();
            ArrayList<Integer> k2 = new ArrayList<>();
            //System.out.println(first+" "+second);
            if (first > n) {
                int get = (int) (first - (n));
                f = map.get(get);
                if (f != null) {
                    res.addAll(f);
                }
                k1.add((int) (first - n));
                k2.add((int) (first - n));
            } else {
                k1.add(0);
                k2.add((int)first);
                res.add(first);
            }
            if (second > n) {
                int get = (int) (second - (n));
                //System.out.println(get);
                s = map.get(get);
                if (s != null) {
                    res.addAll(s);
                }
                k1.add((int) (second - n));
                k2.add((int) (second - n));

            } else {
                res.add(second);
                k1.add(0);
                k2.add((int)second);
            }
            Collections.sort(res);
            System.out.println(i + ":  " + res + res.size());
            map.put(i, res);
            kids.put(i, k1);
            map1.put(i,k2);
            i++;

        }


        ArrayList<Double> list1 = map.get(i - 1);
        ArrayList<Double> list2 = map.get(i - 2);
        System.out.println(map.size());
        System.out.println(map.get(i - 1).size());
        System.out.println(map.get(i - 2).size());

        int c = 2;

        ArrayList<Integer> my = new ArrayList<>(c);
        my.addAll(map1.get(map.size()));
        for (i=map.size()-1;i>1;i--){
            if (my.size()==c){
                break;
            }
            ArrayList<Integer> r;
            r = map1.get(i);
            System.out.println("r: "+r);
            int parent = 0;
            for (Map.Entry<Integer,ArrayList<Integer>> ii : kids.entrySet()){
                if ((ii.getValue().get(0))==(double)r.get(0)&&(ii.getValue().get(1))==(double)r.get(1)){
                    parent = ii.getKey();
                }
            }
            System.out.println("parent: "+parent);
            my.remove(my.indexOf(parent));
            my.addAll(r);

        }
        System.out.println("Treees: "+my);


        for (int j = 0; j<my.size();j++){
            subTrees.add(new ArrayList<Double>());
            subTrees.get(j).addAll(map.get(my.get(j)));
        }
        System.out.println(subTrees.size());



        System.out.println(kids);
        br.close();
        pw.flush();
        pw.close();
    }

    public static ArrayList<Integer> getBorders(){
        ArrayList<Integer> borders = new ArrayList<>();
        borders.add(10);
        borders.add(21);
        borders.add(25);
        borders.add(54);
        borders.add(58);
        borders.add(65);
        borders.add(71);
        borders.add(75);
        borders.add(80);
        borders.add(84);
        borders.add(90);
        borders.add(95);
        borders.add(112);
        borders.add(119);
        borders.add(122);
        borders.add(126);
        borders.add(130);
        return borders;
    }



}
