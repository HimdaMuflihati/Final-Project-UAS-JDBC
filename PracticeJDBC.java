package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PracticeJDBC { 
	public static void daftarbuku() {
		
		String username = "Himda_Muflihati";
		String password = "H1051201065";
		String dbUrl = "jdbc:mysql://localhost:3306/perpustakaan";
		String query = "select * from buku";
		
		try (
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		){
			while(rs.next()) {
				System.out.println(rs.getString("Kode_Buku")+"\t"+ rs.getString( "Judul_Buku")+"\t"+ rs.getString("Penulis")+"\t"+ rs.getString("Penerbit")+"\t"+ rs.getString( "Jumlah_Buku"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}public static void tambahbuku() { 
		Scanner scan = new Scanner (System.in);
		List<String> coll = new ArrayList<>(); 
		
				
		String username = "Himda_Muflihati";
		String password = "H1051201065";
		String dbUrl = "jdbc:mysql://localhost:3306/perpustakaan";
		String query = "Update buku SET ";
		
		System.out.print("Masukkan Kode Buku Yang Akan Diubah : ");
		String Kode= scan.nextLine();
		coll.add(Kode);
		System.out.print("Masukkan Jumlah Buku Yang Akan Diubah : ");
		String jumlah=scan.nextLine();
		coll.add(jumlah);
		System.out.println("Data Baru Buku Perpustakaan "+coll);
		
		try (
				Connection conn = DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement Ps = conn.prepareStatement ( query + "Jumlah_Buku = " + jumlah+ " where Kode_Buku = '" + Kode +"'");
				
			){
				Ps.execute() ;
				
				System.out.println("DATA BERHASIL DIUBAH") ;
	
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
	}
		public static void main (String[] args) {
			System.out.println("SELAMAT DATANG DI APLIKASI PERPUSTAKAAN");
			while(true) {
				
			System.out.println("\nDAFTAR BUKU");
			daftarbuku();
			
			
			System.out.println("Update Jumlah Buku Perpustakaan");
			tambahbuku();
		}		
		
	}
}

