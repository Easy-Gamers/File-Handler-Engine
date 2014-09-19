package file.engine;


import java.io.*;

import file.engine.writer.Writer;

//import me.zabuzasword3.engine.Destinyor;
import file.engine.reader.Reader;

public class FileLoader {
	
	// Allows the coder to only do Fileloader.CreateFiles, ReadFiles, WriteFiles in one method
	
	private String homeFolder;
	public static String fileSplit = System.getProperty("file.separator");
	public static String home = System.getProperty("user.home");
	
	//public int Home = 0, Settings = 1, Enemies = 2, Saves = 3, Spells = 4, Npcs = 5, Cities = 6;
	
	public FileLoader(String home) {
		homeFolder = home;
	}
	
	public int getFiles(String location) {
		int i = 0;
		File file = new File(location + "0");
		if(file.exists()) {
			while(file.exists()) {
				i++;
				file = new File(location + i);
			}
		}
		return i;
	}
	
	public void CreateFolders(String location) {
		File file = new File(location);
		if(!file.exists()) {
		file.mkdir();
		}
	}
	
	public void CreateFile(String location, String[][] Stats) {
			File file = new File(location);
			if(!file.exists()) {
				//WriteToFiles(location);
			//} else {
//				boolean settings = false;
//				boolean saves = false;
//				boolean enemies = false;
//				boolean spells = false;
//                boolean dialouges = false;
				
//				if(location.equals(Destinyor.DestinyorSettings)) {
//					location = Destinyor.DestinyorFolder;
//					settings = true;
//				}
//				if(location.equals(Destinyor.DestinyorSaves)) {
//					location = Destinyor.DestinyorFolder;
//					saves = true;
//				}
//				if(location.equals(Destinyor.DestinyorEnemies)) {
//					location = Destinyor.DestinyorFolder;
//					enemies = true;
//				}
//				if(location.equals(Destinyor.DestinyorSpells)) {
//					location = Destinyor.DestinyorFolder;
//					spells = true;
//				}
//                                
//                                if(location.equals(Destinyor.DestinyorWindowNpcs)) {
//                                    location = Destinyor.DestinyorFolder;
//                                    dialouges = true;
//                                }
				File dir = new File(homeFolder);
				dir.mkdirs();
//				if(settings) {
//					location = Destinyor.DestinyorSettings;
//				}
//				if(saves) {
//					location = Destinyor.DestinyorSaves;
//				}
//				if(enemies) {
//					location = Destinyor.DestinyorEnemies;
//				}
//				if(spells) {
//					location = Destinyor.DestinyorSpells;
//				}
//                if(dialouges) {
//                	location = Destinyor.DestinyorWindowNpcs;
//                }
                WriteToFiles(location, Stats);
			}
	}
	
	/**
	 * Used for reading files from one method, saves the programmer the trouble of looking through the Reader.java file for the method
	 * 
	 * @param location Points to the location of the file
	 * @param Stats Tells the reader what to skip when looking through the file for the stats
	 */
	public String[][] ReadFromFiles(String location, String[] Stats) {
		if(Stats != null) {
			return Reader.ReadDefault(location, Stats);
		} else {
			String[][] args = {Reader.ReadUnknown(location)};
			return args;
		}
//		if(no == Settings) {
//			Reader.ReadSettings(location);
//		}
//		
//		if(no == Enemies) {
//			Reader.ReadEnemies(location);
//		}
//		
//		if(no == Saves) {
//			Reader.ReadPlayer(location);
//		}
//		
//		if(no == Spells) {
//			Reader.ReadSpells(location);
//		}
//                
//        if(no == Npcs) {
//        	Reader.ReadNpcs(location);
//        }
	}
	
	public String Read(String location) {
		return Reader.Read(location);
	}
	
	/**
	 * Used for writing files from one method, saves the programmer the trouble of looking through the Writer.java file for the method
	 * 
	 * @param location Points to the location of the file
	 * @param Stats Tells the reader what to skip when looking through the file for the stats
	 */
	public void WriteToFiles(String location, String[][] Stats) {
		Writer.WriteDefault(location, Stats);
//		
//		
//		if(no == Settings) {
//			Writer.writeSettingFile(location);
//		}
//		if(no == Saves) {
//			Writer.writeDefaultSaveFile(location);
//		}
//		
//		if(no == Enemies) {
//			Writer.WriteEnemyFile(location);
//		}
//		
//		if(no == Spells) {
//			Writer.WriteSpellFile(location);
//		}
//                
//        if(no == Npcs) {
//        	 Writer.writeNpcs(location);
//        }
	}
        
//        public static String readCutscenes(String location) {
//            return Reader.ReadCutscenes(location);
//        }
//        
//        public static String readDialouges(String location) {
//            return Reader.ReadDialouge(location);
//        }
//	
//	public static boolean Override() {
//		return Reader.Override;
//	}
//	
//	public static boolean Debug() {
//		return Reader.Debug;
//	}
//
//	public static List<String> EKeys() {
//		return Reader.keys();
//	}
//	
//	public static List<String> SpellKeys() {
//		return Reader.spellKeys();
//	}
//        
//        public static List<String> PKeys() {
//            return Reader.PlayerKeys();
//        }
    }