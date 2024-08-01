package assignment2;
import java.util.*;
public class Alphabets {
    public static boolean findValid(String str){
        int[] alphabets=new int[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            alphabets[ch-'a']++;
        }
        boolean flag=true;
        for (int element : alphabets) {
            if (element == 0) {
                flag = false;
                break;
            }
        }
        return  flag;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="abcdefghijklmnopqrstuvwxyz";
        System.out.println(findValid(s));
        String str=sc.next();
        System.out.println(findValid(str));
    }
}
