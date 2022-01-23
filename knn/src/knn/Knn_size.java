
package knn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Marwa Belmir
 */
public class Knn_size {

static double [][]data={
/* d1 */ { 158, 58 },
/* d2 */ { 158, 59 },
/* d3 */ { 158, 63 },
/* d4 */ { 160, 59 },
/* d5 */ { 160, 60 },
/* d6 */ { 163, 60 },
/* d7 */ { 163, 61 },
/* d8 */ { 160, 64 },
/* d9 */ { 163, 64 },
/*d10 */ { 165, 61 },
/*d11 */ { 165, 62 },
/*d12 */ { 165, 65 },
/*d13 */ { 168, 62 },
/*d14 */ { 168, 63 },
/*d15 */ { 168, 66 },
/*d16 */ { 170, 63 },
/*d17 */ { 170, 64 },

};

private static String FindMajorityClass(String[]table_trie)
{
Set<String> h= new HashSet<String>(Arrays.asList(table_trie));
//convert the hashet to  array
String[] values = h.toArray(new String[0]);
//count for unique strings
int[] counts = new int[values.length];

for (int i=0; i< values.length; i++){
    for (int j=0; j< table_trie.length; j++){
        if(table_trie[j].equals(values[i])){
            counts[i]++;
        }
        } }

for(int i=0; i <values.length; i++)
    System.out.println(values[i]);

for(int i=0; i<counts.length; i++)
  System.out.println(counts[i]);

int max = counts[0];
for( int i =1; i< counts.length; i++){
if(counts[i] > max){
    max= counts[i];
}
}

System.out.println("max de occurences : "+max);

int f =0;
for(int i=0; i< counts.length; i++){
    if(counts[i] == max){
f++;
}
}

int index = -1 ;
if( f == 1){
    for ( int i=0 ;i< counts.length;i++ ){
        if(counts[i]== max ){
            index= i;
            break;
        }}
    System.out.println("one majority classe , index is :" +index);
    return values[index];
}else {
    int[] ix= new int[f];
//array of indices
System.out.println("multiple majority classes : " +f+" classes");
int ixi=0;
for (int counter =0; counter < counts.length; counter++){
    if(counts[counter] == max){
        ix[ixi] = counter;
        ixi++;
    }
}

for (int counter =0; counter < ix.length; counter++)
{
    System.out.println("class index : "+ix[counter]);
    
    Random generator = new Random();
//get random nombre 0<= 
int rIndex = generator.nextInt(ix.length);
System.out.println("random index: "+rIndex);
int nIndex= ix[rIndex];
//return unique value
return values[nIndex];
}
}
    return null;

}

static class Size{
   double[] sizeAttributes;
   String sizeName;
   public Size(double[] sizeAttributes , String sizeName){
     this.sizeName=sizeName;
     this.sizeAttributes=sizeAttributes;
   }
}
 static class Result {
 double distance;
 String sizeName;
 public Result(double distance, String sizeName){
 this.sizeName=sizeName;
 this.distance=distance;
 }
 }
 
 // comparator class used to compare results via distances
 static class DistanceComparator implements Comparator <Result>{
 @Override
 public int compare(Result a, Result b){
 return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
 }
 }

 //main
public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
 int k ;
  do{
     System.out.println(" number of neighbors , k :");
 k =sc.nextInt();// nombre of neighbours
 }while  (k>17);
          
  //data about unkown size
  double[] test= new double[2];
System.out.println(" Height :");
test[0] =sc.nextDouble();
System.out.println(" Weight :");
test[1] =sc.nextDouble();   
  
 List<Size> sizeList = new ArrayList<Size>();
List<Result> resultList = new ArrayList<Result>();

        //add size data to cityList
sizeList.add(new Size(data[0], " Size M "));       //1
sizeList.add(new Size(data[1], " Size M "));        //2
sizeList.add(new Size(data[2], " Size M "));    //3
sizeList.add(new Size(data[3], " Size M "));       //4
sizeList.add(new Size(data[4], " Size M "));    //5
sizeList.add(new Size(data[5], " Size M "));       //6
sizeList.add(new Size(data[6], " Size M "));        //7
sizeList.add(new Size(data[7], " Size L "));    //8
sizeList.add(new Size(data[8], " Size L "));       //9
sizeList.add(new Size(data[9], " Size L "));    //10
sizeList.add(new Size(data[10], " Size L "));       //11
sizeList.add(new Size(data[11], " Size L "));        //12
sizeList.add(new Size(data[12], " Size L "));    //13
sizeList.add(new Size(data[13], " Size L "));       //14
sizeList.add(new Size(data[14], " Size L "));    //15
sizeList.add(new Size(data[15], " Size L "));       //16
sizeList.add(new Size(data[16], " Size L "));        //17



//find distances
for (Size size : sizeList){
  double dist =0.0;
  
     for (int j=0; j<size.sizeAttributes.length;j++){
         dist+= Math.pow(size.sizeAttributes[j] - test[j], 2);}
    
  double distance = Math.sqrt(dist);
 
  resultList.add(new Result(distance,size.sizeName));
}

Collections.sort(resultList, new DistanceComparator());
String[] TabTrie = new String[k];
for(int i=0; i < k; i++){
 System.out.println("class :"+resultList.get(i).sizeName+"   distance["+i+"] : " + resultList.get(i).distance);
    TabTrie[i] = resultList.get(i).sizeName;
}
String MajorityClass = FindMajorityClass(TabTrie);
System.out.println("class of new size : "+MajorityClass);
}

}








 
 
    


