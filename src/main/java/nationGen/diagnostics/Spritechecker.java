package nationGen.diagnostics;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import nationGen.FileUtil;
import nationGen.NationGen;
import nationGen.NationGenAssets;
import nationGen.entities.Pose;
import nationGen.items.Item;

public class Spritechecker {
	public static void main(String[] args)
	{
		NationGen ng = new NationGen();
		
		NationGenAssets assets = new NationGenAssets(ng);
		
		for(String str : assets.poses.keySet())
		{
			List<Pose> pl = assets.poses.get(str);
			for(Pose p : pl)
			{
				for(String slot : p.renderorder.split(" "))
				{
					if(p.getItems(slot) == null)
						continue;
					
					for(Item i : p.getItems(slot))
					{
						if(i.sprite.equals(""))
							continue;
						
						if (!FileUtil.resourceExists(i.sprite)) {
							System.out.println("ERROR IN SPRITE DEFINITIONS!");
							System.out.println("Set " + str + ", pose " + p + ", item " + i + ", slot " + slot + " -> " + i.sprite + " not found.");
						}
						
						if(i.mask.equals("") || i.mask.equals("self"))
							continue;

						if (!FileUtil.resourceExists(i.mask)) {
							System.out.println("ERROR IN MASK DEFINITIONS!");
							System.out.println("Set " + str + ", pose " + p + ", item " + i + ", slot " + slot + " -> " + i.mask + " not found.");
						}

					}
				}
					
			}
		}
		System.out.println("-------------------------------");
		System.out.println("All files checked");

	}
}
