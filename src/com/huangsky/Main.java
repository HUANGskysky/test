package com.huangsky;

import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Set;


public class Main {
    /**
     *
     * @param index  索引
     * @param object  目标
     */
    public static void print(int index,Object object){
        System.out.println(String.format("{%d},%s",index,object.toString()));
    }

    public static void demoFunction(){
        Random random = new Random();
        //random.setSeed(1);//种子数
        print(1,random.nextInt(1000));
        print(2,random.nextFloat());

        List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
        Collections.shuffle(array);
        print(3,array);


        Date date = new Date();
        print(4,date);
        print(5,date.getTime());

        DateFormat df = new SimpleDateFormat("yy");


    }

    public static void main(String[] args) {
	// write your code here
        /*System.out.println("Hello nowcoder!");
        print(1,"HELLO WORLD!");*/

        //测试随机数
        /*demoFunction();*/
        String txtPath = "C:\\Users\\Hsky\\Desktop\\abc.txt";
        readTxt(txtPath);

    }

    /**
     *
     * @param  filePath txt文件的路径
     *
     */

    public static void readTxt(String filePath){
        try{
            File file = new File(filePath);
            if(file.isFile() && file.exists()){
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder strBuf = new StringBuilder();
                String lineTxt;
                Hashtable<String,String> table = new Hashtable<>();
                while((lineTxt = br.readLine() )!= null){

                   //去除多余的的空格
                    lineTxt = lineTxt.replaceAll("\\s{2,}"," ");
                    System.out.println(lineTxt);
                    //根据空格划分成字符串数组
                    String[] strs = lineTxt.split(" ");
                    //按照key-value格式存进哈希表中
                    for (int i= 0;i<strs.length-1;i++) {
                        switch (strs[i]){
                            case "name":table.put("name",strs[i+1]);break;
                            case "age":table.put("age",strs[i+1]);break;
                            case "address":table.put("address",strs[i+1]);break;
                            case "work":table.put("work",strs[i+1]);break;
                            default:break;
                        }
                    }
                }
                for(Map.Entry entry : table.entrySet()){
                    System.out.println(entry.getKey() +"---"+ entry.getValue());
                }
                br.close();
            }else {
                System.out.println("文件不存在");
            }
        }catch (Exception e){
            System.out.println("文件读取错误");
        }
    }




}
