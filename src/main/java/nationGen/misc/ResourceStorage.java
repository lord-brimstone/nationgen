package nationGen.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import nationGen.FileUtil;
import nationGen.NationGen;
import nationGen.entities.Entity;


import nationGen.Generic;

public class ResourceStorage<E extends Entity> extends LinkedHashMap<String, List<E>>{
	private static final long serialVersionUID = 1L;
	
	private Class<E> type;
	private NationGen gen;
	public ResourceStorage(Class<E> type, NationGen nationGen)
	{
		this.type = type;
		this.gen = nationGen;
	}
	
	
	public LinkedHashMap<E, Double> getHashMap(String name)
	{
		List<E> list = this.get(name);
		if(list == null)
			return null;
		
		LinkedHashMap<E, Double> set = new LinkedHashMap<E, Double>();
		for(E i : list)
		{
			set.put(i, i.basechance);			
		}
		return set;
	}

	
	
	public void load(String file)
	{
		for (String strLine : FileUtil.readLines(file)) {
			List<String> args = Generic.parseArgs(strLine);
			if (args.size() == 0)
				continue;
			
			if (args.get(0).equals("#load")) {
				
				List<E> items = new ArrayList<E>();
				items.addAll(Entity.readFile(gen, args.get(2), type));
				this.put(args.get(1), items);
			}
		}
	}

}
