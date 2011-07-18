/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @author joaquin
 */
public class MusicTAGS implements IMusicTAGS {

    private String Titulo;
    private String Artista;
    private String Album;
    private File f;

    public MusicTAGS() {
        //No hago nada :)
    }

    @Override
    public void obtenerTAGS(File f) {
        try {
            AudioFile mFile = AudioFileIO.read(f);
            Tag tag = mFile.getTag();
            AudioHeader a = mFile.getAudioHeader();
            this.setTitulo(tag.getFirst(FieldKey.TITLE));
            this.setArtista(tag.getFirst(FieldKey.ARTIST));
            this.setAlbum(tag.getFirst(FieldKey.ALBUM));
        } catch (Exception ex) {
            System.out.println("ERROR en tags");
        }
    }

    /**
     * @return the Titulo
     */
    @Override
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @param Titulo the Titulo to set
     */
    @Override
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * @return the Artista
     */
    @Override
    public String getArtista() {
        return Artista;
    }

    /**
     * @param Artista the Artista to set
     */
    @Override
    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    /**
     * @return the Album
     */
    @Override
    public String getAlbum() {
        return Album;
    }

    /**
     * @param Album the Album to set
     */
    @Override
    public void setAlbum(String Album) {
        this.Album = Album;
    }
}
