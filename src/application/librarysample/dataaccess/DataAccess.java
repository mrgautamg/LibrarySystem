package application.librarysample.dataaccess;

import application.librarysample.business.LibraryMember;

public interface DataAccess {
	public void saveLibraryMember(String memberId, LibraryMember member);

	public LibraryMember readLibraryMember(String memberId);
	
	
}
