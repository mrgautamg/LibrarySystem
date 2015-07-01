package application.librarysample.dataaccess;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.librarysample.business.LibraryMember;

public class DataAccessFacade implements DataAccess {

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\application\\librarysample\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	private HashMap<String, LibraryMember> memberMap = new HashMap<String, LibraryMember>();

	public void saveLibraryMember(String memberId, LibraryMember member) {
		try {
			// memberMap=new HashMap<String, LibraryMember>();
			HashMap<String, LibraryMember> mems = readMemberData();
			mems.put(memberId, member);
			memberMap.put(memberId, member);
			saveToData(StorageType.MEMBER, memberMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLibraryMember(String memberId, LibraryMember member) {
		try {
			// memberMap=new HashMap<String, LibraryMember>();
			HashMap<String, LibraryMember> mems = readMemberData();
			mems.remove(memberId);
			mems.put(memberId, member);
			memberMap.put(memberId, member);
			saveToData(StorageType.MEMBER, memberMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LibraryMember searchLibraryMember(String memberId) {
		try {
			HashMap<String, LibraryMember> mems = readMemberData();
			if (mems.containsKey(memberId)) {
				return mems.get(memberId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteLibrayMember(String memberId) {
		try {
			HashMap<String, LibraryMember> mems = readMemberData();
			mems.remove(memberId);
			saveToData(StorageType.MEMBER, memberMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberData() {
		memberMap = (HashMap<String, LibraryMember>) lookupData(StorageType.MEMBER);
		return memberMap;
	}

	public static Object lookupData(StorageType type) {
		ObjectInputStream in = null;
		Object lookUp = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			lookUp = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return lookUp;
	}

	// public LibraryMember readLibraryMember(String memberId) {
	// ObjectInputStream in = null;
	// LibraryMember member = null;
	//
	// try {
	// File fileList = new File(OUTPUT_DIR);
	// for (File files : fileList.listFiles()) {
	// Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
	// memberId);
	// in = new ObjectInputStream(Files.newInputStream(path));
	// member = (LibraryMember) in.readObject();
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (in != null) {
	// try {
	// in.close();
	// } catch (Exception e) {
	// }
	// }
	// }
	// return member;
	// }

	public void saveToData(StorageType type, Object obj) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	// public List<LibraryMember> readAllLibraryMember() {
	// ObjectInputStream in = null;
	// List<LibraryMember> member = new ArrayList<LibraryMember>();
	//
	// try {
	// File fileList = new File(OUTPUT_DIR);
	// for (File files : fileList.listFiles()) {
	// if (files.isFile()) {
	// Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
	// files.getName());
	// in = new ObjectInputStream(Files.newInputStream(path));
	// member.add((LibraryMember) in.readObject());
	// }
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (in != null) {
	// try {
	// in.close();
	// } catch (Exception e) {
	// }
	// }
	// }
	// return member;
	// }

}
