package Controller;

import Model.SongDTO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class SongController {
    @FXML
    private Label artist;

    @FXML
    private ImageView img;

    @FXML
    private Label songName;

    public void setData(SongDTO song){
        Image image = new Image(getClass().getResourceAsStream(song.getCover()));
        img.setImage(image);
        artist.setText(song.getArtist());
        songName.setText(song.getName());
        
    }
}
