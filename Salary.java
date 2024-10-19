import java.util.*;
class Salary
{
public static void main(String[]args)
{
Scanner scanner = new Scanner(System.in);
System.out.print("Enter basic Salary: ");
double basicSalary = scanner.nextDouble();
double da = 0.7 * basicSalary;
double hr = 0.3 * basicSalary;
double cca = 0.4 * basicSalary;
double pt = 0.1 * basicSalary;
double grossSalary = basicSalary + da + hr + cca;
double netSalary = grossSalary - pt;

System.out.println("\nSalary Details :");
System.out.println("Basic Salary : rs" + basicSalary);
System.out.println("Dearness Allowance(DA) : rs" + da);
System.out.println("House Rent(HR) : rs" + hr);
System.out.println("City Compensatory Allowance(CCA) : rs" + cca);
System.out.println("Gross Salary : rs" + grossSalary);
System.out.println("Professional Tax(PT) : rs" + pt);
System.out.println("Net Salary : rs" + netSalary);

scanner.close();
}
}