package org.howard.edu.lsp.finals.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SongsDatabaseTest {
    private SongsDatabase db;

    @BeforeEach
    void setUp() {
        db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
    }

    @Test
    void testAddSongAndGetSongs() {
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
        assertFalse(rapSongs.contains("Always There"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertTrue(jazzSongs.contains("Always There"));
        assertFalse(jazzSongs.contains("Savage"));
        assertFalse(jazzSongs.contains("Gin and Juice"));
        
        assertThrows(IllegalArgumentException.class, () -> db.addSong(null, "Test Song"));
        assertThrows(IllegalArgumentException.class, () -> db.addSong("", "Test Song"));
        assertThrows(IllegalArgumentException.class, () -> db.addSong("Test Genre", null));
        assertThrows(IllegalArgumentException.class, () -> db.addSong("Test Genre", ""));
        assertThrows(IllegalArgumentException.class, () -> db.getSongs(null));
        assertThrows(IllegalArgumentException.class, () -> db.getSongs(""));
    }

    @Test
    void testGetGenreOfSong() {
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Rap", db.getGenreOfSong("Gin and Juice"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("Non-existent Song"));
        assertThrows(IllegalArgumentException.class, () -> db.getGenreOfSong(null));
        assertThrows(IllegalArgumentException.class, () -> db.getGenreOfSong(""));
    }
}
