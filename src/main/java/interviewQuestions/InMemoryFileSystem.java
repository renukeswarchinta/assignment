package interviewQuestions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InMemoryFileSystem {

	public static void main(String[] args) {
		FileSystem fileSystem = new FileSystem(Constants.ROOT_DIR);
		fileSystem.changeDirectory("C:\\Renu");
		System.out.println(fileSystem.presentWorkingDirectory());
		fileSystem.changeDirectory("EMDM");
		System.out.println(fileSystem.presentWorkingDirectory());
		List<String> listOfFiles = fileSystem.listOfFiless("C:\\Renu");
		fileSystem.makeDirectory("NewFolder");
		 
	}
	public static void printJob(String s) {
		System.out.println(s);
		}
}

class FileSystem {

	private String rootDirectory;
	private Stack<String> folderStack;
	boolean isfile = false;
	 
	FileModel root;
	FileSystem(String rootDirectory) {
		this.rootDirectory = rootDirectory;
		this.folderStack = new Stack<String>();

	}

	public String changeDirectory(String folderName) {
		if (!folderStack.isEmpty()) {
			String path = folderStack.peek();
			folderName = formPathStructure(path, folderName);
		}
		if (isDirectory(folderName)) {
			return folderStack.push(folderName);
		} else {
			return Constants.NOTADIR;
		}
	}

	public List < String > listOfFiless(String path) {
        FileModel fileModel = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                fileModel = fileModel.listOfFiles.get(d[i]);
            }
            if (fileModel.isfile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> res_files = new ArrayList<>(fileModel.listOfFiles.keySet());
        Collections.sort(res_files);
        return res_files;
    }

    public void makeDirectory(String path) {
        FileModel fileModel = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!fileModel.listOfFiles.containsKey(d[i]))
                fileModel.listOfFiles.put(d[i], new FileModel());
            fileModel = fileModel.listOfFiles.get(d[i]);
        }
    }

    


	private String formPathStructure(String path, String folderName) {
		StringBuilder s = new StringBuilder();
		return s.append(path).append("\\").append(folderName).toString();
	}

	public String presentWorkingDirectory() {
		return folderStack.toString();
	}

	private boolean isDirectory(String folderName) {
		File file = new File(folderName);
		return file.isDirectory();
	}

}

interface Constants {
	String ROOT_DIR = "C:\\";
	String NOTADIR = "NOT A DIRECTORY";
}

class FileModel {
    boolean isfile = false;
    HashMap<String,FileModel> listOfFiles = new HashMap<>();
	public boolean isIsfile() {
		return isfile;
	}
	public void setIsfile(boolean isfile) {
		this.isfile = isfile;
	}
	public HashMap<String, FileModel> getListOfFiles() {
		return listOfFiles;
	}
	public void setListOfFiles(HashMap<String, FileModel> listOfFiles) {
		this.listOfFiles = listOfFiles;
	}
    

}