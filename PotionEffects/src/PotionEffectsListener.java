public class PotionEffectsListener extends PluginListener {
	public boolean onCommand(Player player,String[] split){
		if ((split[0].equals("/infect")) && (player.canUseCommand("/infect"))){
		    if ((split.length >5) || (split.length <5)){
				player.sendMessage("§4the correct usage is /infect <player> <effect> §4<amplifier> <duration>");
				return true;
				}
			Player player2 = etc.getServer().matchPlayer(split[1]);
			int amplifier = 0;
			int duration = 0;
			
			if (player2 == null){
				player.sendMessage("§4Player not found.");
				return true;
			}
			
			try{
			amplifier = Integer.parseInt(split[3]);
			duration = Integer.parseInt(split[4]);
			}catch (NumberFormatException nfe){
				player.sendMessage("§4O.o the correct usage is /infect <player> <effect> <amplifier> §4<duration> make sure those 2 are numbers");
				return true;
			}
				if ((!split[2].equals("BLINDNESS"))&&(!split[2].equals("CONFUSION"))&&(!split[2].equals("DAMAGE_BOOST"))&&(!split[2].equals("DIG_SLOW"))&&
					(!split[2].equals("DIG_SPEED"))&&(!split[2].equals("FIRE_RESISTANCE"))&&(!split[2].equals("HARM"))&&(!split[2].equals("HEAL"))&&
					(!split[2].equals("HUNGER"))&&(!split[2].equals("INVISIBILITY"))&&(!split[3].equals("JUMP"))&&(!split[2].equals("MOVE_SPEED"))&&
					(!split[2].equals("NIGHTVISION"))&&(!split[2].equals("POISON"))&&(!split[2].equals("REGENERATION"))&&(!split[2].equals("RESISTANCE"))&&
					(!split[2].equals("SLOW_DOWN"))&&(!split[2].equals("WATER_BREATHING"))&&(!split[2].equals("WEAKNESS"))){
					player.sendMessage("§4You filled in an wrong potion name");
					player.sendMessage("§4to check potion names do /potions");
					return true;
				}else{
					player2.getEntity().e(PotionEffect.getNewPotionEffect(PotionEffect.Type.valueOf(split[2].toUpperCase()), amplifier, duration).potionEffect);
				player.sendMessage("§3player infected with: ");
				player2.sendMessage("§2posion: " +"§4"+ split[2] + "§2 amplifier: " +"§4"+ amplifier +"§2 duration: "+"§4"+duration+"§1!");
				player2.sendMessage("§3"+ player.getName() + " has infected you with posion:");
				player2.sendMessage("§2posion: " +"§4"+ split[2] + "§2 amplifier: " +"§4"+ amplifier +"§2 duration: "+"§4"+duration+"§1!");
				return true;
			}
	}
		if ((split[0].equals("/potions"))&&(player.canUseCommand("/potions"))){
			if (split.length == 1){
				player.sendMessage("§3potions");
				player.sendMessage("§2BLINDNESS");
				player.sendMessage("§2CONFUSION");
				player.sendMessage("§2DAMAGE_BOOST");
				player.sendMessage("§2DIG_SLOW");
				player.sendMessage("§2DIG_SPEED");
				player.sendMessage("§2FIRE_RESISTANCE");
				player.sendMessage("§2HARM");
				player.sendMessage("§5potions list 1/3");
				return true;
			}
			if (split.length == 2){
				if (split[1].equals("1")){
					player.sendMessage("§3potions");
					player.sendMessage("§2BLINDNESS");
					player.sendMessage("§2CONFUSION");
					player.sendMessage("§2DAMAGE_BOOST");
					player.sendMessage("§2DIG_SLOW");
					player.sendMessage("§2DIG_SPEED");
					player.sendMessage("§2FIRE_RESISTANCE");
					player.sendMessage("§2HARM");
					player.sendMessage("§5potions list 1/3");
					return true;
				}
				if (split[1].equals("2")){
					player.sendMessage("§3potions");
					player.sendMessage("§2HEAl");
					player.sendMessage("§2HUNGER");
					player.sendMessage("§2INVISIBILITY");
					player.sendMessage("§2JUMP");
					player.sendMessage("§2MOVE_SPEED");
					player.sendMessage("§2NIGHTVISION");
					player.sendMessage("§2POISON");
					player.sendMessage("§5potions list 2/3");
					return true;
				}
				if (split[1].equals("3")){
					player.sendMessage("§3potions");
					player.sendMessage("§2REGENERATION");
					player.sendMessage("§2RESISTANCE");
					player.sendMessage("§2SLOW_DOWN");
					player.sendMessage("§2WATER_BREATHING");
					player.sendMessage("§2WEAKNESS");
					player.sendMessage("§5potions list 3/3");
					return true;
				}
			}
			return true;
		}
		return false;
}
}