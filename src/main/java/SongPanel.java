import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SongPanel extends JPanel {

  private JLabel songName;
  private JPanel image;
  private JTextArea details;


  public SongPanel() {
    //construct components
    songName = new JLabel("SongName");
    image = new JPanel();
    details = new JTextArea("Details");

    details.setEditable(false);

    //adjust size and set layout
    setPreferredSize(new Dimension(374, 101));
    setLayout(null);

    //add components
    add(songName);
    add(image);
    add(details);

    //set component bounds (only needed by Absolute Positioning)
    songName.setBounds(145, 10, 215, 25);
    image.setBounds(5, 10, 100, 80);
    details.setBounds(145, 40, 220, 55);
  }

  public JLabel getSongName() {
    return songName;
  }

  public void setSongName(String songName) {
    this.songName.setText(songName);
  }

  public JPanel getImage() {
    return image;
  }

  public void setImage(String imageSource) {
    this.image.removeAll();
    Image image = null;
    try {
      URL url = null;
      url = new URL(imageSource);
      image = ImageIO.read(url);
      JLabel label = new JLabel(new ImageIcon(image));
      this.image.setLayout(new BorderLayout());
      this.image.add(label, BorderLayout.CENTER);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getDetails() {
    return details.getText();
  }

  public void setDetails(String details) {
    this.details.setText(details);
  }

  public void updateSongPanel(SongObject songObject) {
    System.out.print("\n Setting up the song panel\n");
    this.setSongName(songObject.getName());
    this.setImage(songObject.getImageUrl());
    this.setDetails("Date : " + songObject.getDate() + "\n Artist : " + songObject.getArtist());
  }

  public void updateArtistPanel(Artist artist) {
    System.out.print("\n Setting up the song panel\n");
    this.setSongName(artist.getName());
    this.setImage(artist.getImageUrl());
    this.setDetails("Followers : " + artist.getFollowers() + "\n Id : " + artist.getId());
  }

  public void updateAlbumPanel(Album album) {
    System.out.print("\n Setting up the song panel\n");
    this.setSongName(album.getName());
    this.setImage(album.getImageUrl());
    this.setDetails("Artist : " + album.getArtistName() + "\n Date : " + album.getDate());
  }
}