import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;
public class url_database{
    public static void main(String[] args)throws Exception{
        HashMap<String,String> db1=new HashMap<String,String>();
        HashMap<String,Integer> db2=new HashMap<String,Integer>();
        int con=1;
        do{
            Scanner sc= new Scanner(System.in);
            String url[]= sc.nextLine().split(" ");
            switch(url[0])
            {
                case "storeurl":    String uk[] = url[1].split("\\.");
                                    db1.put(url[1],uk[1]);
                                    db2.put(url[1],0);
                                    break;
                case "get":         System.out.println(db1.get(url[1]));
                                    int c = db2.get(url[1])+1;
                                    db2.put(url[1],c);
                                    break;
                case "count":       System.out.println(db2.get(url[1]));
                                    break;
                case "list":
                                    Iterator  nxt= db1.entrySet().iterator();
                                    System.out.println(" {\n\"url_database\":\n [\n");
                                    int s=0;
                                    while(nxt.hasNext())
                                    {
                                        if(s>0)
                                        {
                                            System.out.println(",\n");
                                        }
                                        Map.Entry me=(Map.Entry)nxt.next();
                                        String urls=""+me.getKey();
                                        String uky=""+me.getValue();
                                        String cn=""+db2.get(urls);
                                        System.out.println("{");
                                        System.out.println("\"URL\":"+"\""+urls+"\"\n" );
                                        System.out.println("\"Key\":"+"\""+uky+"\"\n" );
                                        System.out.println("\"Count\":"+"\""+cn+"\"\n" );
                                        System.out.println("}");
                                        s++;

                                    }
                                    System.out.println("]\n}");
                                    break;
                case "exit":        exit(0);
                default:            System.out.println("Invalid Command");
                                    break;
            }

        }while(con==1);
    }
}