package com.team04.musiccloud.db.converter;

import com.team04.musiccloud.audio.AudioMeta;
import com.team04.musiccloud.audio.AudioMetaBuilder;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AudioMetaConverter {

    public static Document toDocument(AudioMeta audioMeta) {
        Document document = new Document("title", audioMeta.getTitle())
                .append("author", audioMeta.getAuthor())
                .append("album", audioMeta.getAlbum())
                .append("releaseDate", audioMeta.getReleaseDate().toString());
        if ( audioMeta.getDbId() == null ) {
            document.append("_id", new ObjectId());
        } else {
            document.append("_id", audioMeta.getDbId());
        }

        return document;
    }

    public static AudioMeta toAudioMeta(Document document) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(document.get("releaseDate").toString(), formatter);
        AudioMeta audioMeta = AudioMetaBuilder.builder()
                .setDbId(document.get("_id").toString())
                .setTitle((String) document.get("title"))
                .setAuthor((String) document.get("author"))
                .setAlbum((String) document.get("album"))
                .setReleaseDate(dateTime).build();

        return audioMeta;
    }
}