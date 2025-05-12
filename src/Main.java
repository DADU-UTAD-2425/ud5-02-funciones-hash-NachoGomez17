import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner (System.in);
			boolean sonIguales=false;
			//1 - Obten la instancia con algoritmo MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			System.out.print("Introduzca la password: ");
			byte[] pwdByte = sc.nextLine().getBytes();
			md.update(pwdByte);

			byte[] resumen = md.digest();
			byte[] resumenPwd = null;
			do {
				System.out.print("Repetir password: ");
				pwdByte = sc.nextLine().getBytes();
				md.reset();
				
				md.update(pwdByte);
				
				
				byte[] resumenPwdRepetir = md.digest();
				
				sonIguales = Arrays.equals(resumenPwd,resumenPwdRepetir);
				if (!sonIguales) {
					System.out.println("Password incorrecta");
				}
			} while (!sonIguales);
			System.out.println("Fin del programa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}