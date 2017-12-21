import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class hello {
    public static void main(String args[] ) throws Exception
    { /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner input = new Scanner(System.in);
        int index = 0;
        while(input.hasNextLine())
        {   index ++;
            String newLine = input.nextLine();

            if (index==1) {
                createStartAndEndDate(newLine);
            }
            else if(index==2){
                //Skipping second line
                continue;
            }
            else if(index>=3) {
                Request request = createRequest(newLine);
                if (isValidRequest(request)==1)
                { requestList.add(request); }
            }
        }

        //Processing: sorting and then merging the records
        sortRequestList();
        mergeRequestList();

        for(OutputEntity outputEntity : outputEntities)
        {
            System.out.println(outputEntity.outputToString());
        }
    }

    private static Request createRequest(String str) {
        String[] splitStr = str.split(", *");
        //Parse the date
        Date date = createDate(splitStr[0].trim());
        //Parse the remaining of the input
        String str1=splitStr[1].trim();
        String str2=splitStr[2].trim();

        Engagement engagement = new Engagement(str1, Integer.parseInt(str2));
        Request request = new Request(date, engagement);
        return request;
    }


    private static Date createDate(String str) {
        Date date = null;
        String[] splitStr = str.split("-");
        //if date is yyyy-mm-dd
        if (splitStr.length == 3) {
            date = new Date(Integer.parseInt(splitStr[0].trim()), Integer.parseInt(splitStr[1].trim()), Integer.parseInt(splitStr[2].trim()));
        }
        //if date is yyyy-mm
        else if (splitStr.length == 2) {
            date = new Date(Integer.parseInt(splitStr[0].trim()), Integer.parseInt(splitStr[1].trim()));
        }

        return date;
    }

    private static void createStartAndEndDate(String str) {
        String[] splited = str.split(", *");
        if(splited.length==2){
            startDate = createDate(splited[0].trim());
            endDate = createDate(splited[1].trim());
        }
    }


    private static void sortRequestList() {
        RequestComp requestComp = new RequestComp();
        Collections.sort(requestList, requestComp);
    }

    private static void mergeRequestList() {
        //if only one entry no need to process.
        if (requestList.size() <= 1) { return; }

        OutputEntity last = new OutputEntity(requestList.get(0));

        for(int i = 1; i < requestList.size(); i ++) {
            Request cur = requestList.get(i);
            if (last.getDate().isSameMonth(cur.getDate())==1) {
                last.addEngagement(cur.getEngagement());
            }
            else if(last.getDate().isSameMonth(cur.getDate())==0)
            {
                outputEntities.add(last);
                last = new OutputEntity(cur);
            }
        }
        outputEntities.add(last);
    }

    private static int isValidRequest(Request request) {
        Date date = request.getDate();
        return (date.compareDate(startDate) <= 0 && date.compareDate(endDate) > 0)==true?1:0;
    }

    //Declaration of static variable to be used in Solution
    public static Date startDate;
    public static Date endDate;
    public static List<OutputEntity> outputEntities = new ArrayList<OutputEntity>();
    public static List<Request> requestList = new ArrayList<Request> ();


}

//Engagement Class defination
class Engagement {

    private String type;
    private int count;
    public Engagement(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }
    public int getCount() {
        return count;
    }

}

//Date class defination
class Date {
    private int year;
    private int month;
    private int day;

    //Constructor for 2 input
    public Date(int year, int month) {
        this.year = year;
        this.month = month;
        this.day = 1;
    }
    //Constructor for 3 input
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int isSameMonth(Date another) {
        int res;
        if(this.year == another.getYear() && this.month == another.getMonth())
            res=1;
        else res = 0;
        return res;
    }

    public String dateToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append('-');
        if (this.month >= 10) {

            sb.append(this.month);
        } else if (this.month < 10){
            sb.append('0');
            sb.append(this.month);
        }
        String res = sb.toString();
        return res;
    }

    public int compareDate(Date given) {

        if (this.year == given.getYear()) {
            if (this.month > given.getMonth()) {
                return -1;
            }
            else if (this.month == given.getMonth()) {

                if (this.day == given.getDay()) {
                    return 0;
                }
                else if (this.day > given.getDay()) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                return 1;
            }
        }else if (this.year > given.getYear()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

//Req Comparison class Defination
class RequestComp implements Comparator {
    public int compare(Object obj1, Object obj2) {
        if (obj1 == null) { return 1; }
        if (obj2 == null) { return -1; }
        Request r1 = (Request)obj1;
        Request r2 = (Request)obj2;
        return r1.getDate().compareDate(r2.getDate());
    }
}

//Reques class Defination
class Request {
    public Request(Date date, Engagement engagements) {
        this.date = date;
        this.engagement = engagements;
    }
    private Date date;
    private Engagement engagement;

    public Date getDate() { return date; }
    public Engagement getEngagement() { return engagement; }

}

//Final output Entity class
class OutputEntity {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private Date date;


    public Date getDate() { return date; }
    public Map<String, Integer> getMap() { return map; }

    public void addEngagement(Engagement engagement) {
        String type = engagement.getType();
        int count = engagement.getCount();
        if (map.containsKey(type)) {
            map.replace(type, (Integer)map.get(type) + count);
        } else {
            map.put(type, count);
        }
    }
    public OutputEntity(Request request) {
        this.date = request.getDate();
        map = new TreeMap<String, Integer>();
        map.put(request.getEngagement().getType(), request.getEngagement().getCount());
    }

    public String outputToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.date.dateToString());
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(", ");
            sb.append(entry.getKey());
            sb.append(", ");
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
