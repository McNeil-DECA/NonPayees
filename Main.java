import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws Exception {
        Scanner members = new Scanner(new File("DECA Members.txt"));
        ArrayList<String> memNames = new ArrayList<>();
        ArrayList<String> payNames = new ArrayList<>();
        ArrayList<String> payEmails = new ArrayList<>();
        
        while(members.hasNextLine()) {
            Scanner membersNew = new Scanner(members.nextLine());
            String temp = "";
            while(membersNew.hasNext()) {
                temp+=membersNew.next();
                if(membersNew.hasNext()) {
                    temp+=" ";
                }
            }
            
            temp = temp.toLowerCase();
            // for(String str : memNames) {
            //     if(str.equals(temp)) {
            //         System.out.println(temp);
            //     }
            // }
            memNames.add(temp);
            membersNew.close();
        }
        members.close();
        // for(String str : memNames) {
        //     System.out.println(str);
        // }
        
        // Scanner payees = new Scanner(new File("Payees.txt"));
        // while(payees.hasNextLine()) {
        //     String line = payees.nextLine();
        //     if(line.contains("Student Name")) {
        //         String[] temp = line.split(" : ");
        //         line = temp[1];
        //         line = line.toLowerCase();
        //         payNames.add(line);
        //     }
        //     if(line.contains("Email Address")) {
        //         String[] temp = line.split(" : ");
        //         line = temp[1];
        //         line = line.toLowerCase();
        //         payEmails.add(line);
        //     }
        // }
        // payees.close();
        
        
        Scanner emails = new Scanner(new File("Member Emails.txt"));
        ArrayList<String> memEmails = new ArrayList<>();
        while(emails.hasNextLine()) {
            String line = emails.nextLine();
            Scanner l = new Scanner(line);
            String temp = "";
            while(l.hasNext()) {
                temp += l.next();
                if(l.hasNext()) {
                    temp+=", ";
                }
            }
            String[] line2 = temp.split(", ");
            temp = "";
            for(int i = 0; i < line2.length; i++) {
                if(i % 2 == 0) {
                    temp+=line2[i];
                    if(i == 0) {
                        temp+=", ";
                    }
                }
            }
            memEmails.add(temp);
        }
        emails.close();
        
        Scanner members2 = new Scanner(new File("Comp Names.txt"));
        ArrayList<String> compNames = new ArrayList<>();
        while(members2.hasNextLine()) {
            Scanner membersNew = new Scanner(members2.nextLine());
            String temp = "";
            while(membersNew.hasNext()) {
                temp+=membersNew.next();
                if(membersNew.hasNext()) {
                    temp+=" ";
                }
            }
            
            temp = temp.toLowerCase();
            // for(String str : memNames) {
            //     if(str.equals(temp)) {
            //         System.out.println(temp);
            //     }
            // }
            compNames.add(temp);
            membersNew.close();
        }
        members2.close();
        
        Scanner emails2 = new Scanner(new File("Comp Emails.txt"));
        ArrayList<String> compEmails = new ArrayList<>();
        while(emails2.hasNextLine()) {
            String line = emails2.nextLine();
            Scanner l = new Scanner(line);
            String temp = "";
            while(l.hasNext()) {
                temp += l.next();
                if(l.hasNext()) {
                    temp+=", ";
                }
            }
            String[] line2 = temp.split(", ");
            temp = "";
            for(int i = 0; i < line2.length; i++) {
                if(i % 2 == 0) {
                    temp+=line2[i];
                    if(i == 0) {
                        temp+=", ";
                    }
                }
            }
            compEmails.add(temp);
        }
        emails2.close();
        
        
        PrintWriter pw1 = new PrintWriter("CNot Membership Names.txt");
        PrintWriter pw2 = new PrintWriter("CNot Membership Emails.txt");
        boolean found = false;
        // for(int i = 0; i < memNames.size(); i++) {
        //     String mem = memNames.get(i);
        //     found = false;z
        //     for(String pay : payNames) {
        //         if(mem.equals(pay)) {
        //             found = true;
        //             break;
        //         }
        //     }
        //     if(!found) {
        //         pw1.println(mem);
        //         pw2.println(memEmails.get(i));
        //     }
        // }
        // for(int i = 0; i < payNames.size(); i++) {
        //     String pay = payNames.get(i);
        //     found = false;
        //     for(String mem : memNames) {
        //         if(mem.equals(pay)) {
        //             found = true;
        //             break;
        //         }
        //     }
        //     if(!found) {
        //         pw1.println(pay);
        //         pw2.println(payEmails.get(i));
        //     }
        // }
        
        for(int i = 0; i < compNames.size(); i++) {
            String name = compNames.get(i);
            found = false;
            for(String mem : memNames) {
                if(mem.equals(name)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                pw1.println(name);
                pw2.println(compEmails.get(i));
            }
        }
        
        pw1.close();
        pw2.close();
    }
}
