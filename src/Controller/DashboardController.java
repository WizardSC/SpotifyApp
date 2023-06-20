package Controller;

import Model.SongDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private HBox favoriteContainer;

    @FXML
    private HBox recentlyPlayedContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dsRecentlyPlayed = new ArrayList<>(getRecentlyPlayed());
        dsFavorite = new ArrayList<>(getFavorite());
        try {
            for (SongDTO song : dsRecentlyPlayed) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/song.fxml"));

                VBox vbox = fxmlLoader.load();
                SongController songController = fxmlLoader.getController();
                songController.setData(song);

                recentlyPlayedContainer.getChildren().add(vbox);

            }

            for (SongDTO song : dsFavorite) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/song.fxml"));

                VBox vbox = fxmlLoader.load();
                SongController songController = fxmlLoader.getController();
                songController.setData(song);

                favoriteContainer.getChildren().add(vbox);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<SongDTO> dsRecentlyPlayed;
    ArrayList<SongDTO> dsFavorite;


    private ArrayList<SongDTO> getRecentlyPlayed() {
        ArrayList<SongDTO> listRP = new ArrayList<>();
        SongDTO song = new SongDTO();
        song.setName("Insane");
        song.setArtist("Born To Beat");
        song.setCover("/img/BornToBeat.jpg");
        listRP.add(song);

        song = new SongDTO();
        song.setName("Father");
        song.setArtist("Born To Beat Asia Special Edition");
        song.setCover("/img/Born_To_Beat_(Asia_Special_Edition).jpg");
        listRP.add(song);

        song = new SongDTO();
        song.setName("Irresistible Lips");
        song.setArtist("Born To Beat Asia Special Edition");
        song.setCover("/img/Born_To_Beat_(Asia_Special_Edition).jpg");
        listRP.add(song);

        song = new SongDTO();
        song.setName("WOW");
        song.setArtist("Press Play");
        song.setCover("/img/PressPlay.jpg");
        listRP.add(song);

        song = new SongDTO();
        song.setName("I Only Know Love");
        song.setArtist("Press Play");
        song.setCover("/img/PressPlay.jpg");
        listRP.add(song);

        song = new SongDTO();
        song.setName("2nd Confession");
        song.setArtist("Non-album Single");
        song.setCover("/img/2ndconfession.jpg");
        listRP.add(song);
        for(int i=0;i<10;i++){
            song = new SongDTO();
            song.setName("Emri Olur");
            song.setArtist("Mustafa Cecili");
            song.setCover("/img/emri_olur.jpg");
            listRP.add(song);
        }

        return listRP;
    }

    public ArrayList<SongDTO> getFavorite(){
        ArrayList<SongDTO> listFavorite = new ArrayList<>();
        SongDTO song = new SongDTO();
        song.setName("In The Name Of Love");
        song.setArtist("Martin Garrix, Bebe Rexha");
        song.setCover("/img/In_the_Name_of_Love.jpeg");

        listFavorite.add(song);
        for(int i=0;i<10;i++){
            song = new SongDTO();
            song.setName("Emri Olur");
            song.setArtist("Mustafa Cecili");
            song.setCover("/img/emri_olur.jpg");
            listFavorite.add(song);
        }

        return listFavorite;
    }
}
