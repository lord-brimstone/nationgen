package nationGen.diagnostics;


import java.util.ArrayList;
import java.util.List;

import nationGen.Generic;

import nationGen.NationGen;
import nationGen.NationGenAssets;
import nationGen.entities.Race;
import nationGen.naming.NameGenerator;


public class NameTester {
	
	public static void main(String[] args)
	{
		
		NationGen ng = new NationGen();
		NationGenAssets assets = new NationGenAssets(ng);
		assets.loadRaces("/data/races/races.txt", ng);
		
		NameGenerator ngen = new NameGenerator(ng);

		Race r = null;
		for(Race r2 : assets.races)
		{
			if(r2.name.equals("Van"))
				r = r2;
		}
		
		List<String> names = new ArrayList<>();
		for(int i = 0; i < 50; i++)
		{
			names.add(ngen.generateNationName(r, null));
		}
		
		if(names.size() > 0)
			System.out.println(Generic.listToString(names, ","));
		
	}
}
