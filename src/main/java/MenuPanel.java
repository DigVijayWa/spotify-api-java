import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.JSONArray;
import org.json.JSONObject;


public class MenuPanel extends JPanel implements ActionListener {

  private JTextField searchBar;
  private JButton searchButton;
  private JRadioButton songRadio;
  private JRadioButton artistRadio;
  private JRadioButton albumRadio;
  private JRadioButton playlistRadio;


  GuiApplication guiApplication;

  private ButtonGroup buttonGroup;

  private static String typeSong = "track";

  public MenuPanel(GuiApplication guiApplication) {

    this.guiApplication = guiApplication;

    //construct components
    searchBar = new JTextField(5);
    searchButton = new JButton("Search");
    songRadio = new JRadioButton("Songs");
    artistRadio = new JRadioButton("Artist");
    albumRadio = new JRadioButton("Album");
    playlistRadio = new JRadioButton("Playlist");

    buttonGroup = new ButtonGroup();

    buttonGroup.add(songRadio);
    buttonGroup.add(artistRadio);
    buttonGroup.add(albumRadio);
    buttonGroup.add(playlistRadio);

    //adjust size and set layout
    setPreferredSize(new Dimension(944, 150));
    setLayout(null);

    searchButton.addActionListener(this);
    songRadio.addActionListener(this);
    artistRadio.addActionListener(this);
    albumRadio.addActionListener(this);
    playlistRadio.addActionListener(this);

    //add components
    add(searchBar);
    add(searchButton);
    add(songRadio);
    add(artistRadio);
    add(albumRadio);
    add(playlistRadio);

    //set component bounds (only needed by Absolute Positioning)
    searchBar.setBounds(675, 10, 170, 30);
    searchButton.setBounds(860, 10, 80, 30);
    songRadio.setBounds(140, 85, 160, 40);
    artistRadio.setBounds(340, 75, 185, 65);
    albumRadio.setBounds(570, 80, 165, 55);
    playlistRadio.setBounds(775, 80, 145, 50);
  }

  //to populate Song object list on JSON response
  public ArrayList<SongObject> mapSongObjectWithJsonObject(JSONObject jsonObject) {
    ArrayList<SongObject> songObjectList = new ArrayList<>();

    Map trackItems = ((JSONObject) jsonObject.get(typeSong + "s")).toMap();
    ArrayList<JSONObject> jsonArrayItems = (ArrayList<JSONObject>) trackItems.get("items");

    for (int i = 0; i < jsonArrayItems.size(); i++) {
      Map jsonItem = (Map<String, Object>) jsonArrayItems.get(i);

      Map jsonObjectAlbum = (Map<String, Object>) jsonItem.get("album");

      ArrayList<JSONObject> jsonArrayArtists = (ArrayList<JSONObject>) jsonObjectAlbum
          .get("artists");

      ArrayList<JSONObject> jsonArrayImages = (ArrayList<JSONObject>) jsonObjectAlbum.get("images");

      //extracting the date
      String date = (String) jsonObjectAlbum.get("release_date");

      //extracting the image
      Map image = (Map<String, Object>) (jsonArrayImages.get(jsonArrayImages.size() - 1));
      String imageUrl = (String) image.get("url");

      //extracting the id
      String songId = (String) jsonObjectAlbum.get("id");

      //extracting the name of the artist
      Map artist = (Map<String, Object>) (jsonArrayArtists.get(0));
      String artistName = (String) artist.get("name");

      //extracting the name of the song :
      String songName = (String) jsonItem.get("name");

      songObjectList.add(new SongObject(songId, songName, artistName, date, imageUrl));
    }
    System.out.print(songObjectList.size());
    return songObjectList;
  }

  //to populate Artist object list on JSON response
  //due to json response is different for different queries need to make different methods.
  public ArrayList<Artist> mapArtistObjectWithJsonObject(JSONObject jsonObject) {
    ArrayList<Artist> artistArrayList = new ArrayList<>();

    Map trackItems = ((JSONObject) jsonObject.get(typeSong + "s")).toMap();
    ArrayList<JSONObject> jsonArrayItems = (ArrayList<JSONObject>) trackItems.get("items");

    for (int i = 0; i < jsonArrayItems.size(); i++) {
      Map jsonItem = (Map<String, Object>) jsonArrayItems.get(i);

      String id = (String) jsonItem.get("id");

      String name = (String) jsonItem.get("name");

      Map jsonItemFollower = (Map<String, Object>) jsonItem.get("followers");

      String followers = "" + ((Integer) jsonItemFollower.get("total"));

      ArrayList<JSONObject> jsonArrayImages = (ArrayList<JSONObject>) jsonItem.get("images");
      Map image = null;
      String imageUrl = "";
      if (jsonArrayImages.size() > 0) {
        image = (Map<String, Object>) (jsonArrayImages.get(jsonArrayImages.size() - 1));
        imageUrl = (String) image.get("url");
      } else {
        image = new HashMap();
        imageUrl = "https://i.scdn.co/image/ed213a32e1327f3f2d7b2539eb1db57f55b68dbb";
      }

      artistArrayList.add(new Artist(id, name, followers, imageUrl));
    }
    System.out.print(artistArrayList.size());
    return artistArrayList;
  }


  public ArrayList<Album> mapAlbumObjectWithJsonObject(JSONObject jsonObject) {
    ArrayList<Album> artistArrayList = new ArrayList<>();

    Map trackItems = ((JSONObject) jsonObject.get(typeSong + "s")).toMap();
    ArrayList<JSONObject> jsonArrayItems = (ArrayList<JSONObject>) trackItems.get("items");

    for (int i = 0; i < jsonArrayItems.size(); i++) {
      Map jsonItem = (Map<String, Object>) jsonArrayItems.get(i);

      String id = (String) jsonItem.get("id");

      String name = (String) jsonItem.get("name");

      ArrayList<JSONObject> jsonArrayArtists = (ArrayList<JSONObject>) jsonItem.get("artists");

      ArrayList<JSONObject> jsonArrayImages = (ArrayList<JSONObject>) jsonItem.get("images");
      Map image = null;
      String imageUrl = "";
      if (jsonArrayImages.size() > 0) {
        image = (Map<String, Object>) (jsonArrayImages.get(jsonArrayImages.size() - 1));
        imageUrl = (String) image.get("url");
      } else {
        image = new HashMap();
        imageUrl = "https://i.scdn.co/image/ed213a32e1327f3f2d7b2539eb1db57f55b68dbb";
      }
      String artistName = "";
      Map artist = null;
      if (jsonArrayArtists.size() > 0) {
        artist = (Map<String, Object>) (jsonArrayArtists.get(0));
        artistName = (String) artist.get("name");
      } else {
        artist = new HashMap();
        artistName = "UNKNOWN ARTIST";
      }

      String relaeaseDate = (String) jsonItem.get("release_date");

      artistArrayList.add(new Album(id, name, relaeaseDate, imageUrl, artistName));
    }
    System.out.print(artistArrayList.size());
    return artistArrayList;
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == searchButton && App.readyForApiCalls) {

      System.out.print("\n Search is pressed\n");

      String search = searchBar.getText();
      search = getFormattedText(search);
      System.out.print("\n Search : " + search + "\n");
      String query = "?q=" + search + "&type=" + typeSong;

      JSONObject jsonObject = AjaxService
          .callSearch(query, App.getAccessToken(), App.getTokenType());

      if (typeSong == "track") {
        ArrayList<SongObject> songObjectList = mapSongObjectWithJsonObject(jsonObject);
        System.out.print("\n 2 : " + songObjectList.size());
        guiApplication.getContentPanel().updateContentPanelSong(songObjectList);
      } else if (typeSong == "artist") {
        ArrayList<Artist> artistList = mapArtistObjectWithJsonObject(jsonObject);
        System.out.print("\n 2 : " + artistList.size());
        guiApplication.getContentPanel().updateContentPanelArtist(artistList);
      } else if (typeSong == "album") {
        ArrayList<Album> artistList = mapAlbumObjectWithJsonObject(jsonObject);
        System.out.print("\n 2 : " + artistList.size());
        guiApplication.getContentPanel().updateContentPanelAlbum(artistList);
      }


    } else if (e.getSource() == albumRadio) {
      typeSong = "album";
      System.out.print("\n albumRadio is typed\n");
    } else if (e.getSource() == songRadio) {
      typeSong = "track";
      System.out.print("\n songRadio is typed\n");
    } else if (e.getSource() == artistRadio) {
      typeSong = "artist";
      System.out.print("\n artistRadio is typed\n");
    } else if (e.getSource() == playlistRadio) {
      System.out.print("\n playlistRadio is typed\n");
    }

  }

  public String getFormattedText(String text) {
    text = text.trim();
    text = text.replaceAll("\\s", "%20");
    return text;
  }
}
