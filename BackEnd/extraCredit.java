
import java.io.*;
import java.util.*;
public class extraCredit {

    public static String filterZipCode(ArrayList<String>s){
        String ans="";
        HashSet<Integer>brooklynZipCodes = new HashSet<>();
        brooklynZipCodes.add(11212);
        brooklynZipCodes.add(11213);
        brooklynZipCodes.add(11216);
        brooklynZipCodes.add(11233);
        brooklynZipCodes.add(11238);
        brooklynZipCodes.add(11209);
        brooklynZipCodes.add(11214);
        brooklynZipCodes.add(11228);
        brooklynZipCodes.add(11204);
        brooklynZipCodes.add(11218);
        brooklynZipCodes.add(11219);
        brooklynZipCodes.add(11230);
        brooklynZipCodes.add(11234);
        brooklynZipCodes.add(11236);
        brooklynZipCodes.add(11239);
        brooklynZipCodes.add(11223);
        brooklynZipCodes.add(11224);
        brooklynZipCodes.add(11229);
        brooklynZipCodes.add(11235);
        brooklynZipCodes.add(11201);
        brooklynZipCodes.add(11205);
        brooklynZipCodes.add(11215);
        brooklynZipCodes.add(11217);
        brooklynZipCodes.add(11231);
        brooklynZipCodes.add(11203);
        brooklynZipCodes.add(11210);
        brooklynZipCodes.add(11225);
        brooklynZipCodes.add(11226);
        brooklynZipCodes.add(11207);
        brooklynZipCodes.add(11211);
        brooklynZipCodes.add(11222);
        brooklynZipCodes.add(11220);
        brooklynZipCodes.add(11232);
        brooklynZipCodes.add(11206);
        brooklynZipCodes.add(11221);
        brooklynZipCodes.add(11237);
        ArrayList<Integer>zips = new ArrayList<>();
        for(int i=1;i<s.size();i++){
            String temp1 = s.get(i);
            String data1[] = temp1.split(",");
            int key = Integer.parseInt(data1[1]);
            if(brooklynZipCodes.contains(key)) {
                int value = Integer.parseInt(data1[2]);
                ans+=key;
                ans+=",";
                ans+=value;
                ans+="\n";
            }
        }
        return ans;
    }

    public static String expectedValues(ArrayList<String>s){
        String ans="";
        HashMap<Integer,Integer>totalCases = new HashMap<>();
        String temp = s.get(0);
        String tester[] =temp.split(",");
        int val = Integer.parseInt(tester[0]);
        ArrayList<Integer>check = new ArrayList<>();
        int counter=0;
        for(int i=0;i<s.size()-2;i++){
            String q = s.get(i);
            String t[] =q.split(",");
            int input1= Integer.parseInt(t[0]);
            int input2= Integer.parseInt(t[1]);
            if(input1==val){
                counter+=1;
            }
            if(!totalCases.containsKey(input1)){
                check.add(input1);
                totalCases.put(input1,input2);
            }
            else{
                int k = totalCases.get(input1);
                k+=input2;
                totalCases.replace(input1,k);
            }
        }
        for(int i=0;i<check.size();i++){
            int a=check.get(i);
            int tot = totalCases.get(a);
            float lambda = (float)tot/(float)counter;
            ans+=a;
            ans+=",";
            ans+=lambda;
            ans+="\n";
        }
        return ans;
    }
    //INPUT & OUTPUT
    public static ArrayList<String> inRead(String a) throws IOException {
        String line;
        ArrayList<String> instruction = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(a);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while ((line = br.readLine()) != null) {
            instruction.add(line);
        }
        br.close();
        if (fr != null) {
            fr.close();
        }
        return instruction;
    }
    public static void emitOutput(String a,String b)throws IOException{
        PrintWriter writer = new PrintWriter(b);
        writer.println(a);
        writer.close();
    }


    public static void main(String[] args) throws IOException{
        ArrayList<String>instructions = new ArrayList<>();
        ArrayList<String>instructions2 = new ArrayList<>();
        instructions=inRead("input.txt");
        String ans =filterZipCode(instructions);
        emitOutput(ans,"zipcodes.txt");
        instructions2=inRead("zipcodes.txt");
        String ans2 =expectedValues(instructions2);
        emitOutput(ans2,"out.txt");
    }


}
