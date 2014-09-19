package file.engine.reader;

//import me.zabuzasword3.engine.DebugWriter;
//import me.zabuzasword3.engine.Destinyor;
//import me.zabuzasword3.engine.entities.Boss;
//import me.zabuzasword3.engine.entities.Enemy;
//import me.zabuzasword3.engine.entities.NPC;
//import me.zabuzasword3.engine.graphics.Resolution;
//import me.zabuzasword3.engine.magic.Element;
//import me.zabuzasword3.engine.player.Player;
//import me.zabuzasword3.engine.magic.Spells;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;

//import file.engine.Errors;
//import me.zabuzasword3.engine.messages.Errors;

public class Reader {
	
	//private static BufferedReader br;
	
//    public static List<String> KEYS = new ArrayList<>();
//    public static List<String> SPELLKEYS = new ArrayList<>();
//    public static List<String> NPCKEYS = new ArrayList<>();
//    public static List<String> PlayerKeys = new ArrayList<>();
//    public static int k = 0;
//    public static boolean Override = false;
//    public static boolean Debug = false;
	
	public static String Read(String location) {
		BufferedReader br;
		String stuff = "";
		String nullchecker = "";
		
		try {
			br = new BufferedReader(new FileReader(new File(location)));
			
			while(nullchecker != null) {
				nullchecker = br.readLine();
				if(nullchecker != null) {
					stuff += nullchecker;
				}
			}
			
			br.close();
		} catch(IOException e) {
            e.printStackTrace();
		}
		return stuff;
	}
	
	
	public static String[] ReadUnknown(String location) {
		BufferedReader br;
		BufferedReader brTemp;
    	String[] Holder;
    	//Map<String, Object> enemy = new HashMap<>();
       // String[] Stats = {
        //    "First Name = ", "Last Name = ", "Gender = ", "Age = ", "Dead = ", "Fertile = ", "Spouses = ", "Lovers = ", "Parents = ", "Children = ", "Leadership = ", "War = ", "Intelligence = ", "Politics = ", "Charisma = ", "Ruler = ", "Icon = "
       // };
       // int gender;
        int lines = 0;
        
        //String[] StatHolder;// = new String[];
        
        String checker = "";
        try {
            br = new BufferedReader(new FileReader(new File(location)));
            brTemp = new BufferedReader(new FileReader(new File(location)));
            
            while(brTemp.readLine() != null) {
            	lines++;
            }
            
            //StatHolder = new String[lines];
            brTemp.close();
            Holder = new String[lines];
            
            checker = br.readLine();
            while(checker != null) {
            	for(int i = 0; i < lines; i++) {
            		checker = br.readLine();
                
            		if(checker != null || checker != "" || !checker.contains("#")) {
            			Holder[i] = checker;
            			System.out.println("Reading: " + Holder[i]);
            		}
            	}
            }
            br.close();
            return Holder;
         } catch (IOException e) {
                e.printStackTrace();
         }
		return null;
	}
	
    public static String[][] ReadDefault(String location, String[] Stats) {
    	BufferedReader br;
    	BufferedReader brTemp;
    	String[][] Holder;
    	//Map<String, Object> enemy = new HashMap<>();
       // String[] Stats = {
        //    "First Name = ", "Last Name = ", "Gender = ", "Age = ", "Dead = ", "Fertile = ", "Spouses = ", "Lovers = ", "Parents = ", "Children = ", "Leadership = ", "War = ", "Intelligence = ", "Politics = ", "Charisma = ", "Ruler = ", "Icon = "
       // };
       // int gender;
        int lines = 0;
        
        String[] StatHolder = new String[Stats.length];
        
        String checker = "";
        try {
            br = new BufferedReader(new FileReader(new File(location)));
            brTemp = new BufferedReader(new FileReader(new File(location)));
            
            while(brTemp.readLine() != null) {
            	lines++;
            }
            brTemp.close();
            Holder = new String[lines / Stats.length][Stats.length];
            
            checker = br.readLine();
            while(checker != null) {
            	for(int i = 0; i < Stats.length; i++) {
            		br.skip(Stats[i].length());
            		checker = br.readLine();
                
            		if(checker != null || checker != "" || !checker.contains("#")) {
            			StatHolder[i] = checker;
            			System.out.println("Reading: " + Stats[i] + StatHolder[i]);
            		}
            		Holder[i] = StatHolder;
            	}
                    
            }
            
            br.close();
            return Holder;
         } catch (IOException e) {
                e.printStackTrace();
         }
        return null;
    }
    
    
//	public static void ReadEnemies(String location) {
//		BufferedReader br;
//		String[] Stats = {
//			"Name = ","Frame = ", "Gender = ", "Level = ", "Experience = ", "Health = ", "Strength = ", "Skill = ", "Speed = ", "Luck = ", "Defense = ", "Gold = ", "Resistance = ", "Spells = ", "X&Y = "
//		};
//		
//		try{
//			br = new BufferedReader(new FileReader(new File(location)));
//			br.readLine();
//                        
//            int LVL;
//            int Exp;
//            int Gold;
//            int HP;
//            int Str;
//            int Skl;
//            int Spd;
//            int Luk;
//            int Def;
//                          
//            String Name;
//            String Frame;
//            String Resistances;
//            Element Resistance = null;
//            Spells[] spells;
//            String[] spiltSpells;
//            String getSpells;
//            String Gender;
//            String[] pos;
//            String endEnemy = br.readLine();
//            
//            while(endEnemy != null) {
//            	br.skip(Stats[0].length());
//    	        Name = br.readLine();
//                KEYS.add(Name);
//                br.skip(Stats[1].length());
//                Frame = br.readLine();
//                br.skip(Stats[2].length());
//				Gender = br.readLine();
//				br.skip(Stats[3].length());
//				LVL = Integer.parseInt(br.readLine());
//				br.skip(Stats[4].length());
//				Exp = Integer.parseInt(br.readLine());
//				br.skip(Stats[5].length());
//				HP = Integer.parseInt(br.readLine());
//				br.skip(Stats[6].length());
//				Str = Integer.parseInt(br.readLine());
//				br.skip(Stats[7].length());
//				Skl = Integer.parseInt(br.readLine());
//				br.skip(Stats[8].length());
//				Spd = Integer.parseInt(br.readLine());
//				br.skip(Stats[9].length());
//				Luk = Integer.parseInt(br.readLine());
//				br.skip(Stats[10].length());
//	            Def = Integer.parseInt(br.readLine());
//				br.skip(Stats[11].length());
//				Gold = Integer.parseInt(br.readLine());
//				br.skip(Stats[12].length());
//				Resistances = br.readLine();
//				br.skip(Stats[13].length());
//				getSpells =  br.readLine().trim();
//				br.skip(Stats[14].length());
//				pos = br.readLine().split(",");
//                endEnemy = br.readLine();
//                for(int i = 0; i < Element.getElements().length; i++) {
//                    if(Resistances.equals(Element.getElement(i).getElement())) {
//                        Resistance = Element.getElement(i);
//                        break;
//                    }
//                }
//                
//                spiltSpells = getSpells.split(",");
//                spells = new Spells[spiltSpells.length];
//                for(int s = 0; s < spiltSpells.length; s++) {
//                    if(!spiltSpells[s].contains("null"))
//                        spells[s] = Spells.get(spiltSpells[s]);
//                    else
//                        spells = null;
//                }
//                
//                    System.out.println("Reader.ReadEnemies: " + Name);
//	            
//                Enemy.enemies.put(Name, new Enemy(Name, Frame, Gender, LVL, Exp, HP, Str, Skl, Spd, Luk, Def, Gold, Resistance, spells, Integer.parseInt(pos[0].trim()), Integer.parseInt(pos[1].trim())));
//                DebugWriter.println("Menu: Adding: " + Name);
//            }
//			
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public static void ReadNpcs(String location) {
//            BufferedReader br;
//		String[] Stats = {
//				"Name = ","Frames = ", "X = ", "Y = ", "Dialouge Location = "
//			};
//			
//			try {
//				br = new BufferedReader(new FileReader(new File(location)));
//				br.readLine();
//	                  
//				int x;
//				int y;
//				
//	            String Name;
//	            String Frame;
//	            String dialouge;
//	            String endNpc = br.readLine();
//	            
//	            while(endNpc != null) {
//                    br.skip(Stats[0].length());
//	    	        Name = br.readLine();
//	                NPCKEYS.add(Name);
//	                br.skip(Stats[1].length());
//	                Frame = br.readLine().trim();
//	                br.skip(Stats[2].length());
//	                x = Integer.parseInt(br.readLine().trim());
//	                br.skip(Stats[3].length());
//	                y = Integer.parseInt(br.readLine().trim());
//	                br.skip(Stats[4].length());
//	                dialouge = br.readLine();
//                    
//	                if(dialouge.contains(".txt")) {
//	                
//	                if(Destinyor.home.contains("\\"))
//	                dialouge = ReadDialouge(Destinyor.DestinyorFolder + "\\Dialouges\\" + dialouge);
//	                else dialouge = ReadDialouge(Destinyor.DestinyorFolder + "//Dialouges//" + dialouge);
//	                }
//	                
//	                endNpc = br.readLine();
//	                
//	                NPC.npcs.put(Name, new NPC(Name, Frame, x, y, dialouge, true));
//	                
//	                
//	                //endEnemy = br.readLine();
//	                
//	                System.out.println("Reader.ReadNpcs: " + Name);
//	            }
//				
//				br.close();
//			} catch (IOException e) {
//                            e.printStackTrace();
//			}
//	}
//        
//        public static String ReadCutscenes(String location) {
//            BufferedReader br;
//            BufferedReader reader;
//            
//            String text = "";
//            String[] temptext;
//            String nullchecker;
//            int lines = 0;
//            int i = 0;
//            
//            try {
//                br = new BufferedReader(new FileReader(new File(location)));
//                reader = new BufferedReader(new FileReader(new File(location)));
//                //nullchecker = br.readLine();
//                while(reader.readLine() != null) {
//                    lines++;
//                }
//                reader.close();
//                temptext = new String[lines];
//                
//                while(i != lines) {
//                    nullchecker = br.readLine();
//                    //System.out.println(nullchecker);
//                    if(nullchecker != null) {
//                    temptext[i] = nullchecker;
//                    i++;
//                    }
//                }
//                
//                br.close();
//                
//                for(int j = 0; j < temptext.length; j++) {
//                    text += temptext[j];
//                }
//                
//                return text;
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//	
//	public static String ReadDialouge(String location) {
//            File file = new File(location);
//            
//            if(!file.exists()) {
//            String location1 = location;
//            if(Destinyor.home.contains("\\")) {
//                location = "\\Dialouges";
//            } else {
//                location = "//Dialouges";
//            }
//            File dir = new File(location);
//            dir.mkdirs();
//            
//            location = location1;
//            }
//            
//		String dialouge = "";
//		
//		String endDialouge = "";
//		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(location));
//			
//			while(endDialouge != null) {
//				endDialouge = br.readLine();
//				
//				if(endDialouge != null) {
//					dialouge += endDialouge;
//				}
//			}
//			
//			br.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return dialouge;
//	}
//	
//	public static void ReadSettings(String location) {
//            BufferedReader br;
//		String[] Length = { 
//			"Width = ", "Height = ", "Window Mode = "
//		};
//		
//		try{
//			
//			br = new BufferedReader(new FileReader(location));
//			br.mark("@Override".length());
//			if(br.readLine().equals("@Override")) {
//            	Override = true;
//            	DebugWriter.println("Overriding");
//            } else {
//            	br.reset();
//            }
//			br.mark("@Debug".length());
//			
//			if(br.readLine().equals("@Debug")) {
//				Debug = true;
//				DebugWriter.println("Debug");
//				DebugWriter.w++;
//			} else {
//				br.reset();
//			}
//            
//			br.skip(Length[0].length());
//			Resolution.setWidth(Integer.parseInt(br.readLine()));
//			br.skip(Length[1].length());
//			Resolution.setHeight(Integer.parseInt(br.readLine()));
//			br.skip(Length[2].length());
//			Resolution.Fullscreen = br.readLine();
//		
//			br.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public static void ReadPlayer(String location) {
//            BufferedReader br;
//		String[] length = {
//				"Player Name = ",  "Player Gender = ", "Player Level = ", "Player Experience = ", "Player Health = ", "Player Strength = ", "Player Skill = ", "Player Speed = ", "Player Luck = ", "Player Defense = ", "Player Wisdom = ", "Player Gold = ", "Player Resistances = ", "Player Condition = ", "Player X & Y = " 
//		};
//		
//		String name;
//		String gender;
//		int lvl;
//		int exp;
//		int hp;
//		int str;
//		int skl;
//		int spd;
//		int luk;
//		int def;
//                int wis;
//		int gold;
//                
//                String nullChecker = "";
//                int i = -1;
//		
//		
//		try {
//			br = new BufferedReader(new FileReader(location));
//			
//                        br.readLine();
//                        br.readLine();
//                        
//                        while(nullChecker != null) {
//                            if(i < 4)
//                                i++;
//			br.skip(length[0].length());
//			name = br.readLine();
//			PlayerKeys.add(name);
//			br.skip(length[1].length());
//			gender = br.readLine();
//			br.skip(length[2].length());
//			lvl = Integer.parseInt(br.readLine());
//			br.skip(length[3].length());
//			exp = Integer.parseInt(br.readLine());
//			br.skip(length[4].length());
//			hp = Integer.parseInt(br.readLine());
//			br.skip(length[5].length());
//			str = Integer.parseInt(br.readLine());
//			br.skip(length[6].length());
//			skl = Integer.parseInt(br.readLine());
//			br.skip(length[7].length());
//			spd = Integer.parseInt(br.readLine());
//			br.skip(length[8].length());
//			luk = Integer.parseInt(br.readLine());
//			br.skip(length[9].length());
//			def = Integer.parseInt(br.readLine());
//			br.skip(length[10].length());
//			wis = Integer.parseInt(br.readLine());
//                        br.skip(length[11].length());
//			gold = Integer.parseInt(br.readLine());
//			// Resistances
//			//br.skip(length[12].length());
//			br.readLine();
//			// Condition
//			//br.skip(length[13].length());
//			br.readLine();
//			
//			br.skip(length[14].length());
//			String xy = br.readLine();
//			
//			String[] XY = xy.split(",");
//			
//			Player.X = Integer.parseInt(XY[0]);
//			Player.Y = Integer.parseInt(XY[1]);
//			
//			//Entity.entities.put(Key, new Entity(Name, Frame, Gender, LVL, Exp, HP, Str, Skl, Spd, Luk, Def, Gold, Resistance, Condition));
//			Player.addPlayer(name, new Player(name, gender, lvl, exp, hp, str, skl, spd, luk, def, wis, gold, i, null, null));
//			System.out.println("Reader.ReadPlayers: " + name);
//                        DebugWriter.println("Adding: " + name);
//			nullChecker = br.readLine();
//                }
//			
//			br.close();
//		// Wut	
//		} catch (IOException e) {
//			e.printStackTrace();
//                        Errors.setBError1(true);
//                        Errors.setBError8(true);
//                        Errors.WriteErrorLog(Destinyor.DestinyorErrorLog, "IOException was caught, game could not be completed with a IOException");
//                        System.exit(1);
//		}
//		
//		
//	}
//	
//	public static void ReadSpells(String location) {
//		BufferedReader br;
//		String key;
//		String name;
//		String type;
//		int damage;
//		int targets;
//		int cost;
//		String condition;
//		
//		try {
//			br = new BufferedReader(new FileReader(location));
//			
//			br.readLine();
//			br.readLine();
//			//br.readLine();
//			
//			key = br.readLine();
//			name = br.readLine();
//			type = br.readLine();
//			damage = Integer.parseInt(br.readLine());
//			targets = Integer.parseInt(br.readLine());
//			cost = Integer.parseInt(br.readLine());
//			condition = br.readLine();
//			
//			
//			DebugWriter.println("Menu: Adding: " + name);
//			
//			SPELLKEYS.add(key);
//			
//			Spells.spells.put(name, new Spells(name, Element.get(type), damage, targets, cost, condition));
//			
//			br.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//        
//        public static void ReadItems(String location) {
//            BufferedReader br;
//            try {
//            br = new BufferedReader(new FileReader(location));
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        public static void ReadBosses(String location) {
//        	BufferedReader br;
//        	
//        	String[] Stats = {
//        			"Name = ", "FrameStart = ", "FrameEnd = ", ""
//        	};
//        	
//        	String[] StatHolder = new String[18];
//        	
//        	String name;
//        	int frameStart[] = new int[2];
//        	int frameEnd[] = new int[2];
//        	int pos[] = new int[2];
//        	String[] Splitter = new String[2];
//        	String gender;
//        	String level;
//        	String exp;
//        	String hp;
//        	String skl;
//        	String spd;
//        	String luk;
//        	String def;
//        	String gold;
//        	String res;
//        	String cond;
//        	String npc;
//        	
//        	String end = "";
//        	
//        	try {
//                br = new BufferedReader(new FileReader(location));
//                
//               br.readLine();
//               
//               
//               while(end != null) {
//            	   br.readLine();
//            	   for(int i = 0; i < 17; i++) {
//            	   br.skip(Stats[i].length());
//            	   StatHolder[i] = br.readLine().trim();
//            	   }
//            	   Splitter = StatHolder[1].split(",");
//            	   frameStart[0] = Integer.parseInt(Splitter[0]);
//            	   frameStart[1] = Integer.parseInt(Splitter[1]);
//            	   Splitter = StatHolder[2].split(",");
//            	   frameEnd[0] = Integer.parseInt(Splitter[0]);
//            	   frameEnd[1] = Integer.parseInt(Splitter[1]);
//            	   Splitter = StatHolder[2].split(",");
//            	   pos[0] = Integer.parseInt(Splitter[15]);
//            	   pos[1] = Integer.parseInt(Splitter[16]);
//                   String[] SpellGetter = StatHolder[14].split(",");
//                   Spells[] spells = new Spells[SpellGetter.length];
//                   for(int j = 0; j < SpellGetter.length; j++) {
//                       spells[j] = Spells.get(SpellGetter[j]);
//                   }
//            	   Boss boss = new Boss(StatHolder[0], frameStart, frameEnd, StatHolder[3], Integer.parseInt(StatHolder[4]), Integer.parseInt(StatHolder[5]),  Integer.parseInt(StatHolder[6]), Integer.parseInt(StatHolder[7]), Integer.parseInt(StatHolder[8]), Integer.parseInt(StatHolder[9]), Integer.parseInt(StatHolder[10]), Integer.parseInt(StatHolder[11]), Integer.parseInt(StatHolder[12]), Element.get(StatHolder[13]), spells, pos, StatHolder[17]);
//            	   //Boss(String Name, int frameStart, int frameEnd, String Gender, int lvl, int exp, int hp, int str, int skl, int spd, int luk, int def, int gold, Element Resistance, Spells[] spells, int pos, int npc);
//                   //public Enemy(String name, String frame, String gender, int LVL, int EXP, int HP, int STR, int SKL, int SPD, int LUK, int DEF, int GOLD, Element Resistance, Spells[] spells, int pos, int spawn)
//                   end = br.readLine();
//               }
//                
//                br.close();
//                } catch(IOException e) {
//                    e.printStackTrace();
//                }
//        }
	
//	public static List<String> keys() {
//		return KEYS;
//	}
//	
//	public static List<String> spellKeys() {
//		return SPELLKEYS;
//	}
//        
//        public static List<String> PlayerKeys() {
//            return PlayerKeys;
//        }
}
