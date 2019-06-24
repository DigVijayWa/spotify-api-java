public class Album {

  private String id;

  private String name;

  private String date;

  private String artistName;

  private String imageUrl;

  public Album() {

  }

  public Album(String id, String name, String date, String imageUrl, String artistName) {
    this.id = id;
    this.date = date;
    this.imageUrl = imageUrl;
    this.name = name;
    this.artistName = artistName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }
}
