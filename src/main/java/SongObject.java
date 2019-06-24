public class SongObject {

  private String id;

  private String name;

  private String artist;

  private String date;

  private String imageUrl;

  public SongObject() {
    this.name = "default_name";
    this.artist = "";
    this.date = "UNDEFINED";
    this.imageUrl = "LOCAL Image";
    this.id = "";
  }

  public SongObject(String id, String name, String artist, String date, String imageUrl) {
    this.name = name;
    this.date = date;
    this.artist = artist;
    this.imageUrl = imageUrl;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String toString() {
    return "name : " + this.name + "\n" +
        "Artist : " + this.artist + "\n" +
        "Date : " + this.date + "\n" +
        "Image : " + this.imageUrl + "\n" +
        "Id : " + this.id + "\n";
  }

}
