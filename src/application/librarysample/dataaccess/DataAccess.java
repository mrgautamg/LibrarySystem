package application.librarysample.dataaccess;

import java.util.HashMap;
import java.util.List;

import application.librarysample.business.LibraryMember;
import application.librarysample.business.Person;

public interface DataAccess {
	public void saveLibraryMember(String memberId, LibraryMember member);
	
	public  HashMap<String, LibraryMember> readMemberData();
	
	public void deleteLibrayMember(String memberId);
	public LibraryMember searchLibraryMember(String memberId);
//	public LibraryMember readLibraryMember(String memberId);
//	
//	public List<LibraryMember> readAllLibraryMember();
	
	public void updateLibraryMember(String memberId, LibraryMember member);
	
}
