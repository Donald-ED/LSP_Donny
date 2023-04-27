package org.howard.edu.lsp.finals.problem;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SongsDatabase {
    private Map<String, HashSet<String>> map = new ConcurrentHashMap<>();

    public void addSong(String genre, String songTitle) {
        if (genre == null || genre.isEmpty() || songTitle == null || songTitle.isEmpty()) {
            throw new IllegalArgumentException("Genre and song title must not be null or empty.");
        }

        HashSet<String> songs = map.getOrDefault(genre, new HashSet<>());
        songs.add(songTitle);
        map.put(genre, songs);
    }

    public Set<String> getSongs(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre must not be null or empty.");
        }
        return map.getOrDefault(genre, new HashSet<>());
    }

    public String getGenreOfSong(String songTitle) {
        if (songTitle == null || songTitle.isEmpty()) {
            throw new IllegalArgumentException("Song title must not be null or empty.");
        }

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
