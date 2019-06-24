import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;

public class ContentPanel extends JPanel {

  List<SongPanel> songPanelList = new ArrayList<>();

  List<SongObject> songList = new ArrayList<>();

  GuiApplication guiApplication;

  public ContentPanel(GuiApplication guiApplication) {
    //construct components

    this.guiApplication = guiApplication;

    //adjust size and set layout
    setPreferredSize(new Dimension(944, 413));
    GridLayout layout = new GridLayout(3, 2, 15, 15);
    setLayout(layout);

    //add components
    for (int i = 0; i < 6; i++) {
      songPanelList.add(new SongPanel());
      this.add(songPanelList.get(i));
    }
  }

  public List<SongPanel> getSongPanelList() {
    return songPanelList;
  }

  public void setSongPanelList(List<SongPanel> songPanelList) {
    this.songPanelList = songPanelList;
  }

  public GuiApplication getGuiApplication() {
    return guiApplication;
  }

  public void setGuiApplication(GuiApplication guiApplication) {
    this.guiApplication = guiApplication;
  }

  public void updateContentPanelSong(ArrayList<SongObject> songObjectList) {
    System.out.print("\n Size : " + songObjectList.size());
    for (int i = 0; i < songPanelList.size() && i < songObjectList.size(); i++) {
      songPanelList.get(i).updateSongPanel(songObjectList.get(i));
    }
  }

  public void updateContentPanelArtist(ArrayList<Artist> songObjectList) {
    System.out.print("\n Size : " + songObjectList.size());
    for (int i = 0; i < songPanelList.size() && i < songObjectList.size(); i++) {
      songPanelList.get(i).updateArtistPanel(songObjectList.get(i));
    }
  }

  public void updateContentPanelAlbum(ArrayList<Album> songObjectList) {
    System.out.print("\n Size : " + songObjectList.size());
    for (int i = 0; i < songPanelList.size() && i < songObjectList.size(); i++) {
      songPanelList.get(i).updateAlbumPanel(songObjectList.get(i));
    }
  }
}
