package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Lyrics;

public class LyricsRepository {

	// Campos de clase

	private static LyricsRepository INSTANCE;

	// Campos de instancia

	Map<String, Lyrics> lyricsMap;

	private int index;

	// Inicializador de clase

	static {
		INSTANCE = new LyricsRepository();
	}

	// Inicializador de instancia

	private LyricsRepository() {
		// Inicializar parámetros del repositorio
		lyricsMap = new HashMap<String, Lyrics>();
		index = -1;
		// Rellenar el repositorio
		this.addLyrics(new Lyrics("" +
				"Hello, it's me\n" + 
				"I was wondering if after all these years you'd like to meet\n" + 
				"To go over everything\n" + 
				"They say that time's supposed to heal ya\n" + 
				"But I ain't done much healing\n" + 
				"\n" + 
				"Hello, can you hear me?\n" + 
				"I'm in California dreaming about who we used to be\n" + 
				"When we were younger and free\n" + 
				"I've forgotten how it felt before the world fell at our feet\n" + 
				"\n" + 
				"There's such a difference between us\n" + 
				"And a million miles\n" + 
				"\n" + 
				"Hello from the other side\n" + 
				"I must've called a thousand times\n" + 
				"To tell you I'm sorry for everything that I've done\n" + 
				"But when I call, you never seem to be home\n" + 
				"\n" + 
				"Hello from the outside\n" + 
				"At least I can say that I've tried\n" + 
				"To tell you I'm sorry for breaking your heart\n" + 
				"But it don't matter, it clearly doesn't tear you apart anymore\n" + 
				"\n" + 
				"Hello, how are you?\n" + 
				"It's so typical of me to talk about myself, I'm sorry\n" + 
				"I hope that you're well\n" + 
				"Did you ever make it out of that town where nothing ever happened?\n" + 
				"\n" + 
				"It's no secret that the both of us are running out of time\n" + 
				"\n" + 
				"So hello from the other side\n" + 
				"I must've called a thousand times\n" + 
				"To tell you I'm sorry for everything that I've done\n" + 
				"But when I call, you never seem to be home\n" + 
				"\n" + 
				"Hello from the outside\n" + 
				"At least I can say that I've tried\n" + 
				"To tell you I'm sorry for breaking your heart\n" + 
				"But it don't matter, it clearly doesn't tear you apart anymore\n" + 
				"\n" + 
				"Oooooh, anymore\n" + 
				"Oooooh, anymore\n" + 
				"Oooooh, anymore\n" + 
				"Anymore\n" + 
				"\n" + 
				"Hello from the other side\n" + 
				"I must've called a thousand times\n" + 
				"To tell you I'm sorry for everything that I've done\n" + 
				"But when I call, you never seem to be home\n" + 
				"\n" + 
				"Hello from the outside\n" + 
				"At least I can say that I've tried\n" + 
				"To tell you I'm sorry for breaking your heart\n" + 
				"But it don't matter, it clearly doesn't tear you apart anymore"));
		this.addLyrics(new Lyrics("" +
				"How can you see into my eyes like open doors?\n" + 
				"Leading you down into my core, where I've become so numb\n" + 
				"Without a soul, my spirit's sleeping somewhere cold\n" + 
				"Until you find it there and lead it back home\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Wake me up inside (I can't wake up)\n" + 
				"Wake me up inside (save me)\n" + 
				"Call my name and save me from the dark\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Bid my blood to run (I can't wake up)\n" + 
				"Before I come undone (save me)\n" + 
				"Save me from the nothing I've become\n" + 
				"\n" + 
				"Now that I know what I'm without\n" + 
				"You can't just leave me\n" + 
				"Breathe into me and make me real\n" + 
				"Bring me to life\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Wake me up inside (I can't wake up)\n" + 
				"Wake me up inside (save me)\n" + 
				"Call my name and save me from the dark\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Bid my blood to run (I can't wake up)\n" + 
				"Before I come undone (save me)\n" + 
				"Save me from the nothing I've become\n" + 
				"\n" + 
				"Bring me to life\n" + 
				"(I've been living a lie, there's nothing inside)\n" + 
				"Bring me to life\n" + 
				"\n" + 
				"Frozen inside without your touch, without your love\n" + 
				"Darling, only you are the life among the dead\n" + 
				"\n" + 
				"All this time, I can't believe I couldn't see\n" + 
				"Kept in the dark, but you were there in front of me\n" + 
				"I've been sleeping a thousand years, it seems\n" + 
				"Got to open my eyes to everything\n" + 
				"\n" + 
				"Without a thought, without a voice, without a soul\n" + 
				"Don't let me die here (there must be something more)\n" + 
				"Bring me to life\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Wake me up inside (I can't wake up)\n" + 
				"Wake me up inside (save me)\n" + 
				"Call my name and save me from the dark\n" + 
				"\n" + 
				"(Wake me up)\n" + 
				"Bid my blood to run (I can't wake up)\n" + 
				"Before I come undone (save me)\n" + 
				"Save me from the nothing I've become\n" + 
				"\n" + 
				"Bring me to life\n" + 
				"(I've been living a lie, there's nothing inside)\n" + 
				"Bring me to life"));
	}

	// Métodos de clase

	public static LyricsRepository getInstance() {
		return INSTANCE;
	}

	// Métodos de instancia

	public Lyrics getLyrics(String id) {
		return lyricsMap.get(id);
	}

	public Collection<Lyrics> getAll() {
		return lyricsMap.values();
	}

	public void addLyrics(Lyrics lyrics) {
		String id = "l" + ++index;
		lyrics.setId(id);
		lyricsMap.put(id, lyrics);
	}

	public void updateLyrics(Lyrics lyrics) {
		lyricsMap.put(lyrics.id, lyrics);
	}

	public void deleteLyrics(String id) {
		lyricsMap.remove(id);
	}

}
