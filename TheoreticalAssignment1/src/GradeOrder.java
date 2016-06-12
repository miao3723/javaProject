import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileInputStream; 
import java.io.FileWriter;
import java.io.IOException; 
import java.io.InputStream; 
import java.util.ArrayList; 
import java.util.List; 

 
import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook;  
import jxl.read.biff.BiffException;

/**  
* 读取excel公共方法
* 
* 
*/  

public class GradeOrder {
	 
	

	
/** 
* @param excelFile 
读取文件对象
* @param rowNum 
从第几行开始读，如果有一行表头则从第二行开始读
* @return 
* @throws BiffException
* @throws IOException 
*/ 

	

public static List<String[]> readExcel(File excelFile,int rowNum) 

throws BiffException, 
IOException { 
// 创建一个list 用来存储读取的内容
List<String[]> list = new ArrayList<String[]>(); 
Workbook rwb = null; 
Cell cell = null; 
// 创建输入流
InputStream stream = new FileInputStream(excelFile); 

// 获取Excel文件对象
rwb = Workbook.getWorkbook(stream); 

// 获取文件的指定工作表默认的第一个
Sheet sheet = rwb.getSheet(0); 
double credit1=0;
double grade1=0;
double allGrade=0;
double allCredit=0;
double point=0;
double allPoint=0;

// 行数(表头的目录不需要，从1开始) 
for (int i = rowNum-1; i < sheet.getRows(); i++) {  

	 
// 创建一个数组用来存储每一列的值

String[] str = new String[sheet.getColumns()]; 

 // 列数
for (int j = 0; j < sheet.getColumns(); j++) { 

 // 获取第i行，第j列的值
	
cell = sheet.getCell(j, i); 
if(i>0&&j==3){
    String credit=sheet.getCell(j,i).getContents().trim().replace("'", "''");
    credit1=Double.valueOf(credit).doubleValue();
}
if(i>0&&j==9)
{   String grade=sheet.getCell(j,i).getContents().trim().replace("'", "''");
    grade1=Double.valueOf(grade).doubleValue();
    
    if(90<=grade1&&grade1<=100) point=4.0;
    else if(85<=grade1&&grade1<=89) point=3.7;
    else if(82<=grade1&&grade1<=84) point=3.3;
    else if(78<=grade1&&grade1<=81) point=3.0;
    else if(75<=grade1&&grade1<=77) point=2.7;
    else if(72<=grade1&&grade1<=74) point=2.3;
    else if(68<=grade1&&grade1<=71) point=2.0;
    else if(64<=grade1&&grade1<=67) point=1.5;
    else if(60<=grade1&&grade1<=63) point=1.0;
    else if(grade1<=60) point=0;
	}

str[j] = cell.getContents(); 

} 
allGrade=allGrade+credit1*grade1;
allCredit=allCredit+credit1;
allPoint=allPoint+point*credit1;
// 把刚获取的列存入list 

list.add(str); 

} 
double weightingGrade=allGrade/allCredit;
double averagePoint=allPoint/allCredit;

// 返回值集合
File f = new File("orderGrade.txt");
BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
output.write("加权平均分："+weightingGrade);
output.write("\r\n");
output.write("GPA："+averagePoint);
output.write("\r\n");

System.out.println("加权平均分："+weightingGrade);

System.out.println("GPA："+averagePoint);
output.close();
return list;


} 

public static void main(String[] args) { 

String excelFileName = "grade.xls"; 

try { 
List<String[]> list = readExcel(new File(excelFileName),1);
//按大小顺序找到下标
int[] number=new int[list.size()];
double[] data=new double[list.size()];

for(int k=0;k<list.size();k++){
double grade3=0;	
for (int i = 1; i < list.size(); i++) { 
String[] str = (String[])list.get(i); 

for (int j = 0; j < str.length; j++) {
	if(j==9){
	if(grade3<Double.valueOf(str[j]).doubleValue()&&k==0)
		{
		grade3=Double.valueOf(str[j]).doubleValue();
		number [k]=i;
		data[k]=grade3;
		
		}
	else if(grade3<Double.valueOf(str[j]).doubleValue()&&k!=0&&Double.valueOf(str[j]).doubleValue()<data[k-1]||(grade3<Double.valueOf(str[j]).doubleValue()&&k!=0&&Double.valueOf(str[j]).doubleValue()==data[k-1]&&i>number[k-1])){
	grade3=Double.valueOf(str[j]).doubleValue();
	number [k]=i;
	data[k]=grade3;
	}

} 
}
} 
}
//输出到文件
File f = new File("orderGrade.txt");
BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
for(int a=0;a<list.size()-1;a++){
	int i=number[a];
	String[] str = (String[])list.get(i); 
	
	for (int j = 0; j < str.length; j++) {
		output.write(str[j]);
		output.write("\t");
	    output.flush();
        System.out.println(str[j]); }
	    output.write("\r\n");
}
        output.close();

}catch (BiffException e) { 
e.printStackTrace(); 
} catch (IOException e) { 
e.printStackTrace(); 
} 
} 
//以上list中值为所读取之后存储的集合。
}
 



