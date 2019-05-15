package com.team04.musiccloud.audio;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileMetaTest {
    private final static String ID = "id";
    private final static String DIRECTORY = "dir";
    private final static String NAME = "name";
    private final static String EXTENSION = "ext";
    private final static String USER = "usr";
    
    @Test
    public void constructorTest() {
        FileMeta fileMeta1 = new FileMeta("", "", "", "");
        assertNotNull(fileMeta1);
        
        FileMeta fileMeta2 = new FileMeta("", "", "", "", "");
        assertNotNull(fileMeta2);
        
        FileMeta fileMeta3 = new FileMeta(fileMeta1);
        assertNotNull(fileMeta3);
    }
    
    @Test
    public void equalityTest() {
        FileMeta fileMeta1 = new FileMeta(ID, DIRECTORY, NAME, EXTENSION, USER);
        FileMeta fileMeta2 = new FileMeta(ID, DIRECTORY, NAME, EXTENSION, USER);
        FakeFileMeta fakeFileMeta = new FakeFileMeta();
        
        assertEquals(fileMeta1, fileMeta1);
        assertEquals(fileMeta1, fileMeta2);
        assertNotEquals(null, fileMeta1);
        assertNotEquals(fakeFileMeta, fileMeta1);
        
        assertEquals(fileMeta1.hashCode(), fileMeta2.hashCode());
    }
    
    private class FakeFileMeta {
    }
    
    @Test
    public void hasTest() {
        FileMeta fileMeta = new FileMeta(ID, DIRECTORY, NAME, EXTENSION, USER);
        
        assertTrue(fileMeta.hasDbId());
        assertTrue(fileMeta.hasDirectory());
        assertTrue(fileMeta.hasName());
        assertTrue(fileMeta.hasExtension());
        assertTrue(fileMeta.hasUser());
        assertFalse(fileMeta.isEmpty());
    }
    
    @Test
    public void getterTest() {
        FileMeta fileMeta = new FileMeta(ID, DIRECTORY, NAME, EXTENSION, USER);
        
        assertEquals(ID, fileMeta.getDbId());
        assertEquals(DIRECTORY, fileMeta.getDirectory());
        assertEquals(Paths.get(DIRECTORY), fileMeta.getDirectoryAsPath());
        assertEquals(NAME, fileMeta.getName());
        assertEquals(EXTENSION, fileMeta.getExtension());
        assertEquals(USER, fileMeta.getUser());
    }
    
    @Test
    public void additionalGetterTest() {
        FileMeta fileMeta = new FileMeta(ID, DIRECTORY, NAME, EXTENSION, USER);
        
        final Path expectedFullPath = Paths.get(DIRECTORY, NAME + '.' + EXTENSION).toAbsolutePath();
        assertEquals(expectedFullPath, fileMeta.getFullPath());
        assertEquals(expectedFullPath.toFile(), fileMeta.getFullPathAsFile());
        
        final String expectedNameExtension = NAME + '.' + EXTENSION;
        assertEquals(expectedNameExtension, fileMeta.getNameExtension());
    }
}