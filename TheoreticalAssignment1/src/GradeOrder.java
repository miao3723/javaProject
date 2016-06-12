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
* ��ȡexcel��������
* 
* 
*/  

public class GradeOrder {
	 
	

	
/** 
* @param excelFile 
��ȡ�ļ�����
* @param rowNum 
�ӵڼ��п�ʼ���������һ�б�ͷ��ӵڶ��п�ʼ��
* @return 
* @throws BiffException
* @throws IOException 
*/ 

	

public static List<String[]> readExcel(File excelFile,int rowNum) 

throws BiffException, 
IOException { 
// ����һ��list �����洢��ȡ������
List<String[]> list = new ArrayList<String[]>(); 
Workbook rwb = null; 
Cell cell = null; 
// ����������
InputStream stream = new FileInputStream(excelFile); 

// ��ȡExcel�ļ�����
rwb = Workbook.getWorkbook(stream); 

// ��ȡ�ļ���ָ��������Ĭ�ϵĵ�һ��
Sheet sheet = rwb.getSheet(0); 
double credit1=0;
double grade1=0;
double allGrade=0;
double allCredit=0;
double point=0;
double allPoint=0;

// ����(��ͷ��Ŀ¼����Ҫ����1��ʼ) 
for (int i = rowNum-1; i < sheet.getRows(); i++) {  

	 
// ����һ�����������洢ÿһ�е�ֵ

String[] str = new String[sheet.getColumns()]; 

 // ����
for (int j = 0; j < sheet.getColumns(); j++) { 

 // ��ȡ��i�У���j�е�ֵ
	
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
// �Ѹջ�ȡ���д���list 

list.add(str); 

} 
double weightingGrade=allGrade/allCredit;
double averagePoint=allPoint/allCredit;

// ����ֵ����
File f = new File("orderGrade.txt");
BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
output.write("��Ȩƽ���֣�"+weightingGrade);
output.write("\r\n");
output.write("GPA��"+averagePoint);
output.write("\r\n");

System.out.println("��Ȩƽ���֣�"+weightingGrade);

System.out.println("GPA��"+averagePoint);
output.close();
return list;


} 

public static void main(String[] args) { 

String excelFileName = "grade.xls"; 

try { 
List<String[]> list = readExcel(new File(excelFileName),1);
//����С˳���ҵ��±�
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
//������ļ�
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
//����list��ֵΪ����ȡ֮��洢�ļ��ϡ�
}
 



