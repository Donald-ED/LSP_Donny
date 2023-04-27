package org.howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    private Map<String, HashSet<String>> map = new HashMap<>();

    public void addSong(String genre, String songTitle) {
        HashSet<String> songs = map.getOrDefault(genre, new HashSet<>());
        songs.add(songTitle);
        map.put(genre, songs);
    }

    public Set<String> getSongs(String genre) {
        return map.getOrDefault(genre, new HashSet<>());
    }

    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}