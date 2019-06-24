public class Artist {

  private String id;

  private String name;

  private String followers;

  private String imageUrl;

  public Artist() {

  }

  public Artist(String id, String name, String followers, String imageUrl) {
    this.id = id;
    this.followers = followers;
    this.imageUrl = imageUrl;
    this.name = name;
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

  public String getFollowers() {
    return followers;
  }

  public void setFollowers(String followers) {
    this.followers = followers;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
